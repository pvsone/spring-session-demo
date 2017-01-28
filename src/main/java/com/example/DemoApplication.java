package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

// Spring Session automatically configures Redis if available, so explicit config is not required
//@EnableRedisHttpSession
//class HttpSessionConfig {
//}
