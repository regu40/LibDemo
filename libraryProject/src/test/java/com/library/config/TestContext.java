package com.library.config;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.library.service.LoginService;

@Configuration
public class TestContext {

	 /*	@Bean
	    public LoginService serviceMock() {
	        return Mockito.mock(LoginService.class);
	    }*/
	
	 @Bean
	    public LocalValidatorFactoryBean validator() {
	        return new LocalValidatorFactoryBean();
	    }
	 
}
