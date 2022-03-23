package com.bootcamp.proyecto.modelo;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
@Document

public class AccountCard {

	int id;
	String cardNumber;
    @Indexed(unique=true)
	Account account;
    boolean accountPrincipal;
}
