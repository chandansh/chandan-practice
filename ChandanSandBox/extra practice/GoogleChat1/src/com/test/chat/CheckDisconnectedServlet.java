package com.test.chat;

import java.io.IOException;
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
public class CheckDisconnectedServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// In the handler for _ah/channel/disconnected/
		ChannelService channelService = ChannelServiceFactory
				.getChannelService();
		ChannelPresence presence = channelService.parsePresence(req);
		String clientId = presence.clientId();
		System.out.println("Disconnected client : " + clientId + " >> "
				+ presence.isConnected());
		Users.get().remove(clientId);

		String msg = clientId + " left the chat.";
		msg = "{\"sender\" : \"\" , \"msg\" : \"" + msg + "\"}";
		ChannelMessage msg1 = new ChannelMessage("admin", msg);
		channelService.sendMessage(msg1);

		// Set<String> users = Users.get();
		// for (String user : users) {
		// ChannelMessage msg1 = new ChannelMessage(user, msg);
		// channelService.sendMessage(msg1);
		// }

	}

}
