package com.bootcamp.proyecto.service;

import com.bootcamp.proyecto.modelo.Transactions;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface TransactionService {
	void createTran(Transactions t);
    Mono<Transactions> findByTranId(Integer id);
    Flux<Transactions> findAllTran ();
    Mono<Transactions> updateTran(Transactions t);
    Mono<Void> deleteTran(Integer id);
}