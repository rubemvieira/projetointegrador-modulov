package negocio;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import bean.Servico;
import persistencia.ServicoDAO;

@ManagedBean
@SessionScoped
public class ServicoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Servico servico;

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public List<Servico> getListagem() {
		return ServicoDAO.listagem();
	}	

	public String actionGravar() {
		ServicoDAO.gravar(servico);
		return ("lista_servicos" );
	}
	
	public String actionInserir() {
		servico = new Servico();
		servico.setId(0);
		return "formulario_servico";
	}
	
	public String actionExcluir(Servico m) {
		ServicoDAO.excluir(m);
		return "lista_servicos";
	}
	
	public String actionAlterar(Servico m) {
		servico = m;
		return "formulario_servico";
	}
	
	public String actionListar() {
		return "lista_servicos";
	}

}
