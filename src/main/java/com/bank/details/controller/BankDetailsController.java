package com.bank.details.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.details.controller.model.BankDetails;
import com.bank.details.proxy.LimitServiceProxy;
import com.bank.details.proxy.Limits;
import com.bank.details.repository.BankDetailsRepository;
import com.bank.exceptions.UserNotFoundException;

@RestController
public class BankDetailsController {

	@Autowired
	private BankDetailsRepository repository;
	
	@Autowired
	private LimitServiceProxy proxy;
	
	@GetMapping("/getBankDetails")
	public List<BankDetails> getBankDetails() {
		
		return repository.findAll();
	}
	
	@GetMapping("/getFeignBankDetails")
	public Limits getFeignBankDetails() {
		
		return proxy.getLimits();
	}
	
	@PostMapping("/createAccount")
	public void createAccount(@RequestBody BankDetails details) {
		
		repository.save(details);
	}
	
	@PutMapping("/updateAccount/{id}/balance/{balance}")
	public void updateAccount(@PathVariable int id,@PathVariable double balance) {
		
		BankDetails user = repository.findById(id).get();
		if(user!=null) {
			user.setBalance(balance);
			repository.save(user);
		}
		else {
			
			throw new UserNotFoundException("User not found!");
		}
	}
}
