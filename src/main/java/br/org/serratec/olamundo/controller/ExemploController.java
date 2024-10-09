package br.org.serratec.olamundo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ExemploController {
	
	@GetMapping
	public String teste() {
		return "Teste Serratec";
	}
	
	@GetMapping("/oi")
	public String oi() {
		return "oii";
	}
	
	//usuario pode passar um parametro na requisicao (valor)
	@GetMapping("/maiuscula")
	public String maiuscula(@RequestParam String valor) {
		return valor.toUpperCase();
	}
}
