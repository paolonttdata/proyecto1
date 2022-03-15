package com.bootcamp.proyecto1.service;

import com.bootcamp.proyecto1.modelo.Transactions;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface TransactionService {
	void createTran(Transactions t);
    Mono<Transactions> findByTranId(Integer id);
    Flux<Transactions> findAllTran ();
    Mono<Transactions> updateTran(Transactions t);
    Mono<Void> deleteTran(Integer id);
}