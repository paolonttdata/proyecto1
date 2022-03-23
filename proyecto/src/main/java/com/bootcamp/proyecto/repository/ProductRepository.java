package com.bootcamp.proyecto.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.proyecto.modelo.product;


@Repository
public interface ProductRepository extends ReactiveMongoRepository<product, Integer>{

}
