package br.com.uepb.biblioteca.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.uepb.biblioteca.exception.AutenticacaoException;
import br.com.uepb.biblioteca.exception.EmprestimoException;
import br.com.uepb.biblioteca.exception.ExistException;
import br.com.uepb.biblioteca.model.Aluno;
import br.com.uepb.biblioteca.model.Funcionario;
import br.com.uepb.biblioteca.service.AlunoService;
import br.com.uepb.biblioteca.service.FuncionarioService;

@RestController
@RequestMapping("/aluno")
public class AlunoControlador {

	@Autowired
	private AlunoService alunoService;

	@Autowired
	private FuncionarioService funcionarioService;

	@GetMapping
	public ResponseEntity<List<Aluno>> listarTodos() {
		return new ResponseEntity<List<Aluno>>(alunoService.getListaAluno(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Aluno> listarUnico(@PathVariable int id) {
		return new ResponseEntity<Aluno>(alunoService.getAlunoById(id), HttpStatus.OK);
	}

	@PostMapping("/cpf/{cpf}")
	public ResponseEntity inserir(@PathVariable String cpf, @RequestBody Aluno aluno) {
		Funcionario funcionario = funcionarioService.getFuncionarioByCpf(cpf);
		try {
			alunoService.cadastrarAluno(funcionario, aluno);
			return new ResponseEntity(HttpStatus.CREATED);
		} catch (AutenticacaoException | ExistException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping
	public ResponseEntity atualizar(@RequestBody Aluno aluno) {
		alunoService.atualizarAluno(aluno);
		return new ResponseEntity(HttpStatus.OK);
	}

	@DeleteMapping("/cpf/{cpf}/{id}")
	public ResponseEntity remover(@PathVariable String cpf, @PathVariable int id) {
		Aluno aluno = alunoService.getAlunoById(id);
		Funcionario funcionario = funcionarioService.getFuncionarioByCpf(cpf);
		try {
			alunoService.removerAluno(funcionario, aluno);
			return new ResponseEntity(HttpStatus.OK);
		} catch (AutenticacaoException | EmprestimoException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
