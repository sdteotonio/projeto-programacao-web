package br.com.uepb.biblioteca.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import br.com.uepb.biblioteca.dao.AlunoDAOImpl;
import br.com.uepb.biblioteca.dao.DividaDAOImpl;
import br.com.uepb.biblioteca.dao.EmprestimoDAOImpl;
import br.com.uepb.biblioteca.dao.ItemDAOImpl;
import br.com.uepb.biblioteca.dao.ReservaDAOImpl;
import br.com.uepb.biblioteca.exception.EmprestimoException;
import br.com.uepb.biblioteca.model.Aluno;
import br.com.uepb.biblioteca.model.Item;
import br.com.uepb.biblioteca.model.Reserva;
import br.com.uepb.biblioteca.utils.BibliotecaDateTime;
import br.com.uepb.biblioteca.utils.Email;

/**
 * A classe Service da Reserva
 * 
 * @autor geovanniovinhas <vinhasgeovannio@gmail.com
 */
@Service
public class ReservaService {
	private static Logger logger = Logger.getLogger(Reserva.class);
	private ReservaDAOImpl reservaDAO;
	private AlunoDAOImpl alunoDAO;
	private ItemDAOImpl itemDAO;
	private DividaDAOImpl dividaDAO;
	private EmprestimoDAOImpl emprestimoDAO;

	/**
	 * Pegar a lista de todas as reservas cadastradas no sistema
	 * 
	 * @return List<Reserva>
	 */
	public List<Reserva> getListaReserva() {
		logger.info("Executa o metodo 'getListaReserva' do reservaService");
		reservaDAO = new ReservaDAOImpl();
		return reservaDAO.getLista();
	}

	/**
	 * Pegar todas as reservas do Aluno
	 * 
	 * @param idAluno
	 * @return
	 */
	public List<Reserva> getListaReservaByAluno(int idAluno) {
		logger.info("Executa o metodo 'getListaReservaByAluno' do reservaService " + idAluno);
		reservaDAO = new ReservaDAOImpl();
		return reservaDAO.getReservasByAlunoId(idAluno);
	}

	/**
	 * Aluno realiza a reserva de um item
	 * 
	 * @param idAluno
	 * @param idItem
	 * @param enviarEmail
	 * @return
	 * @throws EmprestimoException
	 */
	public boolean reservaItem(int idAluno, int idItem, boolean enviarEmail) throws EmprestimoException {
		logger.info("Executa o metodo 'reservaItem' do reservaService com param: " + idAluno + " e " + idItem + " e "
				+ enviarEmail);
		reservaDAO = new ReservaDAOImpl();
		alunoDAO = new AlunoDAOImpl();
		dividaDAO = new DividaDAOImpl();
		itemDAO = new ItemDAOImpl();
		emprestimoDAO = new EmprestimoDAOImpl();

		Item item = itemDAO.getById(idItem);
		Aluno aluno = alunoDAO.getById(idAluno);

		// Verifica se o aluno tem divida ainda
		if (dividaDAO.isAlunoTemDivida(idAluno)) {
			logger.error("O aluno ainda tem divida ainda nao pago: " + idAluno + " e " + idItem);
			throw new EmprestimoException("O aluno ainda tem divida ainda nao pago");
		}

		// Verifica se o item ainda tem no estoque
		if (item.getQuantidade() > 0) {
			logger.error("O aluno ainda tem divida ainda nao pago: " + idAluno + " e " + idItem);
			throw new EmprestimoException("O item ainda tem no etoque, para que fazer a reserva!");
		}

		// Verifica se falta mais de 20 dias para terminar o periodo
		String dataDevolucao = BibliotecaDateTime.getDataDevolucao(aluno.getCurso().getNivel());
		int dias = BibliotecaDateTime.diasParaFimPeriodo(dataDevolucao);
		if (dias < 20) {
			logger.error(
					"O emprestimo nao podera realizado, tem menos 20 dias para fim do periodo. dias para fim periodo: "
							+ dias);
			throw new EmprestimoException("O emprestimo nao podera realizado, tem menos 20 dias para fim do periodo");
		}

		Reserva reserva = new Reserva();
		reserva.setAluno(aluno);
		reserva.setItem(item);
		reserva.setDataReservado(BibliotecaDateTime.getDataCadastrado());
		reserva.setDataPegar(emprestimoDAO.getByItemId(idItem).getDataDevolucao());

		if (reservaDAO.isExiste(reserva)) {
			logger.error("A reserva para este item ja existe: " + idAluno + " e " + idItem);
			throw new EmprestimoException("A reserva para este item ja existe");
		}
		reservaDAO.inserir(reserva);

		if (enviarEmail) {
			logger.info("Enviar email no metodo 'reservaItem' " + aluno.getEmail());
			Email email = new Email();
			email.setEmailDestino(aluno.getEmail());
			email.sendNotificacaoReserva(reserva);
		}
		return true;
	}

	/**
	 * Cancelar a reserva do item
	 * 
	 * @param id
	 */
	public void cancelarReserva(int id) {
		logger.info("Executa o metodo 'cancelarReserva' do reservaService " + id);
		reservaDAO = new ReservaDAOImpl();
		reservaDAO.remover(reservaDAO.getById(id));
	}

}
