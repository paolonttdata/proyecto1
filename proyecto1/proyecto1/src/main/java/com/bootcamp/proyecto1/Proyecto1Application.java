package com.bootcamp.proyecto1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {WebMvcAutoConfiguration.class })
public class Proyecto1Application {
	
	
	private static final Logger logger= LogManager.getLogger(Proyecto1Application.class);
	
	
	public static void main(String[] args) {
		SpringApplication.run(Proyecto1Application.class, args);
	}
	
	public void run(ApplicationArguments args) throws Exception {
		logger.debug("Debug de la aplicacion");
		logger.info("Info log");
		logger.warn(" Este es una alerta");
		logger.error("Mensaje error");
		logger.fatal("Error  corregir");
	}
	
	
}
