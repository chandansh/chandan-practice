package de.vogella.gwt.helloserver.server;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.vogella.gwt.helloserver.client.service.MyUserService;
import de.vogella.gwt.module.client.MyUser;

public class MyUserServiceImpl extends RemoteServiceServlet implements
		MyUserService {

	private static final long serialVersionUID = 1L;

	private List<MyUser> userList = new ArrayList<MyUser>();

	public MyUserServiceImpl() {
		MyUser user = new MyUser();
		user.setId("1");
		user.setUsername("chandan");
		user.setNumberOfHits("15");
		userList.add(user);

		user = new MyUser();
		user.setId("2");
		user.setUsername("sonata");
		user.setNumberOfHits("25");
		userList.add(user);
		
		user = new MyUser();
		user.setId("3");
		user.setUsername("chotu");
		user.setNumberOfHits("50");
		userList.add(user);
		
		user = new MyUser();
		user.setId("4");
		user.setUsername("pankaj");
		user.setNumberOfHits("5");
		userList.add(user);
		
		user = new MyUser();
		user.setId("5");
		user.setUsername("dharmu");
		user.setNumberOfHits("15");
		userList.add(user);
	}

	public MyUser getUser(String id) {

		for (MyUser item : userList) {
			if ((item.getId().equals(id)))
				return (item);
		}
		return null;
	}

	public List<MyUser> getUserList() {
		return userList;
	}
}