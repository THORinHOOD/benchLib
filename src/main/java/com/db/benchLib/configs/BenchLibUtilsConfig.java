package com.db.benchLib.configs;

import com.db.benchLib.services.MultipartFileService;
import com.db.benchLib.services.MultipartFileServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BenchLibUtilsConfig {

    @Bean
    public MultipartFileService multipartFileService() {
        return new MultipartFileServiceImpl();
    }

}
