package com.edujini.ws.test;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jersey.spi.container.servlet.ServletContainer;

@SuppressWarnings("serial")
public class MyServletContainer extends ServletContainer {

	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp,
			FilterChain chain) throws IOException, ServletException {

		System.out.println("doFilter.... => called");
		super.doFilter(req, resp, chain);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("filter::doGet.... => called");
		super.doGet(req, resp);
	}

}
