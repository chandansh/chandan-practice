package com.xml.test;

import java.io.*;
import org.w3c.dom.*;

import javax.xml.parsers.*;

public class GetNodeValue {

	public static String getCharacterDataFromElement(Element e) {
		Node child = e.getFirstChild();
		if (child instanceof CharacterData) {
			CharacterData cd = (CharacterData) child;
			return cd.getData();
		}
		return "";
	}

	public static String stripCDATA(String s) {
		s = s.trim();
		if (s.startsWith("<![CDATA[")) {
			s = s.substring(9);
			int i = s.indexOf("]]&gt;");
			if (i == -1) {
				throw new IllegalStateException(
						"argument starts with <![CDATA[ but cannot find pairing ]]&gt;");
			}
			s = s.substring(0, i);
		}
		return s;
	}

	public static void main(String[] args) throws Exception {
		File file = new File("C:/mcq0-50.xml");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setCoalescing(true);
		System.out.println("Is coalescing: " + dbf.isCoalescing());
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(file);
		GettingText1(doc);
	}

	public static void GettingText(Document doc) {
		Element e = doc.getDocumentElement();
		NodeList nodeList = doc.getElementsByTagName("MCQ");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				NodeList nodelist = element.getElementsByTagName("id");
				Element element1 = (Element) nodelist.item(0);
				NodeList fstNm = element1.getChildNodes();
				System.out.print("id : " + (fstNm.item(0)).getNodeValue());
			}
		}
	}

	public static void GettingText1(Document doc) {
		Element e = doc.getDocumentElement();
		NodeList nodeList = doc.getElementsByTagName("MCQ");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				NodeList nodelist = element.getElementsByTagName("id");
				Element element1 = (Element) nodelist.item(0);
				// System.out.println("id : "+getCharacterDataFromElement(element1));
				System.out.println(element1.getNodeName() + ": '"
						+ /*stripCDATA*/(element1.getChildNodes().item(0).getNodeValue().trim()) + "'");

				NodeList nodelist1 = element.getElementsByTagName("question");
				Element element2 = (Element) nodelist1.item(0);
				// System.out.println("id : "+getCharacterDataFromElement(element1));
				System.out.println(element2.getNodeName() + " : "
						+ /*stripCDATA*/(element2.getChildNodes().item(0).getNodeValue().trim()));
				System.out.println();
			}
		}
	}
}