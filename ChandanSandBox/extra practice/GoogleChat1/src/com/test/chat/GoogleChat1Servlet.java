package com.test.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;

@SuppressWarnings("serial")
public class GoogleChat1Servlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String userId = req.getParameter("name");

		ChannelService channelService = ChannelServiceFactory
				.getChannelService();

		Set<String> users = Users.get();
		if (userId != null && !userId.equals("") && !users.contains(userId)) {
			users.add(userId);
			String token = channelService.createChannel(userId);

			resp.setContentType("text/html");
			req.setAttribute("token", token);
			req.setAttribute("name", userId);

			if (userId.equals("admin"))
				req.getRequestDispatcher("/adminchat.jsp").include(req, resp);
			else
				req.getRequestDispatcher("/chat.jsp").include(req, resp);

			// resp.getWriter().write(token);
		} else {
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.print("try with another user id<br>");
			req.getRequestDispatcher("/index.html").include(req, resp);
		}

	}
}
