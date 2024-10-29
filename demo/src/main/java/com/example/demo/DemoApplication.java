package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


}
// beckend pega requisçoes http
// put : é para update memso id
// patch : nn muda as informações, só endereco 
// como enviar dados para backend --> json