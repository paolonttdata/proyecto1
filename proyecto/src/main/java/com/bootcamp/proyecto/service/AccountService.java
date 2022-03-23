package com.bootcamp.proyecto.service;

import com.bootcamp.proyecto.modelo.Account;


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
