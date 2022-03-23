package com.bootcamp.proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.proyecto.modelo.Transactions;
import com.bootcamp.proyecto.repository.TransactionRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionServiceImpl implements TransactionService{
	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public void createTran(Transactions t) {
		transactionRepository.save(t).subscribe();
	}

	@Override
	public Mono<Transactions> findByTranId(Integer id) {
		return transactionRepository.findById(id);
	}

	@Override
	public Flux<Transactions> findAllTran() {
		return transactionRepository.findAll();
	}

	@Override
	public Mono<Transactions> updateTran(Transactions t) {
		return transactionRepository.save(t);
	}

	@Override
	public Mono<Void> deleteTran(Integer id) {
		return transactionRepository.deleteById(id);
	}
}

