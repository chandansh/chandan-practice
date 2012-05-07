package com.mypack;

import com.mypack.model.User;

public class UserServiceImpl implements UserService {
	
	@Override
	public void add(User user) {
		System.out.println("User added successfully.");
	}
}
