package negocio;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import bean.Pedido;
import bean.Pessoa;
import persistencia.PedidoDAO;
import persistencia.PessoaDAO;

@ManagedBean
@SessionScoped
public class PedidoController  implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private Pedido pedido;
	
	public List<Pedido> getListagem() {
		UserDetails user = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		PessoaDAO p = new PessoaDAO();
		Pessoa cliente = p.retrieveByEmail(user.getUsername());
		return PedidoDAO.listagem(cliente);
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}	
	
}
