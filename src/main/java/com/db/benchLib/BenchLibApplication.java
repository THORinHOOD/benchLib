package com.db.benchLib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BenchLibApplication {

	public static void main(String[] args) {
		SpringApplication.run(BenchLibApplication.class, args);
	}

}
