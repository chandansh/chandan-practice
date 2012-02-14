package mypack;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LinkAction extends ActionSupport {
	public String welcome() {
		return "welcome";
	}

	public String friends() {
		return "friends";
	}

	public String office() {
		return "office";
	}
}
