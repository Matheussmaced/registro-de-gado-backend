package com.registro.gado.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

  public void addCorsMappings(CorsRegistry registry) {
    System.out.println("Configuração de CORS carregada");
    registry.addMapping("/**")
        .allowedOrigins("http://localhost:4200", "https://sistema-gado-registro.vercel.app")
        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
        .allowedHeaders("*")
        .allowCredentials(true);
  }
}
