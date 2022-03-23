package com.bootcamp.proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.proyecto.modelo.Client;
import com.bootcamp.proyecto.repository.ClientRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	ClientRepository clientRepository;
	
	@Override
	public void createCli(Client c) {	
		clientRepository.save(c).subscribe();
	}

	@Override
	public Mono<Client> findByCliId(Integer id) {	
		return clientRepository.findById(id);
	}

	@Override
	public Flux<Client> findAllCli() {
		return clientRepository.findAll();
	}

	@Override
	public Mono<Client> updateCli(Client c) {
		return clientRepository.save(c);
	}

	@Override
	public Mono<Void> deleteCli(Integer id) {
		return clientRepository.deleteById(id);
	}

	
}

