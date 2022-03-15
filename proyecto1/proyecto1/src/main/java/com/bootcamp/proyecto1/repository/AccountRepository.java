package com.bootcamp.proyecto1.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.proyecto1.modelo.Account;

@Repository
public interface AccountRepository extends ReactiveMongoRepository<Account, Integer>{

}
