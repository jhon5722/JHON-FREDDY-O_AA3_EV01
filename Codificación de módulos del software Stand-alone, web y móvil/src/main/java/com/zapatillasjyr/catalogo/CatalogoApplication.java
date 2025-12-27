package com.zapatillasjyr.catalogo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal para iniciar la aplicación del catálogo de Zapatillas J&R.
 * Utiliza el framework Spring Boot para configurar y lanzar la aplicación.
 * 
 * @author Manus AI
 * @version 1.0
 */
@SpringBootApplication
public class CatalogoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogoApplication.class, args);
	}

}
