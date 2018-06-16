package br.com.uepb.biblioteca.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import br.com.uepb.biblioteca.dao.FuncionarioDAOImpl;
import br.com.uepb.biblioteca.exception.AutenticacaoException;
import br.com.uepb.biblioteca.model.Funcionario;

/**
 * A classe Service do Funcionario
 * 
 * @autor geovanniovinhas <vinhasgeovannio@gmail.com
 */
@Service
public class FuncionarioService {
	private static Logger logger = Logger.getLogger(FuncionarioService.class);
	private FuncionarioDAOImpl funcionarioDAO;

	/**
	 * Autenticar o funcionario
	 * 
	 * @param usuario
	 * @param senha
	 * @return Funcionario
	 * @throws AutenticacaoException
	 * @
	 */
	public Funcionario autenticar(String usuario, String senha) throws AutenticacaoException {
		logger.info("Executa o metodo 'autenticar' do funcionarioService");
		funcionarioDAO = new FuncionarioDAOImpl();
		return funcionarioDAO.login(usuario, senha);
	}

	/**
	 * Cadastra o funcionario
	 * 
	 * @param funcionario
	 * @return id do funcionario cadastrado @
	 */
	public int cadastrarFuncionario(Funcionario funcionario) {
		logger.info("Executa o metodo 'cadastrarFuncionario' funcionarioService: " + funcionario);
		funcionarioDAO = new FuncionarioDAOImpl();
		return funcionarioDAO.inserir(funcionario);
	}

	/**
	 * Retornar a lista dos funcionarios cadastrados no sistema
	 * 
	 * @return List<Funcionario>
	 */
	public List<Funcionario> getListaFuncionario() {
		logger.info("Executa o metodo 'getListaFuncionario' do funcionarioService");
		funcionarioDAO = new FuncionarioDAOImpl();
		return funcionarioDAO.getLista();
	}

	/**
	 * Atualizar o funcionario boolean
	 * 
	 * @param funcionario
	 * @return @
	 */
	public boolean atualizarFuncionario(Funcionario funcionario) {
		logger.info("Executa o metodo 'atualizarAluno' funcionarioService: " + funcionario);

		funcionarioDAO = new FuncionarioDAOImpl();
		funcionarioDAO.atualizar(funcionario);
		return true;
	}

	/**
	 * Apagar os dados do funcionario no sistema
	 * 
	 * @param funcionario
	 * @return boolean
	 */
	public boolean deletarFuncionario(Funcionario funcionario) {
		logger.info("Executa o metodo 'deletarFuncionario' funcionarioService: " + funcionario);
		funcionarioDAO = new FuncionarioDAOImpl();
		funcionarioDAO.remover(funcionario);
		return true;
	}

	/**
	 * Pegar os dados do Funcionario
	 * 
	 * @param id
	 * @return Funcionario
	 */
	public Funcionario getFuncionarioById(int id) {
		logger.info("Executa o metodo 'getFuncionarioById' funcionarioService: " + id);
		funcionarioDAO = new FuncionarioDAOImpl();
		return funcionarioDAO.getById(id);
	}

	// TODO Refatorado para recuperar por CPF tbm
	/**
	 * Pegar os dados do Funcionario
	 * 
	 * @param cpf
	 * @return Funcionario
	 */
	public Funcionario getFuncionarioByCpf(String cpf) {
		logger.info("Executa o metodo 'getFuncionarioByCpf' funcionarioService: " + cpf);
		funcionarioDAO = new FuncionarioDAOImpl();
		return funcionarioDAO.getByCpf(cpf);
	}

}
