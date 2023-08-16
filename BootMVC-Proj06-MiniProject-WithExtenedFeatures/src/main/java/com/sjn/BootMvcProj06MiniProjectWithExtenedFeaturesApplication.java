package com.sjn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication
public class BootMvcProj06MiniProjectWithExtenedFeaturesApplication {
	@Bean(name="messageSource")
	public ResourceBundleMessageSource bundleMessageSource() {
	ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	messageSource.setBasename("Validation");
	return messageSource;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj06MiniProjectWithExtenedFeaturesApplication.class, args);
	}

}
