package com.bootcamp.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.proyecto.modelo.Account;
import com.bootcamp.proyecto.service.AccountService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/create/accou")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAcco (@RequestBody Account account){
		accountService.save(account);
    }

    @GetMapping(value = "/get/all",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public Flux<Account> findAll(){
        return accountService.findAllAcco();
    }


    @GetMapping("/get/{id}")
    @ResponseBody
    public ResponseEntity<Mono<Account>> findById(@PathVariable("id") Integer id){
    	Mono<Account> accountMono=accountService.findById(id);
        return new ResponseEntity<Mono<Account>>(accountMono,accountMono != null? HttpStatus.OK:HttpStatus.NOT_FOUND);
    }
}
