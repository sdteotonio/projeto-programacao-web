package com.ufab.servico.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ufab.config.Config;
import com.ufab.entidade.Jornal;
import com.ufab.entidade.TipoItem;
import com.ufab.servico.IItemServico;
import com.ufab.servico.ILocacaoServico;
import com.ufab.servico.ITipoItemServico;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { Config.class })
public class LocacaoServicoTest {

	@Autowired
	private ILocacaoServico locacaoServico;
	
	@Autowired
	private IItemServico itemServico;
	
	@Autowired
	private ITipoItemServico  tipoItemServico;
	
	@Test
	public void emprestarItem() {
		Jornal j1 = new Jornal();
		j1.setNome("Jornal Teste 1");
		j1.setData(new Date());
		j1.setEdicao("Edicao Teste");
		j1.setQuantMax(50);
		j1.setTipoItem(TipoItem.JORNAL);
		
		j1.setTitulo("Titulo do Jornal Teste");
		
		
		
	}
}
