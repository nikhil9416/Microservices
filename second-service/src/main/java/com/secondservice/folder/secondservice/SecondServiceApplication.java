package com.secondservice.folder.secondservice;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.secondservice.folder.secondservice.*")
@EnableFeignClients("com.secondservice.folder.secondservice.")
@EnableAutoConfiguration
@EnableDiscoveryClient
public class SecondServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondServiceApplication.class, args);
	}


	@Bean
	public Sampler defaultSampler(){

		return Sampler.ALWAYS_SAMPLE;
	}


}
