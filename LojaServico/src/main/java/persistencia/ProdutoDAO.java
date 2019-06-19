package persistencia;

import java.io.Serializable;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.Produto;

public class ProdutoDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void gravar(Produto produto) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		if(produto.getId() == 0) {
			sessao.save(produto);
		} else {
			sessao.update(produto);
		}
		t.commit();
		sessao.close();
	}
	
	public static void excluir(Produto produto) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.delete(produto);
		t.commit();
		sessao.close();
	}
	
	
	public static List<Produto> listagem() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query<Produto> consulta = sessao.createQuery("from Produto order by nome", Produto.class);
		List<Produto> lista = consulta.getResultList();
		sessao.close();
		return lista;
	}

}
