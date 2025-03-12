package com.microservice.paymentService.Cofigure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApiCallConfiguration {
	
	 @Bean
	  public RestTemplate restTemplateBean() {
	        return new RestTemplate();
	   }
}
