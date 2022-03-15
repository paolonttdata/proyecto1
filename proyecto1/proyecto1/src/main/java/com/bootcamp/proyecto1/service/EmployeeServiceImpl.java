package com.bootcamp.proyecto1.service;

import com.bootcamp.proyecto1.modelo.Employee;
import com.bootcamp.proyecto1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeServiceImpl  implements  EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void createEmp(Employee e) {
        employeeRepository.save(e).subscribe();
    }

    @Override
    public Mono<Employee> findByEmpId(Integer id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Flux<Employee> findAllEmp() {
        return employeeRepository.findAll();
    }

    @Override
    public Mono<Employee> updateEmp(Employee e) {
        return employeeRepository.save(e);
    }

    @Override
    public Mono<Void> deleteEmp(Integer id) {
        return employeeRepository.deleteById(id);
    }
}