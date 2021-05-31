package br.com.controledeveiculos.controledeveiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ControledeveiculosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControledeveiculosApplication.class, args);
	}

}
