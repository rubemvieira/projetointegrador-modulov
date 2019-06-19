package bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fone")
public class Fone implements Serializable {

	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2131272464788833307L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fone_id")
	private Integer id;
	@Column(name = "numero")
    private String numero;
	@Column(name = "descricao")
    private String descricao;	

	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;	

	public Fone() {
		// TODO Auto-generated constructor stub
	}

}
