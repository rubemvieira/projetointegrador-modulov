package negocio;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import bean.Produto;
import persistencia.ProdutoDAO;

@ManagedBean
@SessionScoped
public class ProdutoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Produto produto;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getListagem() {
		return ProdutoDAO.listagem();
	}	

	public String actionGravar() {
		ProdutoDAO.gravar(produto);
		return ("lista_produtos" );
	}
	
	public String actionInserir() {
		produto = new Produto();
		produto.setId(0);
		return "formulario_produto";
	}
	
	public String actionExcluir(Produto m) {
		ProdutoDAO.excluir(m);
		return "lista_produtos";
	}
	
	public String actionAlterar(Produto m) {
		produto = m;
		return "formulario_produto";
	}
	
	public String actionListar() {
		return "lista_produtos";
	}

}
