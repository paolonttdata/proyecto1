package com.bootcamp.proyecto1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.proyecto1.service.ServiceWeb;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("eurekaconf")
public class TestEurekaConfig {

	@Autowired
	@Qualifier("ClientServiceBalanced")
	private ServiceWeb clientServiceBalance;
	@GetMapping("/message123")
	public Mono<String> greet(){
		return clientServiceBalance.getMessage();
	}
	
	@GetMapping("/message321")
	public Mono<String> greets(){
		return clientServiceBalance.getMessage();
	}
}