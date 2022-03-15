package com.bootcamp.proyecto1.modelo;

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
//cuenta pasivo o activo
public class Account {
	int id;//idAccount;
	String accountType;//tipo de cuenta
	double startAmount;//montoInicial
	int movement;

	
}
