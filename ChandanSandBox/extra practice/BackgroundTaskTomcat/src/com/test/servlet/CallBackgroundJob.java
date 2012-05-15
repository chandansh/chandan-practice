package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Executor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.BackgroundJobProcessor;

@SuppressWarnings("serial")
public class CallBackgroundJob extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Executor executor = (Executor) req.getServletContext().getAttribute(
				"executor");
		// delegate long running process to an "async" thread
		executor.execute(new BackgroundJobProcessor());
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.print("Background Job initiated...");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
