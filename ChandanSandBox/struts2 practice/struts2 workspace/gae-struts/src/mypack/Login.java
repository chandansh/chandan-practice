package mypack;

public class Login {
	String username;
	String password;

	public String execute() {
		if (username.startsWith("a") && password.startsWith("b")) {
			return "success";
		} else {
			return "failure";
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
