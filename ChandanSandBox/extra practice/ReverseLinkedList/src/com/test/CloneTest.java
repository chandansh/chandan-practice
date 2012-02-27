package com.test;

import java.util.ArrayList;
import java.util.List;

class Emp implements Cloneable {
	private String firstName;
	private String lastName;
	private int age;

	public Emp() {
	}

	public Emp(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new Emp(this.firstName, this.lastName, this.age);
	}

}

@SuppressWarnings("serial")
class EmpList extends ArrayList<Emp> {

	@Override
	public Object clone() {
		EmpList list2 = new EmpList();
		for (Emp e : this)
			try {
				list2.add((Emp) e.clone());
			} catch (CloneNotSupportedException e1) {
				e1.printStackTrace();
			}
		return list2;

	}

	@Override
	public boolean add(Emp e) {
		return super.add(e);
	}

	public void print() {
		System.out.println("Print Emp List");
		for (Emp e : this) {
			System.out.println(e.getFirstName() + "\t" + e.getLastName() + "\t"
					+ e.getAge());
		}
	}

}

public class CloneTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws CloneNotSupportedException {
		Emp e1 = new Emp("chandan", "sharma", 25);
		Emp e2 = new Emp("raju", "patel", 20);
		Emp e3 = new Emp("rohan", "mishra", 18);
		Emp e4 = new Emp("manoj", "yadav", 27);

		List<Emp> list = new ArrayList<Emp>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);

		List<Emp> list1 = (List<Emp>) ((ArrayList<Emp>) list).clone();
		List<Emp> list2 = new ArrayList<Emp>();
		for (Emp e : list)
			list2.add((Emp) e.clone());

		e1.setFirstName("satish");

		printList(list);

		System.out.println("Print by clone:");
		printList(list1);

		System.out.println("Print by list2:");
		printList(list2);
		
		
		// use with EmpList
		EmpList empList=new EmpList();
		empList.add(e1);
		empList.add(e2);
		empList.add(e3);
		empList.add(e4);
		
		System.out.println("without clone print empList");
		empList.print();
		EmpList empList1=(EmpList) empList.clone();
		empList.get(0).setFirstName("bharta");
		
		System.out.println("after clone and change index 0 value of firt name print empList");
		empList.print();
		
		System.out.println("after clone and change index 0 value of firt name print empList1");
		empList1.print();
	}

	private static void printList(List<Emp> list2) {
		for (Emp e : list2) {
			System.out.println(e.getFirstName() + "\t" + e.getLastName() + "\t"
					+ e.getAge());
		}
	}

}
