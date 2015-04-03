package com.test.app;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.test.HelloWorld;

public class FirstApp {
	
	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("myresource.xml"));
		HelloWorld hello = (HelloWorld) factory.getBean("hello");
		System.out.println(hello.sayHello());
	}

}
