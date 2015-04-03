package mypack.app;

import java.util.Scanner;

import mypack.Emp;
import mypack.factory.MySessionFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class RefreshTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session session = MySessionFactory.getSession();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter emp id:");
		final int id = in.nextInt();
		System.out.println("Fetching object...");
		Emp e = (Emp) session.load(Emp.class, id);
		System.out.println(e.getName() + "\t" + e.getJob() + "\t"
				+ e.getSalary());
		System.out.println("Object fetched starting new thread.");
		Thread t = new Thread() {
			public void run() {
				Session ses = MySessionFactory.getSession();
				System.out
						.println("new Thread Started obtaining object with id: "
								+ id);
				Emp e1 = (Emp) ses.get(Emp.class, id);
				System.out.println("Changing job an salary...");
				Transaction t = ses.beginTransaction();
				e1.setJob("Sr. Software engineer");
				e1.setSalary(90000);
				t.commit();
				ses.close();
				System.out.println("object updated new thread completing");
			}
		};
		t.start();
		System.out.println("suspending main thread for 2 sec");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println("main thread resumed refresh obj");
		session.refresh(e);
		System.out.println("Object refreshed printing details:");
		System.out.println(e.getName() + "\t" + e.getJob() + "\t"
				+ e.getSalary());
		session.close();
	}

}
