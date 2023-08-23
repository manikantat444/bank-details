package com.bank.details.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@PostMapping("/saveEmployee")
	public void saveEmployee(@RequestBody Employee emp) {
		
		
	}
}
