package com.bootcamp.proyecto.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.proyecto.modelo.Transactions;

@Repository
public interface TransactionRepository extends ReactiveMongoRepository<Transactions, Integer>{


}
