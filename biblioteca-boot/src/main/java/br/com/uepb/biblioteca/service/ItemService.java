package br.com.uepb.biblioteca.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import br.com.uepb.biblioteca.dao.ItemDAOImpl;
import br.com.uepb.biblioteca.enums.TipoFuncionario;
import br.com.uepb.biblioteca.exception.AutenticacaoException;
import br.com.uepb.biblioteca.exception.ExistException;
import br.com.uepb.biblioteca.model.Funcionario;
import br.com.uepb.biblioteca.model.Item;

/**
 * A Classe Servidce do Item
 * 
 * @autor geovanniovinhas <vinhasgeovannio@gmail.com
 */
@Service
public class ItemService {
	private ItemDAOImpl itemDAO;
	private static Logger logger = Logger.getLogger(ItemService.class);

	// TODO: Remover o excesso de log
	/**
	 * Pegar o item pelo seu ID
	 * 
	 * @param idItem
	 * @return {@link Item}
	 */
	public Item getItemById(int idItem) {
		itemDAO = new ItemDAOImpl();
		return itemDAO.getById(idItem);
	}

	/**
	 * Retornar a lista dos itens cadastrados no sistema
	 * 
	 * @return List<Item>
	 */
	public List<Item> getListaItem() {
		itemDAO = new ItemDAOImpl();
		return itemDAO.getLista();
	}

	/**
	 * Cadastra os itens de acordo com os seus tipos. So o admin que pode realizar
	 * essa funcionalidade, retornar o id salvo do banco
	 * 
	 * @param funcionario
	 * @param item
	 * @return int
	 * @throws AutenticacaoException
	 * @throws ExistException
	 */
	public int cadastraItem(Funcionario funcionario, Item item) throws AutenticacaoException, ExistException {
		if (!funcionario.getTipoFunc().equals(TipoFuncionario.ADMINISTRADOR)) {
			logger.error("Funcionario nao autorizado, idFuncionario: " + funcionario.getId());
			throw new AutenticacaoException("Este funcionario nao esta autorizado");
		} else {
			itemDAO = new ItemDAOImpl();
			if (itemDAO.isExiste(item)) {
				logger.warn("Item ja existe, titulo item: " + item.getTitulo());
				throw new ExistException("Item ja existe");
			} else {
				logger.info("O item salvo com sucesso: " + item);
				return itemDAO.inserir(item);
			}
		}
	}

	/**
	 * Atualiza os itens de acordo com os seus tipos. So o admin que pode realizar
	 * essa funcionalidade, retornar true se for alvo no banco ao contrario false
	 * 
	 * @param funcionario
	 * @param item
	 * @return boolean
	 * @throws AutenticacaoException
	 * @throws ExistException
	 */
	public boolean atualizarItem(Funcionario funcionario, Item item) throws AutenticacaoException {
		if (!funcionario.getTipoFunc().equals(TipoFuncionario.ADMINISTRADOR)) {
			logger.error("Funcionario nao autorizado, idFuncionario: " + funcionario.getId());
			throw new AutenticacaoException("Este funcionario nao esta autorizado");
		} else {
			itemDAO = new ItemDAOImpl();
			itemDAO.atualizar(item);
			logger.info("O item atualizado com sucesso: " + item);
			return true;
		}
	}

	/**
	 * Remova os itens de acordo com os seus tipos. So o admin que pode realizar
	 * essa funcionalidade, retornar true se for alvo no banco ao contrario false
	 * 
	 * @param funcionario
	 * @param item
	 * @return boolean
	 * @throws AutenticacaoException
	 */
	public boolean removerItem(Funcionario funcionario, Item item) throws AutenticacaoException {
		if (!funcionario.getTipoFunc().equals(TipoFuncionario.ADMINISTRADOR)) {
			logger.error("Funcionario nao autorizado, idFuncionario: " + funcionario.getId());
			throw new AutenticacaoException("Este funcionario nao esta autorizado");
		} else {
			itemDAO = new ItemDAOImpl();
			itemDAO.remover(item);
			logger.info("O item removido com sucesso: " + item);
			return true;
		}
	}

}
