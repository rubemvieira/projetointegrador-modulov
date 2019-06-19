package negocio;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import bean.Pessoa;
import persistencia.PessoaDAO;

@ManagedBean
@SessionScoped
public class PessoaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Pessoa pessoa;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setServico(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getListagem() {
		return PessoaDAO.listagem();
	}	

	public String actionGravar() {
		PessoaDAO.gravar(pessoa);
		return ("lista_pessoas" );
	}
	
	public String actionInserir() {
		pessoa = new Pessoa();
		pessoa.setId(0);
		return "formulario_pessoa";
	}
	
	public String actionExcluir(Pessoa m) {
		PessoaDAO.excluir(m);
		return "lista_pessoas";
	}
	
	public String actionAlterar(Pessoa m) {
		pessoa = m;
		return "formulario_pessoa";
	}
	
	public String actionListar() {
		return "lista_pessoas";
	}

}
