package com.bootcamp.proyecto.modelo;

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
public class ActiveAccount {
	int id;//idTipCredit;
	String accountType;//tipo de cuenta
	double typeCard;//Tipo de Tarjeta
		
}
