package com.xml.test;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

public class AccessingXmlFile {

	public static String getCharacterDataFromElement(Element e) {
		Node child = e.getFirstChild();
		if (child instanceof CharacterData) {
			CharacterData cd = (CharacterData) child;
			return cd.getData();
		}
		return "";
	}

	public static void main(String argv[]) {

		try {
			File file = new File("C:/mcq0-50.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setCoalescing(true);
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse("http://db.incoleg-qa.appspot.com/db/export/3/0/50");
			doc.getDocumentElement().normalize();
			System.out.println("Root element "
					+ doc.getDocumentElement().getNodeName());

			NodeList list = doc.getElementsByTagName("*");
			System.out.println("XML Elements: ");
//			for (int i = 0; i < list.getLength(); i++) {
//				// Get element
//				Node item = list.item(i);
//				Element element = (Element) item;
//				System.out.println(element.getNodeName());
//			}
			
			for (int i = 0; i < list.getLength(); i++) {
				// Get element
				Node item = list.item(i);
				if (item.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) item;
					//NodeList nodelist = element.getElementsByTagName("id");
					//Element element1 = (Element) nodelist.item(0);
					//NodeList fstNm = element1.getChildNodes();
					//Element el=(Element)fstNm.item(0);
					//System.out.println("id : "+getCharacterDataFromElement(element1));
					//System.out.println(element.getNodeName()+" : "+stripCDATA(element.getTextContent()));
					System.out.println(element.getNodeName()+" : "+element.getChildNodes().item(0).getNodeValue().trim());
					
					//System.out.print("id : "+ (fstNm.item(0)).getNodeValue());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}