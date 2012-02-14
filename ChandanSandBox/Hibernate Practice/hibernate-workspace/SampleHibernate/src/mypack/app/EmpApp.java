package mypack.app;

import mypack.Emp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmpApp {

	/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session s = factory.openSession();
		Emp e = new Emp("chandan", "Sr. Software Engineer", 70000);
		Transaction t = s.beginTransaction();
		s.save(e);
		t.commit();
		s.close();
		System.out.println("persisted.");

	}

}
