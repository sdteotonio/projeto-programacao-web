package entidade;

import java.util.Date;


public class MidiaDigital extends Item {
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
