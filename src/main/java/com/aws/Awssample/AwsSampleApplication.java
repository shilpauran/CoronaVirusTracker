package com.aws.Awssample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AwsSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsSampleApplication.class, args);
	}

}
