package com.test.chat;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {

	String i = "10";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		String param=req.getParameter("param");
		System.out.println("value of i=" + i);
		out.println("value of i=" + i);
		i=param;
		out.println("after changing value of i=" + i);
		getServletContext();
		
	}

}