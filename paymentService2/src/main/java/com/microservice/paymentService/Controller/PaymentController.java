package com.microservice.paymentService.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
	
	@GetMapping(value = "/payment")
	public String placeOrder() {
		System.out.println("second");
		return "payment Done";
	}
}
