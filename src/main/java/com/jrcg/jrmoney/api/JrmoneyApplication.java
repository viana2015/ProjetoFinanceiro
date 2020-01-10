package com.jrcg.jrmoney.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.jrcg.jrmoney.api.config.property.JrmoneyProperty;

@SpringBootApplication
@EnableConfigurationProperties(JrmoneyProperty.class)
public class JrmoneyApplication {

	public static void main(String[] args) {
		SpringApplication.run(JrmoneyApplication.class, args);
	}

}
