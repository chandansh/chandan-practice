package com.mypack.test;

import java.util.List;

public interface UserDao {

	public abstract List<User> listUser();

	public abstract void saveOrUpdateUser(User user);

	User listUserById(Long userId);

	void deleteUser(Long userId);

}