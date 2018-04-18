package entidade;

import java.io.Serializable;
import java.util.Date;

/***
 * Classe de objetos do tipo Midia Digital, que herdam as características do Item,
 * com valores e métodos dos mesmos.
 * @author Bianca
 *
 */
public class MidiaDigital extends Item implements Serializable{
	
	private static final long serialVersionUID = 2482943632687981431L;
	private Date dataGravacao;
	private TipoMidiaDigital tipoMidiaDigital;
	
	public Date getDataGravacao() {
		return dataGravacao;
	}
	public void setDataGravacao(Date dataGravacao) {
		this.dataGravacao = dataGravacao;
	}
	public TipoMidiaDigital getTipoMidiaDigital() {
		return tipoMidiaDigital;
	}
	public void setTipoMidiaDigital(TipoMidiaDigital tipoMidiaDigital) {
		this.tipoMidiaDigital = tipoMidiaDigital;
	}
	
	
}
