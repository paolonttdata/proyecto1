package com.bootcamp.proyecto.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	private BigDecimal amount;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime date;
    private Client clientPayment;
	
}
