package negocio;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import bean.FormaPagamento;
import persistencia.FormaPagamentoDAO;

@ManagedBean
@SessionScoped
public class FormaPagamentoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private FormaPagamento formaPagamento;

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setServico(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public List<FormaPagamento> getListagem() {
		return FormaPagamentoDAO.listagem();
	}	

	public String actionGravar() {
		FormaPagamentoDAO.gravar(formaPagamento);
		return ("lista_formaPagamentos" );
	}
	
	public String actionInserir() {
		formaPagamento = new FormaPagamento();
		formaPagamento.setId(0);
		return "formulario_formaPagamento";
	}
	
	public String actionExcluir(FormaPagamento m) {
		FormaPagamentoDAO.excluir(m);
		return "lista_formaPagamentos";
	}
	
	public String actionAlterar(FormaPagamento m) {
		formaPagamento = m;
		return "formulario_formaPagamento";
	}
	
	public String actionListar() {
		return "lista_formaPagamentos";
	}
	
}
