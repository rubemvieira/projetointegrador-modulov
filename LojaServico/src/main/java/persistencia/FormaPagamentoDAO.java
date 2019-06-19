package persistencia;

import java.io.Serializable;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.FormaPagamento;


public class FormaPagamentoDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void gravar(FormaPagamento formaPagamento) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		if(formaPagamento.getId() == 0) {
			sessao.save(formaPagamento);
		} else {
			sessao.update(formaPagamento);
		}
		t.commit();
		sessao.close();
	}
	
	public static void excluir(FormaPagamento formaPagamento) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.delete(formaPagamento);
		t.commit();
		sessao.close();
	}
	
	
	public static List<FormaPagamento> listagem() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query<FormaPagamento> consulta = sessao.createQuery("from FormaPagamento order by descricao", FormaPagamento.class);
		List<FormaPagamento> lista = consulta.getResultList();
		sessao.close();
		return lista;
	}
	
	public FormaPagamento retrieveById(Integer id) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		FormaPagamento formapagamento = sessao.get(FormaPagamento.class, id);
		sessao.close();
		return formapagamento;		
	}

}
