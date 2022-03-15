package com.bootcamp.proyecto1.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.proyecto1.modelo.Transactions;

@Repository
public interface TransactionRepository extends ReactiveMongoRepository<Transactions, Integer>{


}
