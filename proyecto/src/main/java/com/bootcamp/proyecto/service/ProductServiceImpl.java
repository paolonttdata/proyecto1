package com.bootcamp.proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.proyecto.modelo.product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public abstract class ProductServiceImpl implements ProductService{

	@Autowired
	ProductService productService;
	
	@Override
	public void save(product e) {
		productService.save(e);
	}

	@Override
	public Mono<product> findById(Integer id) {
		return productService.findById(id);
	}

	@Override
	public Flux<product> findAll() {
		return productService.findAll();
	}

	@Override
	public Mono<product> update(product e) {
		return productService.update(e);
	}

	@Override
	public Mono<Void> delete(Integer id) {
		return productService.delete(id);
	}


}