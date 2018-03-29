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


public class CursoModeloTest {
	
	private CursoModelo cursoModelo;
	
	public CursoModeloTest(){
		this.cursoModelo = new CursoModelo();
	}
	
	@Test(expected = CursoModeloException.class)
	public void testInserirCursoVazio() throws CursoModeloException {
		cursoModelo.inserirCurso(null);
	}
	
	@Test
	public void testInserirCursoIncompletoDeAtributos() {
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
	public void testInserirCursoDuplicado() throws CursoModeloException{
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
	public void testInserirRecuperarCurso() throws CursoModeloException{
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
	

	@Test
	public void testRemoverCurso() {
		
		Curso curso = new Curso();
		curso.setArea("Area_Excluir");
		curso.setNome("Curso_Excluir");
		
		curso.setTipoCurso(new TipoCurso());
		
		try {
			cursoModelo.inserirCurso(curso);
		} catch (CursoModeloException e) {
			assertFalse(e != null);
		}

		try {
			cursoModelo.removerCursoPorNome(curso.getNome());
		} catch (CursoModeloException e) {
			assertFalse(e != null);
		}
		
		Curso c1 = null;
		Curso c2 = new Curso();
		
		try {
			c2 = (Curso) cursoModelo.recuperarCursoPorNome(curso.getNome());
		}catch(CursoModeloException e){
			assertFalse(e != null);
		}
		
		assertEquals(c1 , c2);
	}
		
		
	@Test
	public void testAtualizarCurso() {
		Curso j1 = new Curso();
		j1.setNome("NomeCurso");
		j1.setArea("AreaDoCurso");
		
		j1.setTipoCurso(new TipoCurso());
		try {
			cursoModelo.inserirCurso(j1);
		} catch (CursoModeloException e) {
			assertFalse(e != null);
		}

		Curso j = null;
		try {
			j = (Curso) cursoModelo.recuperarCursoPorNome("NomeCurso");
		} catch (CursoModeloException e) {
			assertFalse(e != null);
		}

		String novaArea = "NovaAreaDoCurso";
		

		assertEquals(j1.getNome(), j.getNome());

		j.setArea(novaArea);

		try {
			cursoModelo.atualizarCurso(j1);
		} catch (CursoModeloException e) {
			assertFalse(e != null);
		}
		try {
			j = (Curso) cursoModelo.recuperarCursoPorNome("NomeCurso");
		} catch (CursoModeloException e) {
			assertFalse(e != null);
		}
		
		assertEquals(novaArea, j.getArea());
	}
}


