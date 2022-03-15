package com.bootcamp.proyecto1.service;

import com.bootcamp.proyecto1.modelo.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface ClientService {
	
	void createCli(Client c);
    Mono<Client> findByCliId(Integer id);
    Flux<Client> findAllCli ();
    Mono<Client> updateCli(Client c);
    Mono<Void> deleteCli(Integer id);
	
}