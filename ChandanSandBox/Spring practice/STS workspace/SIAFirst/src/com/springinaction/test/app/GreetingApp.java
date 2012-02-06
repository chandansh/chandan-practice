package com.springinaction.test.app;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import com.springinaction.test.GreetingService;

public class GreetingApp {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		// BeanFactory factory = new XmlBeanFactory(new FileSystemResource("hello.xml"));

		// for loading bean definition file from classpath resource the xml file should be in src folder
		// for loading bean definition file forom FileSystemResource the xml file should be in your project folder

		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("hello.xml"));
		GreetingService greetingService = (GreetingService) factory.getBean("greetingService");
		greetingService.sayGreeting();

	}
}