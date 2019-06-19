package persistencia;

import java.io.Serializable;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.Pessoa;

public class PessoaDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void gravar(Pessoa pessoa) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		if(pessoa.getId() == 0) {
			sessao.save(pessoa);
		} else {
			sessao.update(pessoa);
		}
		t.commit();
		sessao.close();
	}
	
	public static void excluir(Pessoa pessoa) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.delete(pessoa);
		t.commit();
		sessao.close();
	}
	
	
	public static List<Pessoa> listagem() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query<Pessoa> consulta = sessao.createQuery("from Pessoa order by nome", Pessoa.class);
		List<Pessoa> lista = consulta.getResultList();
		sessao.close();
		return lista;
	}

	public Pessoa retrieveById(Long id) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Pessoa pessoa = sessao.get(Pessoa.class, id);
		sessao.close();
		return pessoa;		
	}	
	
	public Pessoa retrieveByEmail(String email) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Pessoa consulta = sessao.createQuery("from Pessoa where email = :Email", Pessoa.class).setParameter("Email", email).uniqueResult();
		sessao.close();
		return consulta;
	}
	
}
