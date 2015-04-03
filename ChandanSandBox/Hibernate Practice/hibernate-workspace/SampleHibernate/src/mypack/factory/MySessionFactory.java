package mypack.factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class MySessionFactory {
	static SessionFactory factory;
	static {
		Configuration cfg = new Configuration().configure();
		factory = cfg.buildSessionFactory();
	}

	public static Session getSession() {
		return factory.openSession();
	}
}
