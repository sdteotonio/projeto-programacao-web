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
import br.com.uepb.biblioteca.exception.ExistException;
import br.com.uepb.biblioteca.model.Funcionario;
import br.com.uepb.biblioteca.model.Item;
import br.com.uepb.biblioteca.service.FuncionarioService;
import br.com.uepb.biblioteca.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemControlador {
	@Autowired
	private ItemService itemService;

	@Autowired
	private FuncionarioService funcionarioService;

	@GetMapping
	public ResponseEntity<List<Item>> recuperar() {
		return new ResponseEntity<List<Item>>(itemService.getListaItem(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Item> recuperarUnico(@PathVariable int id) {
		return new ResponseEntity<Item>(itemService.getItemById(id), HttpStatus.OK);
	}

	@PostMapping("/cpf/{cpf}")
	public ResponseEntity inserir(@PathVariable String cpf, @RequestBody(required = true) Item item) {
		Funcionario funcionario = funcionarioService.getFuncionarioByCpf(cpf);
		try {
			itemService.cadastraItem(funcionario, item);
			return new ResponseEntity(HttpStatus.CREATED);
		} catch (AutenticacaoException | ExistException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/cpf/{cpf}/{id}")
	public ResponseEntity atualizar(@PathVariable String cpf, @RequestBody Item item) {
		Funcionario funcionario = funcionarioService.getFuncionarioByCpf(cpf);
		try {
			itemService.atualizarItem(funcionario, item);
			return new ResponseEntity(HttpStatus.OK);
		} catch (AutenticacaoException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/cpf/{cpf}/{id}")
	public ResponseEntity remover(@PathVariable String cpf, @PathVariable int id) {
		Item item = itemService.getItemById(id);
		Funcionario funcionario = funcionarioService.getFuncionarioByCpf(cpf);
		try {
			itemService.removerItem(funcionario, item);
			return new ResponseEntity(HttpStatus.OK);
		} catch (AutenticacaoException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
