package com.test;

import javax.naming.NamingException;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.Builder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mail.MailComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.util.jndi.JndiContext;

public class CamelMail {

	public static void main(String[] args) {
		try {
			JndiContext context = new JndiContext();

			MailComponent mail = new MailComponent();
			
			context.bind("mail", mail);

			CamelContext camelContext = new DefaultCamelContext(context);

			camelContext.addRoutes(new RouteBuilder() {

				public void configure() {
//					from(
//							"timer:myTimerEvent?fixedRate=true&delay=0&period=1000")
//							.setBody(Builder.constant("Salut !")).to(
//									"mail://chandansharmamca@gmail.com?password=adityaranjanbha#chandan.sharma@mpowerglobal.com");
					String recipients = "&To=chandan.sharma@mpowerglobal.com";

					from("direct:a").to("smtps://chandansharmamca@gmail.com?password=adityaranjanbha&From=chandansharmamca@gmail.com" + recipients);
				}

			});
			camelContext.start();
			System.out.println("sent..");
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
