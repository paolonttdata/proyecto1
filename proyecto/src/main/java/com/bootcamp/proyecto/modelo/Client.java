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
public class Client {
	int id;
	String clientType;
	String nameClient;
	String cellphone;
	String direction;
	String customerBalance;
	 
	
}

