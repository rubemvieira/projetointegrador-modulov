package persistencia;

import java.io.Serializable;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.Pedido;
import bean.Pessoa;

public class PedidoDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void gravar(Pedido pedido) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		if(pedido.getId() == 0) {
			sessao.save(pedido);
		} else {
			sessao.update(pedido);
		}
		t.commit();
		sessao.close();
	}
	
	public static void excluir(Pedido pedido) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.delete(pedido);
		t.commit();
		sessao.close();
	}
	
	
	public static List<Pedido> listagem(Pessoa cliente) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query<Pedido> consulta = sessao.createQuery("from Pedido where pessoa = :Pessoa order by id", Pedido.class).setParameter("Pessoa", cliente);
		List<Pedido> lista = consulta.getResultList();
		sessao.close();
		return lista;
	}

}
