package com.cjc.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
private int i=50;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
