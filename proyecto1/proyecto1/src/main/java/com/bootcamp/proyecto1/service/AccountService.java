package com.bootcamp.proyecto1.service;

import com.bootcamp.proyecto1.modelo.Account;
import com.bootcamp.proyecto1.modelo.Client;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountService {
	public Mono<Account> save(Account a) ;
	Mono<Account> findById(Integer id);
    Flux<Account> findAll();
    public Flux<String> findByClient(int id);
    Flux<Account> findAllAcco ();
    Mono<Account> updateAcco(Account a);
    Mono<Void> deleteAcco(Integer id);
    public Flux<Account> findByClienttId(int id);
    
}
