package br.com.uepb.biblioteca.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.uepb.biblioteca.exception.AutenticacaoException;
import br.com.uepb.biblioteca.exception.ExistException;
import br.com.uepb.biblioteca.model.Curso;
import br.com.uepb.biblioteca.model.Funcionario;
import br.com.uepb.biblioteca.service.CursoService;
import br.com.uepb.biblioteca.service.FuncionarioService;
@CrossOrigin
@RestController
@RequestMapping("/curso")
public class CursoControlador {

	@Autowired
	private CursoService cursoService;

	@Autowired
	private FuncionarioService funcionarioService;

	@GetMapping
	public ResponseEntity<List<Curso>> recuperar() {
		return new ResponseEntity<List<Curso>>(cursoService.getListaCurso(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Curso> recuperarUnico(@PathVariable int id) {
		return new ResponseEntity<Curso>(cursoService.getCursoById(id), HttpStatus.OK);
	}

	@PostMapping("/cpf/{usuarioCpf}")
	public ResponseEntity inserir(@PathVariable String usuarioCpf, @RequestBody(required = true) Curso curso) {
		Funcionario funcionario = funcionarioService.getFuncionarioByCpf(usuarioCpf);
		try {
			cursoService.cadastraCurso(funcionario, curso);
			return new ResponseEntity(HttpStatus.CREATED);
		} catch (AutenticacaoException | ExistException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/cpf/{usuarioCpf}/{id}")
	public ResponseEntity atualizar(@PathVariable String usuarioCpf, @RequestBody Curso curso) {
		Funcionario funcionario = funcionarioService.getFuncionarioByCpf(usuarioCpf);
		try {
			cursoService.atualizarCurso(funcionario, curso);
			return new ResponseEntity(HttpStatus.OK);
		} catch (AutenticacaoException | ExistException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/cpf/{usuarioCpf}/{id}")
	public ResponseEntity remover(@PathVariable String usuarioCpf, @PathVariable int id) {
		Curso curso = cursoService.getCursoById(id);
		Funcionario funcionario = funcionarioService.getFuncionarioByCpf(usuarioCpf);
		try {
			cursoService.removerCurso(funcionario, curso);
			return new ResponseEntity(HttpStatus.OK);
		} catch (AutenticacaoException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
