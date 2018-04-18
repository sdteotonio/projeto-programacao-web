package servico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import enumerador.MensagensEnum;
/**
 * Serviço que ira dispor uma conexão ao banco de dados
 * @author Davi
 *
 */
public class BaseDeDadosServico {
	/**
	 * Singleton
	 */
	private static BaseDeDadosServico minhaInstancia;
	private Logger LOGGER = Logger.getLogger(BaseDeDadosServico.class);
	private static String esquemaAtual;

	private BaseDeDadosServico() {

	}

	/**
	 * Metodo para implementacao do padrao Singleton
	 * @return Retorna uma instancia do Servico
	 */
	public static BaseDeDadosServico getInstancia() {
		if (minhaInstancia == null) {
			minhaInstancia = new BaseDeDadosServico();
		}
		return minhaInstancia;
	}

	/**
	 * Metodo que centraliza toda e qualquer conexão com a base de dados
	 * @return Retorna com uma conexao com a base de dados.
	 */
	public Connection getConnection() {
		Connection conn = null;
		try {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("jdbc:mysql://");
			stringBuilder.append(PropertiesService.getProp("database.host"));
			if (esquemaAtual != null) {
				stringBuilder.append("/" + esquemaAtual);
			}
			stringBuilder.append(
					"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false");
			// create a connection to the database
			conn = DriverManager.getConnection(stringBuilder.toString(), PropertiesService.getProp("database.usuario"),
					PropertiesService.getProp("database.senha"));
		} catch (SQLException e) {
			LOGGER.warn(MensagensEnum.ERRO_AO_CONECTAR_MYSQL.getValor());
			LOGGER.error(e);
		}
		return conn;
	}

	/**
	 * Metodo para iniciar a base de dados em uma nova maquina
	 * @param excluirAntesDeCriar
	 *            Parametro utilizado para determinar se ao crair a DataBase dever�
	 *            tamb�m deletar a base atual
	 */
	public void criarDataBase(boolean excluirAntesDeCriar) {
		if (excluirAntesDeCriar) {
			deletarEquema();
		}
		criarEsquema();
		criarTabelas();
	}

	/**
	 * Deletar o equema atual
	 */
	private void deletarEquema() {
		String sql = "DROP DATABASE IF EXISTS " + PropertiesService.getProp("database.esquema");
		Connection conn = getConnection();
		try {
			Statement stament = conn.prepareStatement(sql);
			stament.execute(sql);
			stament.close();
			conn.close();
		} catch (SQLException e) {
			LOGGER.warn(MensagensEnum.ERRO_AO_EXECUTAR_SQL.getValor());
			LOGGER.error(e);
		}
	}

	/**
	 * Metodo usado para criar o equema padrao da aplicacao
	 */
	private void criarEsquema() {
		String sql = "CREATE DATABASE IF NOT EXISTS " + PropertiesService.getProp("database.esquema");
		Connection conn = getConnection();
		try {
			Statement stament = conn.prepareStatement(sql);
			stament.execute(sql);
			stament.close();
			esquemaAtual = PropertiesService.getProp("database.esquema");
			conn.close();
		} catch (SQLException e) {
			LOGGER.warn(MensagensEnum.ERRO_AO_EXECUTAR_SQL.getValor());
			LOGGER.error(e);
		}

	}

	/**
	 * Cria todas as tabelas necessarias para a aplicacao
	 */
	private void criarTabelas() {
		String sql = "CREATE TABLE Usuario " + "(matricula VARCHAR(30) PRIMARY KEY," + "nome VARCHAR(50),"
				+ "senha TEXT," + "data_nascimento DATETIME," + "data_cadastro DATETIME," + "FK_Perfil_cod INT" + ");";
		Connection conn = getConnection();
		try {
			PreparedStatement stament = conn.prepareStatement(sql);
			stament.execute(sql);
			stament.close();
			conn.close();
		} catch (SQLException e) {
			LOGGER.warn(MensagensEnum.ERRO_AO_EXECUTAR_SQL.getValor());
			LOGGER.error(e);
		}
	}
}
