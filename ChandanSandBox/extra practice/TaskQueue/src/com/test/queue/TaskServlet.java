package com.test.queue;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

@SuppressWarnings("serial")
public class TaskServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		String emailid = req.getParameter("emailid");
		Email e=new Email(emailid);
		Objectify ofy = ObjectifyService.begin();
		ofy.put(e);
		PrintWriter out = resp.getWriter();
		out.print("new emailid saved.");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
