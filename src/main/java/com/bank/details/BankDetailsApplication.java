package com.bank.details;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BankDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankDetailsApplication.class, args);
	}

}
