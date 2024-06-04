package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfigg implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Mapea este filtro a todas las rutas
                .allowedOrigins("http://localhost:4200") // Permite solicitudes desde este origen
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Permite estos métodos HTTP
                .allowedHeaders("*"); // Permite todos los encabezados
    }
}
