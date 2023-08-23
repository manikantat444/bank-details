package com.bank.details.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bank.details.proxy.Limits;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class CircuitBreakerController {
	
	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

	@GetMapping("/getLimits")
	@CircuitBreaker(name = "default", fallbackMethod = "fallbackResponse")
	public String getLimitsData() {
		
		logger.info("Sample api call recieved!");
		
		ResponseEntity<String> rs = new RestTemplate().getForEntity("http://localhost:8001/limits", String.class);
		
		return rs.getBody();
	}
	
	public String fallbackResponse(Exception ex) {
		
		return ex.getMessage();
	}
}
