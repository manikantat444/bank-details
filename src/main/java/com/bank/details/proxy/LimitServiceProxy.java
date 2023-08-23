package com.bank.details.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name="limits-service")
public interface LimitServiceProxy {

	@GetMapping("/limits")
	public Limits getLimits();
}
