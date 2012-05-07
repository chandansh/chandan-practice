package de.vogella.gwt.helloserver.client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.vogella.gwt.module.client.MyUser;



public interface MyUserServiceAsync {

	void getUser(String id, AsyncCallback<MyUser> callback);

	void getUserList(AsyncCallback<List<MyUser>> callback);

}
