package com.mypack;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.mypack.model.User;

@SuppressWarnings("deprecation")
public class UserController extends SimpleFormController {
	private UserService userService;

	public UserController() {
		setCommandClass(User.class);
		setCommandName("user");
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	protected ModelAndView onSubmit(Object command) throws Exception {
		User user = (User) command;
		userService.add(user);
		return new ModelAndView("userSuccess", "user", user);
	}
}
