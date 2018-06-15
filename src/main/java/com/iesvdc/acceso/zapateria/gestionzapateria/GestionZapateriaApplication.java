package com.iesvdc.acceso.zapateria.gestionzapateria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(considerNestedRepositories = true)
@SpringBootApplication
public class GestionZapateriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionZapateriaApplication.class, args);
	}
}
