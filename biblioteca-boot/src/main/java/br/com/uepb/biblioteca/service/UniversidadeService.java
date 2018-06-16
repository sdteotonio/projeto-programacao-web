package br.com.uepb.biblioteca.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import br.com.uepb.biblioteca.dao.FuncionarioDAOImpl;
import br.com.uepb.biblioteca.dao.UniversidadeDAOImpl;
import br.com.uepb.biblioteca.model.Funcionario;
import br.com.uepb.biblioteca.model.Universidade;
import br.com.uepb.biblioteca.utils.BibliotecaDateTime;
import br.com.uepb.biblioteca.utils.Email;

/**
 * Classe Service da Universidade
 * 
 * @autor geovanniovinhas <vinhasgeovannio@gmail.com
 */
@Service
public class UniversidadeService {
	private static Logger logger = Logger.getLogger(UniversidadeService.class);
	private UniversidadeDAOImpl universidadeDAO;
	private FuncionarioDAOImpl funcionarioDAO;

	/**
	 * Cadastra universidade no sistema
	 * 
	 * @param universidade
	 * @return
	 */
	public int cadastrarUniversidade(Universidade universidade) {
		logger.info("Executa o metodo 'cadastrarUniversidade' do universidadeService com param: " + universidade);
		universidadeDAO = new UniversidadeDAOImpl();
		return universidadeDAO.inserir(universidade);
	}

	/**
	 * Atualizar universidade no sistema
	 * 
	 * @param universidade
	 */
	public void atualizarUniversidade(Universidade universidade, Funcionario funcionarioLogado) {
		logger.info("Executa o metodo 'atualizarUniversidade' do universidadeService com param: " + universidade);
		universidadeDAO = new UniversidadeDAOImpl();
		funcionarioDAO = new FuncionarioDAOImpl();
		Funcionario funcionario = funcionarioDAO.getById(funcionarioLogado.getId());

		universidadeDAO.atualizar(universidade);
		String dataHoje = BibliotecaDateTime.getDataCadastrado();
		int dias = BibliotecaDateTime.diasParaFimPeriodo(dataHoje);

		if (dias <= 0) {
			Email email = new Email();
			email.setEmailDestino(funcionario.getEmail());
			email.sendRelatorio();
		}

	}

	/**
	 * Pegar o objeto Universidade Universidade
	 * 
	 * @return Universidade
	 */
	public Universidade getUniversidade() {
		universidadeDAO = new UniversidadeDAOImpl();
		return universidadeDAO.get();
	}

}
