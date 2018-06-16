package br.com.uepb.biblioteca.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.uepb.biblioteca.exception.AutenticacaoException;
import br.com.uepb.biblioteca.service.FuncionarioService;
import br.com.uepb.biblioteca.vo.UsuarioLoginVO;
@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class FuncionarioControlador {

	@Autowired
	private FuncionarioService funcionarioService;

	@PostMapping("/login")
	public ResponseEntity login(@RequestBody UsuarioLoginVO usuarioLogin) {
		try {
			return new ResponseEntity(funcionarioService.autenticar(usuarioLogin.getUsuario(), usuarioLogin.getSenha()),
					HttpStatus.OK);
		} catch (AutenticacaoException e) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}

}
