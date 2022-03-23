package com.bootcamp.proyecto.service;

import reactor.core.publisher.Mono;

public interface ServiceWeb {
	public Mono<String> getMessage();
}
