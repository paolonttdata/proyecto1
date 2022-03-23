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
//cliente empresarial
public class BusinessClient extends Client{
	int idBusiness;//id cliente empresarial
	int accountsNumbers;//cantidad de cuentas
	
	
}
