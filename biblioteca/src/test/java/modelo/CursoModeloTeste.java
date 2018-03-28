package modelo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import servico.BaseDeDadosServico;

public class CursoModeloTeste {
	@Test
	public void inserirCursoTest() {
		BaseDeDadosServico.getInstancia().getConnection();
		BaseDeDadosServico.getInstancia().criarDataBase(true);
		assertTrue(true);
	}

}
