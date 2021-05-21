package AcessoBd;

import org.hibernate.Session;

import HibernateUtil.HibernateUtil;

public class AcessoBd {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.abrirSession();
		session.beginTransaction();
		
		
		session.getTransaction().commit();
		session.close();
	}

}
