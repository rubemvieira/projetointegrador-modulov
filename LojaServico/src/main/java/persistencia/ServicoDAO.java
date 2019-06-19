package persistencia;

import java.io.Serializable;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.Servico;

public class ServicoDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void gravar(Servico servico) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		if(servico.getId() == 0) {
			sessao.save(servico);
		} else {
			sessao.update(servico);
		}
		t.commit();
		sessao.close();
	}
	
	public static void excluir(Servico servico) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.delete(servico);
		t.commit();
		sessao.close();
	}
	
	
	public static List<Servico> listagem() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query<Servico> consulta = sessao.createQuery("from Servico order by descricao", Servico.class);
		List<Servico> lista = consulta.getResultList();
		sessao.close();
		return lista;
	}

}
