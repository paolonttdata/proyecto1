package com.bootcamp.proyecto.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import com.bootcamp.proyecto.modelo.Client;

public interface ClientRepository extends ReactiveMongoRepository<Client, Integer> {

}