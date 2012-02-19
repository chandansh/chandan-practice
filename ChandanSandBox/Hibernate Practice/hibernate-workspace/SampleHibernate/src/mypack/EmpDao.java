package mypack;

import mypack.factory.MySessionFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmpDao {
	public Emp getEmp(int id) {
		Emp e = null;
		Session s = MySessionFactory.getSession();
		e = (Emp) s.get(Emp.class, id);
		s.close();
		return e;
	}

	public void update(Emp e) {
		Session s = MySessionFactory.getSession();
		Transaction t = s.beginTransaction();
		s.merge(e);
		t.commit();
		s.close();

	}

	public void delete(int id) {
		Session s = MySessionFactory.getSession();
		Emp e = (Emp) s.load(Emp.class, id);
		Transaction t = s.beginTransaction();
		s.delete(e);
		t.commit();
		s.close();
	}
}
