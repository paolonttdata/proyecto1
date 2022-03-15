package com.bootcamp.proyecto1.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import com.bootcamp.proyecto1.modelo.Client;

public interface ClientRepository extends ReactiveMongoRepository<Client, Integer> {

}