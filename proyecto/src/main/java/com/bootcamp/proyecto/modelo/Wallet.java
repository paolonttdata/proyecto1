package com.bootcamp.proyecto.modelo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Wallet {

    String id;
    String name;
}
