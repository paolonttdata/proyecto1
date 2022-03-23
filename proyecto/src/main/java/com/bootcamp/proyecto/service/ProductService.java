package com.bootcamp.proyecto.service;


import com.bootcamp.proyecto.modelo.product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
	
	public void save(product e);
	Mono<product> findById(Integer id);
    Flux<product> findAll();
    Mono<product> update(product e);
    Mono<Void> delete(Integer id);
}
