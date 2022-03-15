package com.bootcamp.proyecto1.service;

import reactor.core.publisher.Mono;

public interface ServiceWeb {
	public Mono<String> getMessage();
}
