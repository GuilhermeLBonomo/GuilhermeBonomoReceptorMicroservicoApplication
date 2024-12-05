package com.rj.senac.br.GuilhermeBonomoReceptorMicroservico;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class GuilhermeBonomoReceptorMicroservicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuilhermeBonomoReceptorMicroservicoApplication.class, args);
		System.out.println("Roadando Receptor");
	}

}
