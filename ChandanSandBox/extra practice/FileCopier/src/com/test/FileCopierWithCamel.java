package com.test;


import org.apache.camel.CamelContext;
import org.apache.camel.builder.Builder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class FileCopierWithCamel {

	public static void main(String args[]) throws Exception {

		CamelContext context = new DefaultCamelContext();
		context.addRoutes(new RouteBuilder() {
			public void configure() {
				from("file:Inbox?noop=true").to("file:Outbox");
//				String recipients = "&To=chandan.sharma@mpowerglobal.com";
//				from("direct:a").setBody(Builder.constant("Salut !"))
//				.to("smtps://smtp.gmail.com:465?password=&username=chandansharmamca@gmail.com" + recipients);
			
			}
		});
		context.start();
		Thread.sleep(10000);
		context.stop();
		System.out.println("File copied successfully..");
	}

}
