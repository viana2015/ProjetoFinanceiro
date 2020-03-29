package com.jrcg.jrmoney.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

import com.jrcg.jrmoney.api.config.property.JrmoneyProperty;

@SpringBootApplication
@EnableConfigurationProperties(JrmoneyProperty.class)
public class JrmoneyApplication {

	private static ApplicationContext APPLICATION_CONTEXT;
	
	public static void main(String[] args) {
		APPLICATION_CONTEXT = SpringApplication.run(JrmoneyApplication.class, args);
		
	}
	
	public static<T> T getBean(Class<T> type) {
		return APPLICATION_CONTEXT.getBean(type);
	}

}
