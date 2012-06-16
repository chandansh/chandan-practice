package web.spring1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

@Controller
@RequestMapping("VIEW")
public class MainController {
	@RenderMapping
	public String setModelAndView() {
		return "home";
	}
}
