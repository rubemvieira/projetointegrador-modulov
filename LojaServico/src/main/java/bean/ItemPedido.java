package bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "itenspedido")
public class ItemPedido implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "itenspedido_id")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;		
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;		
	@ManyToOne
	@JoinColumn(name = "servico_id")
	private Servico servico;		
	@Column(name = "dataautorizacao")
	private Date dataAutorizacao;
	
	@Column(name = "qtde")
    private Double quantidade;	
	@Column(name = "valorunit")
    private Double valorunitario;	
	@Column(name = "subtotal")
    private Double subtotal;	
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Pedido getPedido() {
		return pedido;
	}


	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	public Servico getServico() {
		return servico;
	}


	public void setServico(Servico servico) {
		this.servico = servico;
	}


	public Date getDataAutorizacao() {
		return dataAutorizacao;
	}


	public void setDataAutorizacao(Date dataAutorizacao) {
		this.dataAutorizacao = dataAutorizacao;
	}


	public Double getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}


	public Double getValorunitario() {
		return valorunitario;
	}


	public void setValorunitario(Double valorunitario) {
		this.valorunitario = valorunitario;
	}


	public Double getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}


	public ItemPedido() {
		// TODO Auto-generated constructor stub
	}

}
