package web.spring1.controllers;

import java.util.Map;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;

import org.springframework.web.portlet.mvc.SimpleFormController;

import web.test.model.GuessNumberData;

@SuppressWarnings("deprecation")
public class SimpleGuessNumberController extends SimpleFormController {

	@Override
	public void doSubmitAction(Object command) {
		GuessNumberData data = (GuessNumberData) command;
		// Do something with the command object, e.g., save to database
		System.out.println("do submit action calling ....");
		System.out.println("your answer:" + data.getAnswer());
	}

	@Override
	protected Object formBackingObject(PortletRequest request) throws Exception {
		System.out.println("formBackingObject calling ....");
		GuessNumberData data = new GuessNumberData();

		Map<?, ?> userInfo = (Map<?, ?>) request
				.getAttribute(PortletRequest.USER_INFO);
		String username = "";
		if (userInfo != null) {
			username = (String) userInfo.get("username");
		}

		PortletPreferences prefs = request.getPreferences();
		String minimum = prefs.getValue("minimum", "0");
		String maximum = prefs.getValue("maximum", "10");

		data.startGame(username, minimum, maximum);

		return data;
	}
}
