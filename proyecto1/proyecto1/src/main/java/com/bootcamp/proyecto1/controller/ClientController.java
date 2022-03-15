package com.bootcamp.proyecto1.controller;

import com.bootcamp.proyecto1.modelo.Client;
import com.bootcamp.proyecto1.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/create/clien")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCli (@RequestBody Client client){
    	clientService.createCli(client);
    }

    @GetMapping(value = "/get/all",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public Flux<Client> findAll(){
        return clientService.findAllCli();
    }


    @GetMapping("/get/{id}")
    @ResponseBody
    public ResponseEntity<Mono<Client>> findById(@PathVariable("id") Integer id){
    	Mono<Client> clientMono=clientService.findByCliId(id);
        return new ResponseEntity<Mono<Client>>(clientMono,clientMono != null? HttpStatus.OK:HttpStatus.NOT_FOUND);
    }

}
