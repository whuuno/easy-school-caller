package com.practice.easyschoolcaller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.practice.easyschoolcaller.proxy")
public class EasySchoolCallerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasySchoolCallerApplication.class, args);
	}

}
