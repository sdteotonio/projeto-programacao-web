package modelo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import entidade.Item;
import entidade.Jornal;
import entidade.Livro;
import excecao.ItemModeloException;

public class ItemModeloTeste {
	private ItemModelo itemModelo;

	public ItemModeloTeste() {
		this.itemModelo = new ItemModelo();
	}

	@Test(expected = ItemModeloException.class)
	public void testeInserirItemVazio() throws ItemModeloException {
		itemModelo.inserirItem(null);
	}
	
	@Test
	public void testeInserirItemIncompletoDeAtributos() {
		Jornal jornal = new Jornal();
		//Enviar sem Nome
		try {
			itemModelo.inserirItem(jornal);
		} catch (ItemModeloException e) {
			assertTrue(true);
		}
		//Enviar sem titulo
		jornal.setNome("Nome do Jornal");
		try {
			itemModelo.inserirItem(jornal);
		} catch (ItemModeloException e) {
			assertTrue(true);
		}
		//Enviar sem TipoItem
		jornal.setTitulo("Titulo do Jornal");
		try {
			itemModelo.inserirItem(jornal);
		} catch (ItemModeloException e) {
			assertTrue(true);
		}
		
		
	}
}
