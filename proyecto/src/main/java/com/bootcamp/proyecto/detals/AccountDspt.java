package com.bootcamp.proyecto.detals;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

/**
 *
 * @author erojaalf
 */
@Data
public class AccountDspt implements Serializable{
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime date;
	private BigDecimal amount;
    private String movementtype;
    private String cardNumber;
    
    
    
}
