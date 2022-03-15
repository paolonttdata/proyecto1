package com.bootcamp.proyecto1.repository;

import com.bootcamp.proyecto1.modelo.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository  extends ReactiveMongoRepository<Employee, Integer> {
	

}

