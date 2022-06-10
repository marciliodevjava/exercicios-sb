package br.com.cod3r.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // rest controle
public class PrimeiroControllers {

	@GetMapping(path = "/ola") // mapeando o metodo rest
	public String ola() {
		return "Olá Spring Boot";
	}
}
