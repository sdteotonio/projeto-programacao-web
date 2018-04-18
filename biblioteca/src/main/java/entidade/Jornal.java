package entidade;

import java.io.Serializable;
import java.util.Date;

/***
 *  Classe de objetos do tipo jornal, que herdam do item suas características. 
 *  Com valores e métodos dos mesmos. 
 * @author Bianca
 *
 */
public class Jornal extends Item implements Serializable {
	
	private static final long serialVersionUID = -6797923940253789080L;
	private String edicao;
	private Date data;
	public String getEdicao() {
		return edicao;
	}
	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
}
