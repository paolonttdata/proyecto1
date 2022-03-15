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
public class PassiveAccount {
	int id;//int idTypeAcount;//id cuenta pasiva
	String accountCurrent;//cuenta corriente
	String termFixed;//plazo fijo
	String accountSaving;//cuenta corriente
}
