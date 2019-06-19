package wrapper;

import java.io.Serializable;

public class Produto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Double quantidade;
	private bean.Produto produto;

	public Produto() {
		if(produto == null)
			produto = new bean.Produto();
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public bean.Produto getProduto() {
		return produto;
	}

	public void setProduto(bean.Produto produto) {
		this.produto = produto;
	}

}
