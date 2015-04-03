package com.listener;

import java.util.Iterator;
import java.util.List;

import javax.mail.internet.InternetAddress;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

public class LMSBookBusListener implements MessageListener
{

	@Override
	public void receive(Message message) throws MessageListenerException {
		try 
		{
			String book = message.getString("bookName");
			 
			String mailSender = "market.travel1@gmail.com";
			int userCount = (Integer)UserLocalServiceUtil.getUsersCount();
			List<User> userList = UserLocalServiceUtil.getUsers(0,userCount);
			Iterator<User> itr = userList.iterator();
			InternetAddress from = new InternetAddress();
			InternetAddress to = new InternetAddress();
			from.setAddress(mailSender);
			while(itr.hasNext())
			{
				User userObj = itr.next();
				//long userId = userObj.getUserId();
				 
				String destinationEmailID = userObj.getEmailAddress();
				to.setAddress(destinationEmailID);
				 
				String subject = "A new book has been added";
				String body = "A new book -" +book+ "has been added";
				boolean htmlFormat = false;
				if(to.equals(from))
				{
					continue;
				}
				else
				{
					MailMessage mailMessage = new MailMessage(from, to, subject, body, htmlFormat);
					MailServiceUtil.sendEmail(mailMessage);
					System.out.println("Mail Sent");
				}
			}
		}
		
		catch (Exception e) 
		{
			throw new MessageListenerException(e);
		}
	}
}
