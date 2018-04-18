package modelo;

import java.util.HashMap;

import org.apache.log4j.Logger;

import entidade.Item;
import enumerador.MensagensEnum;
import excecao.ItemModeloException;
import excecao.ItemModeloValidacaoException;


public class ItemModelo {
	private HashMap<String, Item> hashDeItem;

	private Logger LOGGER = Logger.getLogger(ItemModelo.class);

	public ItemModelo() {
		this.hashDeItem = new HashMap<String, Item>();
	}

	/**
	 * @param item
	 *            Utilizado para inserir um Item no sistema.
	 * @throws ItemModeloException
	 *             Caso ocorra algum erro ao inserir, seja por valida��o ou outro
	 *             tipo, ser� disparado uma exeception como essa.
	 */
	public void inserirItem(Item item) throws ItemModeloException {
		try {
			validarItem(item);
			if (hashDeItem.containsKey(item.getTitulo())) {
								throw new ItemModeloException(MensagensEnum.ITEM_MODELO_ITEM_JA_CADASTRADO.getValor());
			}
			hashDeItem.put(item.getTitulo(), item);

		} catch (ItemModeloValidacaoException e) {
			LOGGER.warn(MensagensEnum.ITEM_MODELO_ERRO_AO_VALIDAR_ITEM.getValor());
			throw new ItemModeloException(e.getMessage());
		}
	}

	/**
	 * @param item
	 *            Item recebido para validacao
	 * @throws ItemModeloValidacaoException
	 *             Caso seja detectado que o Item est� inv�lido para inser��o, uma
	 *             exception como esta ser� disparada.
	 */
	private void validarItem(Item item) throws ItemModeloValidacaoException {
		if (item == null) {
			throw new ItemModeloValidacaoException(MensagensEnum.ITEM_MODELO_O_ITEM_NAO_PODE_SER_NULO.getValor());
		} else if (item.getNome() == (null)) {
			throw new ItemModeloValidacaoException(MensagensEnum.ITEM_MODELO_O_NOME_PODE_NAO_SER_NULO.getValor());
		} else if (item.getTitulo() == (null)) {
			throw new ItemModeloValidacaoException(MensagensEnum.ITEM_MODELO_O_TITULO_PODE_NAO_SER_NULO.getValor());
		} else if (item.getTipoItem() == (null)) {
			throw new ItemModeloValidacaoException(
					MensagensEnum.ITEM_MODELO_O_TIPO_DE_ITEM_NAO_PODE_SER_NULO.getValor());
		}
	}

	/**
	 * @param titulo Titulo do Item que deseja recuperar
	 * @return Caso encontre, retorna com o objeto Item, que contem o titulo especificado
	 * @throws ItemModeloException Caso o Titulo especificado seja inv�lido
	 */
	public Item recuperarItemPorTitulo(String titulo) throws ItemModeloException {
		if (titulo == null) {
			LOGGER.error(MensagensEnum.ITEM_MODELO_PARAMETRO_DE_BUSCA_TITULO_VAZIO.getValor());
			throw new ItemModeloException(MensagensEnum.ITEM_MODELO_PARAMETRO_DE_BUSCA_TITULO_VAZIO.getValor());
		}
		return hashDeItem.get(titulo);
	}

	/**
	 * @param item Item para ser atualizado
	 * @throws ItemModeloException Caso ocorra algum erro na validacao do Item especificado
	 */
	public void atualizarItem(Item item) throws ItemModeloException {
		try {
			validarItem(item);
			Item itemRecuperado = recuperarItemPorTitulo(item.getTitulo());
			hashDeItem.put(itemRecuperado.getTitulo(), item);
		} catch (ItemModeloValidacaoException e) {
			LOGGER.warn(MensagensEnum.ITEM_MODELO_ERRO_AO_VALIDAR_ITEM.getValor());
			throw new ItemModeloException(e.getMessage());
		}
	}

	/**
	 * @param titulo Remover um item passando seu t�tulo como chave
	 * @return  Caso encontre, remove o item que tenha o nome especificado
	 * @throws ItemModeloException caso o titulo especificado seja inv�lido, lan�a uma exce��o
	 */
	public Item removerItemPorTitulo(String titulo) throws ItemModeloException {
		if (titulo == null) {
			LOGGER.error(MensagensEnum.ITEM_MODELO_PARAMETRO_DE_BUSCA_TITULO_VAZIO.getValor());
			throw new ItemModeloException(MensagensEnum.ITEM_MODELO_PARAMETRO_DE_BUSCA_TITULO_VAZIO.getValor());
		}
		return hashDeItem.remove(titulo);
	}

}
