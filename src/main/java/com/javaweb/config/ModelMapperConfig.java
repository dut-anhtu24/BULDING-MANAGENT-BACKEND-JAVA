package com.javaweb.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
	@Bean
	// Tu dong map cac cot du lieu trung ten, trung kieu du lieu
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
