package com.microservice.order_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient; 
	
	@GetMapping(value = "/")
	public String placeOrder() {
		
	ServiceInstance serviceInstance = loadBalancerClient.choose("paymentService");
	String uri = serviceInstance.getUri().toString();
		System.out.println(uri);
		String ans =  restTemplate.getForObject(uri + "/payment/paymentOrder" , String.class);
		return ans;
	}
}
