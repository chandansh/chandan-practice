package mypack.app;

import java.util.Scanner;

import mypack.Emp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SelectEmpTest {

	/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session ses = factory.openSession();
		System.out.println("enter the emp id:");
		Scanner scan = new Scanner(System.in);
		int id = scan.nextInt();
		Emp e1 = (Emp) ses.get(Emp.class, id);
		System.out.println("id: " + e1.getId() + "\tname: " + e1.getName()
				+ "\tjob: " + e1.getJob() + "\t salary: " + e1.getSalary());
		ses.close();

	}

}
