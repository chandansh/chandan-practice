package com.springinaction.test.app;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.springinaction.test.Knight;

public class KnightApp {

	/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		//BasicConfigurator.configure();
		PropertyConfigurator.configure("log4j.properties");
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("knight.xml"));
		Knight knightTable = (Knight) factory.getBean("knight");
		//System.out.println(knightTable.getName());
		knightTable.embarkOnQuest();
	}

}
