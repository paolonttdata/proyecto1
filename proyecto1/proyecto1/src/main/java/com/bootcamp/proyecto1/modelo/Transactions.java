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
//transacciones
public class Transactions{
	int id;//int idTransactions;
	String remove;//retirar
	String deposit;//depositar
	String payProducts;//pagar productos
	String payCredit;//pagar credito	
	String payConsumption;//pagar consumo
	
}