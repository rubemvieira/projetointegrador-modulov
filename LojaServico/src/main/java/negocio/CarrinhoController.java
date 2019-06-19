package negocio;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import bean.ItemPedido;
import bean.Pedido;
import bean.Pessoa;
import wrapper.Produto;
import persistencia.PedidoDAO;
import persistencia.PessoaDAO;
import persistencia.ProdutoDAO;


@ManagedBean
@SessionScoped
public class CarrinhoController  implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		result = prime * result + ((produtoSelecionado == null) ? 0 : produtoSelecionado.hashCode());
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
		CarrinhoController other = (CarrinhoController) obj;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		if (produtoSelecionado == null) {
			if (other.produtoSelecionado != null)
				return false;
		} else if (!produtoSelecionado.equals(other.produtoSelecionado))
			return false;
		return true;
	}

	private Pedido pedido = new Pedido();
	private Produto produtoSelecionado;
	private Double quantidade;
	private Pessoa cliente;
	
	public CarrinhoController() {
		// TODO Auto-generated constructor stub
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public void actionInserirProduto() {
		if (pedido == null)
			pedido = new Pedido();

		Double quantidade = produtoSelecionado.getQuantidade();
		 
		ItemPedido item = new ItemPedido();
		item.setPedido(pedido);
		item.setProduto(produtoSelecionado.getProduto());
		item.setValorunitario(produtoSelecionado.getProduto().getPreco());
		item.setQuantidade(quantidade);
		item.setSubtotal(quantidade * produtoSelecionado.getProduto().getPreco());
		pedido.setTotalproduto(pedido.getTotalproduto() == null ? 0.00 : pedido.getTotalproduto());
		pedido.setTotalproduto(pedido.getTotalproduto() + item.getSubtotal());
		pedido.setTotalgeral(pedido.getTotalproduto());
		pedido.getItens().add(item);
		quantidade = 0.0;
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Sucesso",  "Produto incluído no carrinho!"));		
	}
	
	public String actionFinalizarPedido() {
		
		if (pedido == null) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Erro",  "Carrinho vazio!"));
			return "/index.html";
		}

		pedido.setId(0);
		pedido.setPessoa(this.getUsuarioLogado());
		PedidoDAO.gravar(pedido);
		limparCarrinho();
		return "/cliente/cliente";
	}
	
	public String getQuantidadeItens() {
		if (pedido != null)
			return Integer.toString(pedido.getItens() != null ? pedido.getItens().size() : 0);
		else
			return "0";
	}
	
	public List<Produto> getListagem() {
		List<bean.Produto> lista = ProdutoDAO.listagem();
		List<Produto> ret = new ArrayList<>();
		
		if (!lista.isEmpty()) {
			for(int i = 0; i < lista.size(); i++) {
				Produto w = new Produto();
				w.setProduto(lista.get(i));
				w.setQuantidade(0.0);
				ret.add(w);
			}	
		}
		return ret;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		if(quantidade != null)
			this.quantidade = quantidade;
	}

	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}	
	
	public Pessoa getUsuarioLogado() {
		UserDetails user = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		PessoaDAO p = new PessoaDAO();
		return p.retrieveByEmail(user.getUsername());
	}
	
	public void limparCarrinho() {
		this.setCliente(null);
		this.setProdutoSelecionado(null);
		this.setQuantidade(null);
		this.setPedido(null);
	}
	
}
