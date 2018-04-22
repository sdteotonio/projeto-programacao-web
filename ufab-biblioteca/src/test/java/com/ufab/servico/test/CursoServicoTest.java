package com.ufab.servico.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextLoader;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.ufab.config.Config;
import com.ufab.entidade.Curso;
import com.ufab.entidade.TipoCurso;
import com.ufab.excecao.CursoModeloException;
import com.ufab.excecao.CursoServicoException;
import com.ufab.servico.ICursoServico;
import com.ufab.servico.ITipoCursoServico;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Config.class })

public class CursoServicoTest {

	@Autowired
	private ICursoServico cursoServico;

	@Autowired
	private ITipoCursoServico tipoCursoServico;

	@Test(expected = CursoServicoException.class)
	public void inserirNulo() throws CursoServicoException {
		cursoServico.inserir(null);
	}

	@Test
	public void inserirRecuperarCurso() {
		Curso c1;
		TipoCurso t1;
		t1 = new TipoCurso();
		t1.setNome("Graduação");
		tipoCursoServico.inserir(t1);

		c1 = new Curso();
		c1.setArea("Exatas");
		c1.setTipoCurso(t1);
		c1.setNome("Computação");

		c1.setCod(-1);
		try {
			cursoServico.inserir(c1);
			Curso c = cursoServico.recuperarPorCod(c1.getCod());
			assertEquals(c.getCod(), c1.getCod());
		} catch (CursoServicoException e) {
			assertTrue(false);
		}

	}

	@Test(expected = CursoServicoException.class)
	public void inserirCursoDuplicado() throws CursoServicoException {
		Curso curso = new Curso();

		// Verificar caso algum teste ja tenha inserido um TipoDeCurso

		TipoCurso tipoCurso = null;
		try {
			tipoCurso = tipoCursoServico.listarTodos().get(0);
		} catch (IndexOutOfBoundsException e) {
			// Precisa criar, não existe na base
			tipoCurso = new TipoCurso();
			tipoCurso.setNome("Graduação");
			tipoCursoServico.inserir(tipoCurso);
		}

		// Inserir um Curso qualquer
		curso.setNome("Medicina");
		curso.setArea("Saude");
		curso.setTipoCurso(tipoCurso);

		cursoServico.inserir(curso);
		cursoServico.inserir(curso);

	}

	@Test
	public void testRemoverCurso() {
		Curso curso = new Curso();

		// Verificar caso algum teste ja tenha inserido um TipoDeCurso

		TipoCurso tipoCurso = null;
		try {
			tipoCurso = tipoCursoServico.listarTodos().get(0);
		} catch (IndexOutOfBoundsException e) {
			// Precisa criar, não existe na base
			tipoCurso = new TipoCurso();
			tipoCurso.setNome("Graduação");
			tipoCursoServico.inserir(tipoCurso);
		}

		// Inserir um Curso qualquer
		curso.setNome("Farmacia");
		curso.setArea("Saude");
		curso.setTipoCurso(tipoCurso);
		try {
			cursoServico.inserir(curso);
		} catch (CursoServicoException e) {
			assertTrue(false);
		}

		cursoServico.remover(curso);

		try {
			Curso c2 = cursoServico.recuperarPorCod(curso.getCod());
			assertEquals(c2, null);
		} catch (CursoServicoException e) {
			assertTrue(false);
		}

	}

	@Test
	public void testAtualizarCurso() {
		Curso curso = new Curso();

		// Verificar caso algum teste ja tenha inserido um TipoDeCurso

		TipoCurso tipoCurso = null;
		try {
			tipoCurso = tipoCursoServico.listarTodos().get(0);
		} catch (IndexOutOfBoundsException e) {
			// Precisa criar, não existe na base
			tipoCurso = new TipoCurso();
			tipoCurso.setNome("Graduação");
			tipoCursoServico.inserir(tipoCurso);
		}

		// Inserir um Curso qualquer
		curso.setNome("Matematica");
		curso.setArea("Exatas");
		curso.setTipoCurso(tipoCurso);
		try {
			cursoServico.inserir(curso);
		} catch (CursoServicoException e) {
			assertTrue(false);
		}
		String novoNome = "Estatistica";
		curso.setNome(novoNome);

		try {
			cursoServico.atualizar(curso);
			Curso c2 = cursoServico.recuperarPorCod(curso.getCod());
			assertEquals(c2.getNome(), novoNome);
		} catch (CursoServicoException e) {
			assertTrue(false);
		}

	}

}
