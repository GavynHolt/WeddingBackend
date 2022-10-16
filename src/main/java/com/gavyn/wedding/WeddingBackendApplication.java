package com.gavyn.wedding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class WeddingBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeddingBackendApplication.class, args);
	}

}
