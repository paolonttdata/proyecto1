package com.bootcamp.proyecto1.controller;

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
import com.bootcamp.proyecto1.modelo.Transactions;
import com.bootcamp.proyecto1.service.TransactionService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class TransactionsController {

	

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/create/tran")
    @ResponseStatus(HttpStatus.CREATED)
    public void createEmp (@RequestBody Transactions transactions){
    	transactionService.createTran(transactions);
    }

    @GetMapping(value = "/get/all",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public Flux<Transactions> findAll(){
        return transactionService.findAllTran();
    }


    @GetMapping("/get/{id}")
    @ResponseBody
    public ResponseEntity<Mono<Transactions>> findById(@PathVariable("id") Integer id){
    	Mono<Transactions> transactionsMono=transactionService.findByTranId(id);
        return new ResponseEntity<Mono<Transactions>>(transactionsMono,transactionsMono != null? HttpStatus.OK:HttpStatus.NOT_FOUND);
    }
}
