package com.bootcamp.proyecto.service;

import com.bootcamp.proyecto.modelo.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {
    void createEmp(Employee e);
    Mono<Employee> findByEmpId(Integer id);
    Flux<Employee> findAllEmp ();
    Mono<Employee> updateEmp(Employee e);
    Mono<Void> deleteEmp(Integer id);
}
