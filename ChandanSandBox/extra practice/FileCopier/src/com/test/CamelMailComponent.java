package com.test;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.Builder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mail.MailComponent;
import org.apache.camel.component.mail.MailEndpoint;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelMailComponent {

	
	public static void main(String[] args) throws Exception {
		  CamelContext camelContext = new DefaultCamelContext(); 
          
          //MailComponent mail = new MailComponent(); 
          
          //camelContext.addComponent("mail", mail); 
          
         // final MailEndpoint ep = (MailEndpoint) camelContext.getEndpoint("mail://chandansharmamca@gmail.com?password=#chandan.sharma@mpowerglobal.com"); 
         // ep.getConfiguration().setProtocol("smtps"); 
         // ep.getConfiguration().setDestination("chandan.sharma@mpowerglobal.com"); 
          
          
          camelContext.addRoutes(new RouteBuilder() { 

              public void configure() { 
                 // from("timer:myTimerEvent?fixedRate=true&delay=0&period=1000") 
                 // .setBody(Builder.constant("Salut !")).to(ep);
            	  from("timer:myTimerEvent?fixedRate=true&delay=0&period=1000") 
                  .to("smtps://smtp.gmail.com?username=chandansharmamca&password=&to=chandan.sharma@mpowerglobal.com&contentType=text/plain");	
              } 
              
          }); 
          
          camelContext.start(); 
          System.out.println("sent..");
	}
}
