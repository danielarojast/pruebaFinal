package com.riwi.pruebaFinaRiwi.configurations;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


// Configuracion de la documentacion de swagger

@Configuration
@OpenAPIDefinition(info = @Info(
    title = "Prueba Fina Riwi",
    version = "1.0.0", 
    description = "Documentacion de ..."))
public class OpenApiConfig {
    
}
