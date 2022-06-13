package br.com.cod3r.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/calculadora")
public class CalculadoraController {

	// / calculadora/somar/10/20
	@GetMapping(path = "/somar/{a}/{b}")
	// http://localhost:8080/calculadora/somar/39/40
	public int soma(@PathVariable int a, @PathVariable int b) {
		return a + b;
	}

	// calculadora/subtrair?100&b=39

	@GetMapping(path = "/subtrair")
	// http://localhost:8080/calculadora/subtrair?a=100&b=30
	public int subtrair(@RequestParam(name = "a") int a, @RequestParam(name = "b") int b) {
		return a - b;
	}
}
