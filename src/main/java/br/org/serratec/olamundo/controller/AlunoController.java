package br.org.serratec.olamundo.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import br.org.serratec.olamundo.domain.Aluno;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	private static List<Aluno> lista = new ArrayList<Aluno>();
	//static chama a lista diretamente sem instanciar na classe
	static {
		lista.add(new Aluno(2354L, "Carla", "2224-0439"));
		lista.add(new Aluno(2343L, "Carlos", "2334-0239"));
		lista.add(new Aluno(1409L, "Maria", "2343-2345"));
	}
	
	@GetMapping
	public List<Aluno> listar(){
		return lista;
	}
	
	@GetMapping("/{matricula}")
	public Aluno buscar(@PathVariable Long matricula) {
		//stream vem do java 8 e permite ter acesso ao map e ao filter
		return lista.stream().filter(a -> a.getMatricula().equals(matricula)).findFirst().orElse(null); 
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Aluno inserir(@RequestBody Aluno aluno) {
		lista.add(aluno);
		return aluno;
	}
	
	@DeleteMapping("/{matricula}")
	public void delete(@PathVariable Long matricula) {
		lista.removeIf((a -> a.getMatricula().equals(matricula)));
	}
	
	//chaves indicam uma variavel matricula que é pegada no metodo
	@PutMapping("/{matricula}")
	public Aluno atualizar(@RequestBody Aluno aluno, @PathVariable Long matricula) {
		Integer i = lista.indexOf(lista.stream().filter(a -> a.getMatricula().equals(matricula)).findFirst().orElse(null));
		Aluno aluno2 = new Aluno(matricula, aluno.getNome(), aluno.getTelefone());
		lista.set(i, aluno2);
		return aluno2;			
	}
	
	
	
}








