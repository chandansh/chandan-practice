package mypack.app;

import java.util.Scanner;

import mypack.Emp;
import mypack.factory.MySessionFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ConnectedUpdate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session ses = MySessionFactory.getSession();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter id:");
		int id = in.nextInt();
		in.nextLine();
		System.out.println("Fetching objects.");
		Emp e = (Emp) ses.load(Emp.class, id);
		System.out.println("Enter new job:");
		String j=in.nextLine();
		System.out.println("Enter new Salary:");
		int sal=in.nextInt();
		Transaction t= ses.beginTransaction();
		e.setJob(j);
		e.setSalary(sal);
		t.commit();
		ses.close();
		System.out.println("Updated");
	}

}
