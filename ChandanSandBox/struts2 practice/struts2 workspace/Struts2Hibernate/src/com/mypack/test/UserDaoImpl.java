package com.mypack.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public class UserDaoImpl implements UserDao {

	@SessionTarget
	Session session;

	@TransactionTarget
	Transaction transaction;

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUser() {
		List<User> courses = null;
		try {
			courses = session.createQuery("from User").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courses;
	}

	@Override
	public void saveOrUpdateUser(User user) {
		try {
			session.saveOrUpdate(user);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	/**
	 * Used to delete a user.
	 */
	@Override
	public void deleteUser(Long userId) {
		try {
			User user = (User) session.get(User.class, userId);
			session.delete(user);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	/**
	 * Used to list a single user by Id.
	 */
	@Override
	public User listUserById(Long userId) {
		User user = null;
		try {
			user = (User) session.get(User.class, userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}