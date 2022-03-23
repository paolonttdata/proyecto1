package com.bootcamp.proyecto.repository;

import com.bootcamp.proyecto.modelo.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository  extends ReactiveMongoRepository<Employee, Integer> {
	

}

