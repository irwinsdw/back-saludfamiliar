package com.example.DIRESA.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.json.JsonMapper;

@Configuration
public class GlobalConfig {

	@Bean
	public JsonMapper getJsonMapper() {
		return new JsonMapper();
	}
		@Bean
		public WebMvcConfigurer corsConfigurer() {
			return new WebMvcConfigurer() {
				@Override
				public void addCorsMappings(CorsRegistry registry) {
					registry
					.addMapping("/**") //Doble **
					.allowedMethods("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
					.allowedOrigins("http://localhost:4200");
				}
			};
		}
	}
