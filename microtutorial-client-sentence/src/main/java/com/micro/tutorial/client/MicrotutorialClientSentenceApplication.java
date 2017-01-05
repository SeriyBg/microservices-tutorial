package com.micro.tutorial.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicrotutorialClientSentenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicrotutorialClientSentenceApplication.class, args);
	}
}
