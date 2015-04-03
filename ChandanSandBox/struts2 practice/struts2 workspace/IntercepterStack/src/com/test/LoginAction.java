package com.test;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport {

	String userName;
	String password;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public String execute() {
		String result = "";
		if (userName.startsWith("E") && password.startsWith("b"))
			result = SUCCESS;
		else{
			addFieldError("userName", "User Name or password invalid");
			result = "relogin";
		}
		return result;

	}

//	@Override
//	public void validate() {
//		if (getUserName().length() == 0) {
//			addFieldError("userName", "User Name is required");
//		} else if (!getUserName().equals("Eswar")) {
//			addFieldError("userName", "Invalid User");
//		}
//		if (getPassword().length() == 0) {
//			addFieldError("password", getText("password.required"));
//		}
//	}
}
