package com.aplazo.examen.proyectoaplazo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Simple Interest", version = "1.0", description = "Calculate and generates the list of payments of the simple interest of a credit that must be paid in n terms and in weekly"))
public class ProyectoAplazoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoAplazoApplication.class, args);
	}

}
