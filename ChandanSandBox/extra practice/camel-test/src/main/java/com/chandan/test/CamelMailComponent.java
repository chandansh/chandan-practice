package com.chandan.test;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.Builder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mail.MailComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.util.jndi.JndiContext;

public class CamelMailComponent {

	
	public static void main(String[] args) throws Exception {
		 // CamelContext camelContext = new DefaultCamelContext(); 
          
//          MailComponent mail = new MailComponent(); 
//          camelContext.addComponent("mail", mail); 
//          
//          final MailEndpoint ep = (MailEndpoint) camelContext.getEndpoint("mail://cksjavaj2ee@gmail.com?password=#"); 
//          ep.getConfiguration().setProtocol("smtps"); 
//          //ep.getConfiguration().setDestination("chandan.sharma@mpowerglobal.com"); 
//          
//          camelContext.addRoutes(new RouteBuilder() { 
//
//              public void configure() { 
//                  from("timer:myTimerEvent?fixedRate=true&delay=0&period=1000") 
//                  .setBody(Builder.constant("Salut !")).to(ep);	         
//              } 
//              
//          }); 
		  
		  JndiContext context = new JndiContext(); 

          MailComponent mail = new MailComponent(); 
         
          context.bind("smtps", mail); 

          CamelContext camelContext = new DefaultCamelContext(context); 
          mail.setCamelContext(camelContext);
          
          camelContext.addRoutes(new RouteBuilder() { 

           public void configure() { 
             from("timer:myTimerEvent?fixedRate=true&delay=0&period=1000") 
             .setBody(Builder.constant("Salut !")).to("smtps://cksjavaj2ee@gmail.com?password=#chandan.sharma@mpowerglobal.com"); 
           } 
           
           

          }); 
          
          camelContext.start(); 
          System.out.println("sent..");
          
          
	}
}
