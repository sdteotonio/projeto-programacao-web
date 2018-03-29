package modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import entidade.Item;
import entidade.Jornal;
import entidade.Livro;
import entidade.MidiaDigital;
import entidade.TipoItem;
import entidade.TipoMidiaDigital;
import excecao.ItemModeloException;

public class ItemModeloTeste {
	private ItemModelo itemModelo;

	public ItemModeloTeste() {
		this.itemModelo = new ItemModelo();
	}

	@Test(expected = ItemModeloException.class)
	public void testeInserirItemVazio() throws ItemModeloException {
		Jornal jornal = null;
		itemModelo.inserirItem(jornal);
	}

	@Test(expected = ItemModeloException.class)
	public void testeInserirOItemDuplicado() throws ItemModeloException {
		Jornal jornal = new Jornal();

		jornal.setTitulo("TituloJornal_1");
		jornal.setNome("NomeJornal");

		TipoItem tipoItem = new TipoItem();
		tipoItem.setCod(0);
		tipoItem.setNome("Jornal");

		jornal.setTipoItem(tipoItem);

		itemModelo.inserirItem(jornal);
		itemModelo.inserirItem(jornal);
	}

	@Test
	public void testeInserirItemIncompletoDeAtributosPrincipais() {
		Jornal jornal = new Jornal();
		// Enviar sem Nome
		try {
			itemModelo.inserirItem(jornal);
		} catch (ItemModeloException e) {
			assertTrue(true);
		}
		// Enviar sem titulo
		jornal.setNome("Nome do Jornal");
		try {
			itemModelo.inserirItem(jornal);
		} catch (ItemModeloException e) {
			assertTrue(true);
		}
		// Enviar sem TipoItem
		jornal.setTitulo("Titulo do Jornal");
		try {
			itemModelo.inserirItem(jornal);
		} catch (ItemModeloException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testeInserirRecuperarItemJornal() {
		Jornal jornal = new Jornal();
		jornal.setTitulo("TituloJornal");

		TipoItem tipoItem = new TipoItem();
		tipoItem.setCod(1);
		tipoItem.setNome("Jornal");

		jornal.setTipoItem(tipoItem);
		jornal.setQuantMax(10);
		jornal.setNome("NomeJornal");
		jornal.setEdicao("EdicaoJornal");
		jornal.setData(new Date());

		try {
			itemModelo.inserirItem(jornal);
		} catch (ItemModeloException e) {
			assertFalse(e == null);
		}

		Jornal jornalRecuperado;
		try {
			jornalRecuperado = (Jornal) itemModelo.recuperarItemPorTitulo(jornal.getTitulo());
			assertEquals(jornal, jornalRecuperado);
		} catch (ItemModeloException e) {
			assertFalse(e != null);
		}
	}

	@Test
	public void testeInserirRecuperarLivro() {
		Livro livro = new Livro();
		livro.setAnoPublicacao(new Date());
		livro.setArea("AreaDoLivro");
		livro.setAutor("AutorDoLivro");
		livro.setEdicao("EdicaoDoLivro");
		livro.setEditora("EditoraDoLivro");
		livro.setIsbn("ISBNdOLivro");
		livro.setNmrPagina(200);
		livro.setNome("NomeDoLivro");
		livro.setQuantMax(10);
		livro.setTema("TemaDoLivro");

		TipoItem tipoItem = new TipoItem();
		tipoItem.setCod(2);
		tipoItem.setNome("Livro");
		livro.setTipoItem(tipoItem);
		livro.setTitulo("TituloLivro");

		try {
			itemModelo.inserirItem(livro);
		} catch (ItemModeloException e) {
			assertFalse(e != null);
		}

		Livro livroRecuperado;
		try {
			livroRecuperado = (Livro) itemModelo.recuperarItemPorTitulo(livro.getTitulo());
			assertEquals(livro, livroRecuperado);
		} catch (ItemModeloException e) {
			assertFalse(e != null);
		}
	}

	@Test
	public void testeInserirRecuperarMidiaDigital() {
		MidiaDigital midiaDigital = new MidiaDigital();
		midiaDigital.setTitulo("TituloMidiaDigital");

		TipoMidiaDigital tipoMidiaDigital = new TipoMidiaDigital();
		tipoMidiaDigital.setCod(0);
		tipoMidiaDigital.setNome("DVD");

		midiaDigital.setTipoMidiaDigital(tipoMidiaDigital);

		TipoItem tipoItem = new TipoItem();
		tipoItem.setCod(0);
		tipoItem.setNome("MidiaDigital");

		midiaDigital.setTipoItem(tipoItem);
		midiaDigital.setQuantMax(10);
		midiaDigital.setNome("NomeMidiaDigital");
		midiaDigital.setDataGravacao(new Date());

		try {
			itemModelo.inserirItem(midiaDigital);
		} catch (ItemModeloException e) {
			assertFalse(e != null);
		}

		MidiaDigital midiaDigitalRecuperado;
		try {
			midiaDigitalRecuperado = (MidiaDigital) itemModelo.recuperarItemPorTitulo(midiaDigital.getTitulo());
			assertEquals(midiaDigital, midiaDigitalRecuperado);
		} catch (ItemModeloException e) {
			assertFalse(e != null);
		}
	}

	@Test
	public void testeAtualizarItem() {
		Jornal j1 = new Jornal();
		j1.setTitulo("Jornal");
		j1.setNome("NomeJornal");

		j1.setTipoItem(new TipoItem());
		try {
			itemModelo.inserirItem(j1);
		} catch (ItemModeloException e) {
			assertFalse(e != null);
		}

		Jornal j = null;
		try {
			j = (Jornal) itemModelo.recuperarItemPorTitulo("Jornal");
		} catch (ItemModeloException e) {
			assertFalse(e != null);
		}

		String novoNome = "Jornal10";
		

		assertEquals(j1.getNome(), j.getNome());

		j.setNome(novoNome);

		try {
			itemModelo.atualizarItem(j1);
		} catch (ItemModeloException e) {
			assertFalse(e != null);
		}
		try {
			j = (Jornal) itemModelo.recuperarItemPorTitulo("Jornal");
		} catch (ItemModeloException e) {
			assertFalse(e != null);
		}
		
		assertEquals(novoNome, j.getNome());
		
		
	}
}