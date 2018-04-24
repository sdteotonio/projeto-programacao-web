
package com.ufab.servico.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ufab.config.Config;
import com.ufab.entidade.Item;
import com.ufab.entidade.Jornal;
import com.ufab.entidade.Livro;
import com.ufab.entidade.MidiaDigital;
import com.ufab.entidade.TipoCurso;
import com.ufab.entidade.TipoItem;
import com.ufab.entidade.TipoMidiaDigital;
import com.ufab.excecao.ItemServicoException;
import com.ufab.servico.inter.IItemServico;
import com.ufab.servico.inter.ITipoItemServico;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Config.class })
public class ItemServicoTest {

	@Autowired
	private IItemServico itemServico;

	@Autowired
	private ITipoItemServico tipoItemServico;

	@Test
	public void listarItens() {
		assertTrue(itemServico.recuperarTodos() != null);
	}

	@Test(expected = ItemServicoException.class)
	public void inserirNulo() throws ItemServicoException {
		Jornal j = null;
		itemServico.inserir(j);
	}

	@Test(expected = ItemServicoException.class)
	public void atualizarNulo() throws ItemServicoException {
		itemServico.atualizar(null);
	}

	@Test(expected = ItemServicoException.class)
	public void atualizarInvalido() throws ItemServicoException {
		Livro l = new Livro();

		TipoItem tipoItem = new TipoItem();

		tipoItem.setNome("Livro");

		l.setTitulo("TituloTesteDoLivroUpdate");
		l.setTipoItem(tipoItem);
		l.setNome("Lingua Inglesa");
		l.setTema("Inlges");
		l.setArea("Letras");
		l.setEdicao("2012");
		l.setAutor("Souza");
		l.setNmrPagina(100);
		l.setEditora("LTDA");
		l.setQuantMax(5);
		l.setIsbn("ISBNdOLivro");

		try {
			itemServico.inserir(l);
		} catch (ItemServicoException e) {
			assertFalse(e == null);
		}

		l.setNome(null);
		itemServico.atualizar(l);
	}

	@Test(expected = ItemServicoException.class)
	public void removerNulo() throws ItemServicoException {
		itemServico.remover(null);
	}

	@Test
	public void inserirInvalido() {
		Jornal j = new Jornal();

		// Sem Nome
		try {
			itemServico.inserir(j);
		} catch (ItemServicoException e) {
			assertTrue(true);
		}

		// Sem Ttulo
		j.setNome("Jornal");
		try {
			itemServico.inserir(j);
		} catch (ItemServicoException e) {
			assertTrue(true);
		}

		// Sem Tipo
		j.setTipoItem(new TipoItem());
		try {
			itemServico.inserir(j);
		} catch (ItemServicoException e) {
			assertTrue(true);
		}
	}

	@Test
	public void inserirRecuperarItemLivro() {
		Livro l = new Livro();

		TipoItem tipoItem = new TipoItem();

		tipoItem.setNome("Livro");

		l.setTitulo("TituloTesteDoLivro");
		l.setTipoItem(tipoItem);
		l.setNome("Lingua Inglesa");
		l.setTema("Inlges");
		l.setArea("Letras");
		l.setEdicao("2012");
		l.setAutor("Souza");
		l.setNmrPagina(100);
		l.setEditora("LTDA");
		l.setQuantMax(5);
		l.setIsbn("ISBNdOLivro");

		try {
			itemServico.inserir(l);
		} catch (ItemServicoException e) {
			assertFalse(e == null);
		}

		Livro livroRecuperado;
		try {
			livroRecuperado = (Livro) itemServico.recuperarPorCodigo(l.getCodigo());
			assertEquals(livroRecuperado.getCodigo(), l.getCodigo());
		} catch (ItemServicoException e) {
			assertFalse(e != null);
		}

	}

	@Test
	public void testInserirRecuperarMidiaDigital() {
		MidiaDigital midiaDigital = new MidiaDigital();
		midiaDigital.setTitulo("TituloMidiaDigital");

		TipoMidiaDigital tipoMidiaDigital = new TipoMidiaDigital();
		tipoMidiaDigital.setNome("DVD");

		midiaDigital.setTipoMidiaDigital(tipoMidiaDigital);

		TipoItem tipoItem = new TipoItem();
		tipoItem.setNome("MidiaDigital");

		midiaDigital.setTipoItem(tipoItem);
		midiaDigital.setQuantMax(10);
		midiaDigital.setNome("NomeMidiaDigital");
		midiaDigital.setDataGravacao(new Date());

		try {
			itemServico.inserir(midiaDigital);
			Item i = itemServico.recuperarPorCodigo(midiaDigital.getCodigo());
			assertEquals(i.getCodigo(), midiaDigital.getCodigo());
		} catch (ItemServicoException e) {
			assertTrue(false);
		}

	}

	@Test(expected = ItemServicoException.class)
	public void inserirItemDuplicado() throws ItemServicoException {
		Jornal jornal = new Jornal();

		// Verificar caso algum teste ja tenha inserido um TipoItem

		jornal.setTitulo("TituloJornal_1");
		jornal.setNome("NomeJornal");

		TipoItem tipoItem = new TipoItem();
		tipoItem.setCod(0);
		tipoItem.setNome("Jornal");

		jornal.setTipoItem(tipoItem);

		itemServico.inserir(jornal);
		itemServico.inserir(jornal);

	}

	@Test
	public void testAtualizarItem() {
		Jornal j1 = new Jornal();
		j1.setTitulo("Jornal");
		j1.setNome("NomeJornal");

		j1.setTipoItem(new TipoItem());
		try {
			itemServico.inserir(j1);
		} catch (ItemServicoException e) {
			assertFalse(e != null);
		}

		Jornal j = null;

		String novoNome = "Jornal10";

		j1.setNome(novoNome);

		try {
			itemServico.atualizar(j1);
		} catch (ItemServicoException e) {
			assertFalse(e != null);
		}
		try {
			j = (Jornal) itemServico.recuperarPorCodigo(j1.getCodigo());
		} catch (ItemServicoException e) {
			assertFalse(e != null);
		}

		assertEquals(novoNome, j.getNome());
	}

	@Test
	public void testRemoverItem() {

		Jornal j1 = new Jornal();
		j1.setTitulo("JornalExcluir");
		j1.setNome("NomeJornalExcluir");
		j1.setCodigo(0);

		j1.setTipoItem(new TipoItem());
		try {
			itemServico.inserir(j1);
		} catch (ItemServicoException e) {
			assertTrue(false);
		}

		try {
			itemServico.remover(j1);
			Jornal j2 = (Jornal) itemServico.recuperarPorCodigo(j1.getCodigo());
			assertEquals(j2, null);
		} catch (ItemServicoException e) {
			assertTrue(false);
		}

	}

}
