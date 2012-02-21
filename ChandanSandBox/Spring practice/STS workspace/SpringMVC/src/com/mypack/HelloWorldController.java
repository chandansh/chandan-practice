package com.mypack;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloWorldController extends AbstractController {
	private String message;

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1)
			throws Exception {

		return new ModelAndView("welcomePage", "welcomeMessage", message);
	}

}
