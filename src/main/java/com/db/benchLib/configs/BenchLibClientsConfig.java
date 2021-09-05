package com.db.benchLib.configs;

import com.db.benchLib.clients.BenchesServiceClient;
import com.db.benchLib.clients.RequestsServiceClient;
import com.db.benchLib.utils.FeignSpringFormEncoder;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BenchLibClientsConfig {

    @Bean
    @ConditionalOnProperty({"benchesService.host", "benchesService.port"})
    public BenchesServiceClient benchesService(@Value("${benchesService.host}") String host,
                                               @Value("${benchesService.port}") int port) {
        String url = String.format("http://%s:%d/api/benches", host, port);
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(BenchesServiceClient.class))
                .logLevel(Logger.Level.FULL)
                .target(BenchesServiceClient.class, url);
    }

    @Bean
    @ConditionalOnProperty({"requestsService.host", "requestsService.port"})
    public RequestsServiceClient requestsService(@Value("${requestsService.host}") String host,
                                               @Value("${requestsService.port}") int port) {
        String url = String.format("http://%s:%d/api/requests", host, port);
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new FeignSpringFormEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(RequestsServiceClient.class))
                .logLevel(Logger.Level.FULL)
                .target(RequestsServiceClient.class, url);
    }

}
