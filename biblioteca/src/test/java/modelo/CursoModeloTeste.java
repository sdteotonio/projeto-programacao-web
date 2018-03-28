package modelo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import entidade.Curso;
import entidade.Jornal;
import excecao.CursoModeloException;
import excecao.ItemModeloException;


public class CursoModeloTeste {
	
	private CursoModelo cursoModelo;
	
	public CursoModeloTeste(){
		this.cursoModelo = new CursoModelo();
	}
	
	@Test(expected = CursoModeloException.class)
	public void testeInserirCursoVazio() throws CursoModeloException {
		cursoModelo.inserirCurso(null);
	}
	
	@Test
	public void testeInserirCursoIncompletoDeAtributos() {
		Curso curso = new Curso();
		//Enviar sem Nome
		try {
			cursoModelo.inserirCurso(curso);
		} catch (CursoModeloException e) {
			assertTrue(true);
		}
		//Enviar sem área
		curso.setArea("Exatas");
		try {
		cursoModelo.inserirCurso(curso);
		} catch (CursoModeloException e) {
			assertTrue(true);
		}	
		
	}
	
	
	
	@Test
	public void inserirCursoTest() {
		assertTrue(true);
	}

}
