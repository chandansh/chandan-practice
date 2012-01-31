package com.test.chat;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.channel.ChannelMessage;
import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;

@SuppressWarnings("serial")
public class MsgHandlar1 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String msg = req.getParameter("msg");
		String client_id = req.getParameter("sender");
		ChannelService channelService = ChannelServiceFactory
				.getChannelService();
		// ChannelPresence presence = channelService.parsePresence(req);

		// System.out.println("Presence client Id :"+presence.clientId());

		System.out.println(msg);
		System.out.println(client_id);
		String msgDisp = "";
		ChannelMessage msg1 = null;

		if (!client_id.equals("admin")) {
			msgDisp = "{\"sender\" : \"" + client_id + "\" , \"msg\" : \""
					+ msg + "\"}";
			msg1 = new ChannelMessage("admin", msgDisp);
			channelService.sendMessage(msg1);

			msgDisp = "{\"sender\" : \"me\" , \"msg\" : \"" + msg + "\"}";
			msg1 = new ChannelMessage(client_id, msgDisp);
			channelService.sendMessage(msg1);
		} else {
			String sendTo = req.getParameter("send_to");
			msgDisp = "{\"sender\" : \"admin\" , \"msg\" : \"" + msg + "\"}";
			msg1 = new ChannelMessage(sendTo, msgDisp);
			channelService.sendMessage(msg1);

			msgDisp = "{\"sender\" : \"me\" , \"msg\" : \"" + msg
					+ "\" ,\"sendTo\" : \"" + sendTo + "\"}";
			// System.out.println(msgDisp);
			msg1 = new ChannelMessage("admin", msgDisp);
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
