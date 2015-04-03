package com.helloworld;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PersonDetail {
	private static SessionFactory sessionFactory;

	public static void main(String[] args) {
		Session session = null;
		try {
			try {
				// Configuration cfg = new
				// Configuration().addResource("person.hbm.xml").configure();
				Configuration cfg = new Configuration().configure();
				sessionFactory = cfg.buildSessionFactory();
			} catch (Throwable ex) {
				System.err.println("Failed to create sessionFactory object."
						+ ex);
				throw new ExceptionInInitializerError(ex);
			}
			session = sessionFactory.openSession();

			Person person = new Person();
			System.out.println("Inserting Record");
			Transaction tx = session.beginTransaction();
			person.setId(2);
			person.setName("Roseindia");
			session.save(person);
			tx.commit();
			System.out.println("Done");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
	}
}