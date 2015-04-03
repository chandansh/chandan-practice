package com.mypack.test.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.validator.Valid;

import com.mypack.test.User;
import com.mypack.test.UserDao;
import com.mypack.test.UserDaoImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport implements ModelDriven<User> {

	@Valid
	private User user = new User();
	private List<User> userList = new ArrayList<User>();
	private UserDao userDAO = new UserDaoImpl();

	@Override
	public User getModel() {
		return user;
	}

	public String add() {
		userDAO.saveOrUpdateUser(user);
		return SUCCESS;
	}

	public String list() {
		userList = userDAO.listUser();
		return SUCCESS;
	}

	public String delete() {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		userDAO.deleteUser(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}

	/**
	 * To list a single user by Id.
	 * 
	 * @return String
	 */
	public String edit() {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		user = userDAO.listUserById(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
}
