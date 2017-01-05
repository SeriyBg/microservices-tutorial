package com.micro.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MicrotutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicrotutorialApplication.class, args);
	}
}
