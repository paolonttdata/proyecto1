package com.bootcamp.proyecto.modelo;

import java.math.BigDecimal;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

public class WalletMoney {

    String money;
    String moneyWall;
    Integer sale;
    Integer buys;
}
