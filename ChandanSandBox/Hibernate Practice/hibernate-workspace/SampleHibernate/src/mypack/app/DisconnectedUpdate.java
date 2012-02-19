package mypack.app;

import java.util.Scanner;

import mypack.Emp;
import mypack.EmpDao;

public class DisconnectedUpdate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		EmpDao dao = new EmpDao();
		System.out.println("Enter id:");
		int id = in.nextInt();
		in.nextLine();
		System.out.println("Fetching objects.");
		Emp e = dao.getEmp(id);
		System.out.println("Enter new job:");
		String j = in.nextLine();
		System.out.println("Enter new Salary:");
		int sal = in.nextInt();
		e.setJob(j);
		e.setSalary(sal);
		dao.update(e);
		System.out.println("Updated");
	}

}
