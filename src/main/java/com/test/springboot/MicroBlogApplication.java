package com.test.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class MicroBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroBlogApplication.class, args);
	}

}
