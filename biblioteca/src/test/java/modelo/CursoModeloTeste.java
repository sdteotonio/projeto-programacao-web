package modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import entidade.Curso;
import entidade.Jornal;
import entidade.TipoCurso;
import entidade.TipoItem;
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
	
	@Test (expected = CursoModeloException.class)
	public void testeInserirCursoDuplicado() throws CursoModeloException{
		Curso curso  = new Curso();

		curso.setNome("Medicina");
		curso.setArea("Saúde");
		
		TipoCurso tipoCurso  = new TipoCurso();
		tipoCurso.setCod(0);
		tipoCurso.setNome("Graduacao");
		
		curso.setTipoCurso(tipoCurso);
		
		cursoModelo.inserirCurso(curso);
		cursoModelo.inserirCurso(curso);
		
	}
	
	
	
	@Test 
	public void testeInserirRecuperarCurso() throws CursoModeloException{
		Curso curso  = new Curso();

		curso.setNome("Ciência da Computação");
		curso.setArea("Exatas");
		
		TipoCurso tipoCurso  = new TipoCurso();
		tipoCurso.setCod(0);
		tipoCurso.setNome("Graduacao");
		
		curso.setTipoCurso(tipoCurso);
		
		try {
			cursoModelo.inserirCurso(curso);
		} catch (CursoModeloException e) {
			assertFalse(e == null);
		}

		Curso cursoRecuperado;
		try {
			cursoRecuperado = (Curso) cursoModelo.recuperarCursoPorNome(curso.getNome());
			assertEquals(curso, cursoRecuperado);
		} catch (CursoModeloException e) {
			assertFalse(e != null);
		}
	}
	
	
	
	
		
		
}


