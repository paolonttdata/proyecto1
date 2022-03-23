package com.bootcamp.proyecto.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.proyecto.modelo.Account;

@Repository
public interface AccountRepository extends ReactiveMongoRepository<Account, Integer>{

}
