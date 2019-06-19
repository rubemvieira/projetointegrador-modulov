package bean;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pedido_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;	
	
	@ManyToOne
	@JoinColumn(name = "fpg_id")
	private FormaPagamento formapagamento;		

	@OneToMany(mappedBy="pedido", cascade = CascadeType.ALL)
	private Set<ItemPedido> itens;	
	
	public Set<ItemPedido> getItens() {
		if (itens == null)
			itens = new HashSet<ItemPedido>();
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}



	@Column(name = "dataemissao")
	private Date dataEmissao;

	@Column(name = "dataautorizacao")
	private Date dataAutorizacao;
	
	@Column(name = "totalproduto")
    private Double totalproduto;	
	@Column(name = "totalservico")
    private Double totalservico;	
	@Column(name = "totalgeral")
    private Double totalgeral;	
	@Column(name = "desconto")
    private Double desconto;	
	


	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Pessoa getPessoa() {
		return pessoa;
	}



	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}



	public FormaPagamento getFormapagamento() {
		return formapagamento;
	}



	public void setFormapagamento(FormaPagamento formapagamento) {
		this.formapagamento = formapagamento;
	}



	public Date getDataEmissao() {
		return dataEmissao;
	}



	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}



	public Date getDataAutorizacao() {
		return dataAutorizacao;
	}



	public void setDataAutorizacao(Date dataAutorizacao) {
		this.dataAutorizacao = dataAutorizacao;
	}



	public Double getTotalproduto() {
		return totalproduto;
	}



	public void setTotalproduto(Double totalproduto) {
		this.totalproduto = totalproduto;
	}



	public Double getTotalservico() {
		return totalservico;
	}



	public void setTotalservico(Double totalservico) {
		this.totalservico = totalservico;
	}



	public Double getTotalgeral() {
		return totalgeral;
	}



	public void setTotalgeral(Double totalgeral) {
		this.totalgeral = totalgeral;
	}



	public Double getDesconto() {
		return desconto;
	}



	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}



	public Pedido() {
		// TODO Auto-generated constructor stub
	}


}
