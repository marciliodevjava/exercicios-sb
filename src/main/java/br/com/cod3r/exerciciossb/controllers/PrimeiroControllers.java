package br.com.cod3r.exerciciossb.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController // rest controle
public class PrimeiroControllers {
	
	@RequestMapping(method = RequestMethod.GET) // mapeando o metodo rest
	public String ola() {
		return "Olá Spring Boot";
	}
}
