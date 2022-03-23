package com.bootcamp.proyecto.modelo;

import java.math.BigDecimal;

import java.math.BigDecimal;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class product {

	 int id;
	 String name;
	 String producttype;
	 String productsubtype;
	 BigDecimal comission;
	 int movementsmax;
}
