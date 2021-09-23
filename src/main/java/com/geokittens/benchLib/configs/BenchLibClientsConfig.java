package com.geokittens.benchLib.configs;

import com.geokittens.benchLib.clients.RequestsServiceClient;
import com.geokittens.benchLib.utils.FeignSpringFormEncoder;
import com.geokittens.benchLib.utils.InMemoryMultipartFile;
import feign.Feign;
import feign.Logger;
import feign.codec.Decoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

@Configuration
public class BenchLibClientsConfig {

    private final ObjectFactory<HttpMessageConverters> messageConverters;

    public BenchLibClientsConfig(ObjectFactory<HttpMessageConverters> messageConverters) {
        this.messageConverters = messageConverters;
    }

    @Bean
    @ConditionalOnProperty({"requestsService.host", "requestsService.port"})
    public RequestsServiceClient requestsService(@Value("${requestsService.host}") String host,
                                                 @Value("${requestsService.port}") int port) {
        String url = String.format("http://%s:%d/api/requests", host, port);
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new FeignSpringFormEncoder())
                .decoder(decoder())
                .logger(new Slf4jLogger(RequestsServiceClient.class))
                .logLevel(Logger.Level.FULL)
                .target(RequestsServiceClient.class, url);
    }

    private Decoder decoder() {
        Decoder decoder = (response, type) -> {
            if (type instanceof Class && MultipartFile.class.isAssignableFrom((Class) type)) {
                Collection<String> contentTypes = response.headers().get("content-type");
                String contentType = "application/octet-stream";
                if (contentTypes.size() > 0) {
                    String[] temp = new String[contentTypes.size()];
                    contentTypes.toArray(temp);
                    contentType = temp[0];
                }
                byte[] bytes = StreamUtils.copyToByteArray(response.body().asInputStream());
                return new InMemoryMultipartFile("file","", contentType,bytes);
            }
            return new SpringDecoder(messageConverters).decode(response, type);
        };
        return new ResponseEntityDecoder(decoder);
    }


}
