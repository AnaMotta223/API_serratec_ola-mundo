package br.org.serratec.olamundo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.olamundo.domain.Aluno;
import br.org.serratec.olamundo.domain.Veiculo;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {
	
	public static List<Veiculo> veiculos = new ArrayList<Veiculo>();
	
	static {
		veiculos.add(new Veiculo(123L, "Fiat", "Uno"));
		veiculos.add(new Veiculo(123L, "Ford", "Ka"));
	}
	
	@GetMapping
	public List<Veiculo> listar(){
		return veiculos;
	}
	
	@GetMapping("/{id}")
	public Veiculo buscar(@PathVariable Long id) {
		return veiculos.stream().filter(v -> v.getId().equals(id)).findFirst().orElse(null);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Veiculo inserir(@RequestBody Veiculo veiculo) {
		veiculos.add(veiculo);
		return veiculo;
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		veiculos.removeIf((v -> v.getId().equals(id)));
	}
	
	@PutMapping("/{id}")
	public Veiculo atualizar(@RequestBody Veiculo veiculo, @PathVariable Long id) {
		Integer i = veiculos.indexOf(veiculos.stream().filter(v -> v.getId().equals(id)).findFirst().orElse(null));
		Veiculo veiculo2 = new Veiculo(id, veiculo.getMarca(), veiculo.getModelo());
		veiculos.set(i, veiculo2);
		return veiculo2;	
	}
	
	
}
