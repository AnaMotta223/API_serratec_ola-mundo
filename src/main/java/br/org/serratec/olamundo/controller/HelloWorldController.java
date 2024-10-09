package br.org.serratec.olamundo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping("/ola")
	public String olaMundo(){
		return "Ola mundo";
	}
	
	//poderia ser explicitado com value
	//@RequestMapping("/resposta")
	
	@RequestMapping(value="/resposta", method= RequestMethod.GET, produces = {"application/json"})
	public String msg() {
		return "oi";
	}
}
