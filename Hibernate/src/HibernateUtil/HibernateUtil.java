package HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	
	private static Session session;
	public static String erro=null;
	public static Session abrirSession() { //buildSessionFactory() {
	try {
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	// pegando as configura��e da session factory do arquivo hibernate.cfg.xml
	session = sessionFactory.openSession(); // abre uma sess�o com o BD
	return session; // retorna esta sess�o para quem o chamou
	} catch (Throwable e) {
	erro = e.toString();
	return null;
	}
	}
	public static void fecharSession() {
	if(session!=null ) {
	session.close();
	}
	}
}
