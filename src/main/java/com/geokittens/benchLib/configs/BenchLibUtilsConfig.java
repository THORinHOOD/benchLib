package com.geokittens.benchLib.configs;

import com.geokittens.benchLib.services.MultipartFileService;
import com.geokittens.benchLib.services.MultipartFileServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BenchLibUtilsConfig {

    @Bean
    public MultipartFileService multipartFileService() {
        return new MultipartFileServiceImpl();
    }

}
