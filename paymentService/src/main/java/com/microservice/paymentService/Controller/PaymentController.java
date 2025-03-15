package com.microservice.paymentService.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@GetMapping(value = "/paymentOrder")
	public String placeOrder() {
		System.out.println("first");
		return "payment Done";
	}
}
