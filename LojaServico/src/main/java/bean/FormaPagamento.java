package bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "forma_pgto")
public class FormaPagamento implements Serializable {
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getMaximoParcelas() {
		return maximoParcelas;
	}

	public void setMaximoParcelas(Integer maximoParcelas) {
		this.maximoParcelas = maximoParcelas;
	}

	public Integer getPadraoParcelas() {
		return padraoParcelas;
	}

	public void setPadraoParcelas(Integer padraoParcelas) {
		this.padraoParcelas = padraoParcelas;
	}

	public Integer getIntervaloDias() {
		return intervaloDias;
	}

	public void setIntervaloDias(Integer intervaloDias) {
		this.intervaloDias = intervaloDias;
	}

	public Integer getPercentualAcrescimo() {
		return percentualAcrescimo;
	}

	public void setPercentualAcrescimo(Integer percentualAcrescimo) {
		this.percentualAcrescimo = percentualAcrescimo;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2131272464788833307L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fpg_id")
	private Integer id;
	@Column(name = "fpg_descricao")
    private String descricao;
	@Column(name = "fpg_num_max_parc")
    private Integer maximoParcelas;
	@Column(name = "fpg_num_padrao_parc")
    private Integer padraoParcelas;	
	@Column(name = "fpg_intervalo_dias")
    private Integer intervaloDias;
	@Column(name = "fpg_percentual_acres")
    private Integer percentualAcrescimo;	

	public FormaPagamento() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((intervaloDias == null) ? 0 : intervaloDias.hashCode());
		result = prime * result + ((maximoParcelas == null) ? 0 : maximoParcelas.hashCode());
		result = prime * result + ((padraoParcelas == null) ? 0 : padraoParcelas.hashCode());
		result = prime * result + ((percentualAcrescimo == null) ? 0 : percentualAcrescimo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FormaPagamento other = (FormaPagamento) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (intervaloDias == null) {
			if (other.intervaloDias != null)
				return false;
		} else if (!intervaloDias.equals(other.intervaloDias))
			return false;
		if (maximoParcelas == null) {
			if (other.maximoParcelas != null)
				return false;
		} else if (!maximoParcelas.equals(other.maximoParcelas))
			return false;
		if (padraoParcelas == null) {
			if (other.padraoParcelas != null)
				return false;
		} else if (!padraoParcelas.equals(other.padraoParcelas))
			return false;
		if (percentualAcrescimo == null) {
			if (other.percentualAcrescimo != null)
				return false;
		} else if (!percentualAcrescimo.equals(other.percentualAcrescimo))
			return false;
		return true;
	}

}
