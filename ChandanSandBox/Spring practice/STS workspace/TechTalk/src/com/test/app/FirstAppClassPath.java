package com.test.app;

import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import com.test.HelloWorld;
import com.test.HelloWorldImpl;
import com.test.TestBean;

public class FirstAppClassPath {
	
	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("myresource_classpath.xml"));
		HelloWorldImpl hello = (HelloWorldImpl) factory.getBean("hello");
		System.out.println(hello.sayHello());
		TestBean testBean = hello.getTestBean();
		System.out.println("Test Bean :: " + testBean );
		List<String> names = hello.getNames();
		for(String name : names){
			System.out.println("name :: " + name);
		}
		
	}

}
