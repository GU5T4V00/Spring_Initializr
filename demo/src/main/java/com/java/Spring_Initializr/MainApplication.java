package com.java.Spring_Initializr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principal que inicializa a aplicação Spring Boot.
 * * @SpringBootApplication:
 * 1. @Configuration: Marca a classe como fonte de definição de beans.
 * 2. @EnableAutoConfiguration: Configura automaticamente o Spring Boot
 * com base nas dependências do classpath (JPA, H2, Web, etc.).
 * 3. @ComponentScan: Procura por componentes (Controllers, Services, Repositories, etc.)
 * no pacote atual e subpacotes.
 */
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        // Método estático que inicia a aplicação Spring Boot
        SpringApplication.run(MainApplication.class, args);

        // Uma mensagem simples para indicar que a aplicação está rodando
        System.out.println("----------------------------------------------");
        System.out.println("  Aplicação Spring Boot ('Cliente App') Rodando!");
        System.out.println("  Acesse o H2 Console: http://localhost:8080/h2-console");
        System.out.println("----------------------------------------------");
    }
}