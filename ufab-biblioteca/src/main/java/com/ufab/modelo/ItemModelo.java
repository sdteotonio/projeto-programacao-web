package com.ufab.modelo;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.ufab.entidade.Item;
import com.ufab.enumerador.MensagensEnum;
import com.ufab.excecao.ItemModeloException;
import com.ufab.excecao.ItemModeloValidacaoException;

//TODO: Alterar a ItemModelo para trablhar com todos os tipoos de Itens, passar a responsabildiade para cada Modelo de item.
/**
 * Responsavel por gerenciar todas as funcionalidades de Item
 * 
 * @author Davi
 *
 */
public class ItemModelo {
	private HashMap<String, Item> hashDeItem;

	private Logger LOGGER = Logger.getLogger(ItemModelo.class);

	public ItemModelo() {
		this.hashDeItem = new HashMap<String, Item>();
	}

	/**
	 * Inserir um Item no sistema, caso o mesmo esteja válido.
	 * 
	 * @param item
	 *            Item que deseja ser inerido no sistema.
	 * @throws ItemModeloException
	 *             Caso ocorra algum erro ao inserir, seja por valida��o ou outro
	 *             tipo, ser� disparado uma exeception como essa.
	 */
	public void inserirItem(Item item) throws ItemModeloException {
		try {
			validarItem(item);
			if (hashDeItem.containsKey(item.getTitulo())) {
				throw new ItemModeloException(MensagensEnum.ITEM_SERVICO_ITEM_JA_CADASTRADO.getValor());
			}
			hashDeItem.put(item.getTitulo(), item);

		} catch (ItemModeloValidacaoException e) {
			LOGGER.warn(MensagensEnum.ITEM_SERVICO_ERRO_AO_VALIDAR_ITEM.getValor());
			throw new ItemModeloException(e.getMessage());
		}
	}

	/**
	 * Validar se o Item recebido está pronto para ser utilizado, inserido, alterado
	 * e etc.
	 * 
	 * @param item
	 *            Item recebido para validacao
	 * @throws ItemModeloValidacaoException
	 *             Caso seja detectado que o Item est� inv�lido para inser��o, uma
	 *             exception como esta ser� disparada.
	 */
	private void validarItem(Item item) throws ItemModeloValidacaoException {
		if (item == null) {
			throw new ItemModeloValidacaoException(MensagensEnum.ITEM_SERVICO_O_ITEM_NAO_PODE_SER_NULO.getValor());
		} else if (item.getNome() == (null)) {
			throw new ItemModeloValidacaoException(MensagensEnum.ITEM_SERVICO_O_NOME_PODE_NAO_SER_NULO.getValor());
		} else if (item.getTitulo() == (null)) {
			throw new ItemModeloValidacaoException(MensagensEnum.ITEM_SERVICO_O_TITULO_PODE_NAO_SER_NULO.getValor());
		} else if (item.getTipoItem() == (null)) {
			throw new ItemModeloValidacaoException(
					MensagensEnum.ITEM_SERVICO_O_TIPO_DE_ITEM_NAO_PODE_SER_NULO.getValor());
		}
	}

	/**
	 * Metodo utilizado para recuperar um Item de acordo como seu Titulo.
	 * 
	 * @param titulo
	 *            Titulo do Item que deseja recuperar
	 * @return Caso encontre, retorna com o objeto Item, que contem o titulo
	 *         especificado.
	 * @throws ItemModeloException
	 *             Caso o Titulo especificado seja inv�lido
	 */
	public Item recuperarItemPorTitulo(String titulo) throws ItemModeloException {
		if (titulo == null) {
			LOGGER.error(MensagensEnum.ITEM_SERVICO_PARAMETRO_DE_BUSCA_TITULO_VAZIO.getValor());
			throw new ItemModeloException(MensagensEnum.ITEM_SERVICO_PARAMETRO_DE_BUSCA_TITULO_VAZIO.getValor());
		}
		return hashDeItem.get(titulo);
	}

	/**
	 * Atualizar um Item no sistema.
	 * 
	 * @param item
	 *            Item que deseja ser atualizado.
	 * @throws ItemModeloException
	 *             Caso ocorra algum erro na validacao do Item especificado
	 */
	public void atualizarItem(Item item) throws ItemModeloException {
		try {
			validarItem(item);
			Item itemRecuperado = recuperarItemPorTitulo(item.getTitulo());
			hashDeItem.put(itemRecuperado.getTitulo(), item);
		} catch (ItemModeloValidacaoException e) {
			LOGGER.warn(MensagensEnum.ITEM_SERVICO_ERRO_AO_VALIDAR_ITEM.getValor());
			throw new ItemModeloException(e.getMessage());
		}
	}

	/**
	 * Remover um Item do sistema que possu ao Titulo informado.
	 * 
	 * @param titulo
	 *            Titulo do item que deseja ser removido.
	 * @return Caso encontre, remove o item que tenha o nome especificado e retorna
	 *         o mesmo.
	 * @throws ItemModeloException
	 *             caso o titulo especificado seja invalido, lanca uma excecao
	 */
	public Item removerItemPorTitulo(String titulo) throws ItemModeloException {
		if (titulo == null) {
			LOGGER.error(MensagensEnum.ITEM_SERVICO_PARAMETRO_DE_BUSCA_TITULO_VAZIO.getValor());
			throw new ItemModeloException(MensagensEnum.ITEM_SERVICO_PARAMETRO_DE_BUSCA_TITULO_VAZIO.getValor());
		}
		return hashDeItem.remove(titulo);
	}

}
