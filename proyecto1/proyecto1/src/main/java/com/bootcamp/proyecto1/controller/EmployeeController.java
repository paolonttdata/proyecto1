package com.bootcamp.proyecto1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.bootcamp.proyecto1.modelo.Employee;
import com.bootcamp.proyecto1.service.EmployeeService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create/emp")
    @ResponseStatus(HttpStatus.CREATED)
    public void createEmp (@RequestBody Employee employee){
        employeeService.createEmp(employee);
    }

    @GetMapping(value = "/get/all",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public Flux<Employee> findAll(){
        return employeeService.findAllEmp();
    }


    @GetMapping("/get/{id}")
    @ResponseBody
    public ResponseEntity<Mono<Employee>> findById(@PathVariable("id") Integer id){
       Mono<Employee> employeeMono= employeeService.findByEmpId(id);
        return new ResponseEntity<Mono<Employee>>(employeeMono,employeeMono != null? HttpStatus.OK:HttpStatus.NOT_FOUND);
    }
    
    
    
}