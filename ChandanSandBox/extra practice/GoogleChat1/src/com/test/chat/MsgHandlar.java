package com.test.chat;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.channel.ChannelMessage;
import com.google.appengine.api.channel.ChannelPresence;
import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;

@SuppressWarnings("serial")
public class MsgHandlar extends HttpServlet {

	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String msg = req.getParameter("msg");
		String client_id = req.getParameter("client_id");
		ChannelService channelService = ChannelServiceFactory
				.getChannelService();
		// ChannelPresence presence = channelService.parsePresence(req);

		// System.out.println("Presence client Id :"+presence.clientId());

		System.out.println(msg);
		System.out.println(client_id);
		String msgDisp = "";
		Set<String> users = Users.get();
		for (String user : users) {
			if (user.equals(client_id))
				msgDisp = "{\"sender\" : \"me\" , \"msg\" : \"" + msg + "\"}";
			else
				msgDisp = "{\"sender\" : \"" + client_id + "\" , \"msg\" : \""
						+ msg + "\"}";
			ChannelMessage msg1 = new ChannelMessage(user, msgDisp);
			System.out.println(msg1.getClientId());
			System.out.println(msg1.getMessage());
			channelService.sendMessage(msg1);
		}
		//
		// ChannelMessage msg1 = new ChannelMessage(channel_id, msg);
		// System.out.println(msg1.getClientId());
		// System.out.println(msg1.getMessage());
		// channelService.sendMessage(msg1);

		// req.getRequestDispatcher("/chat.jsp").include(req, resp);
	}

}
