package com.test;


import java.io.File;

import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.SAXReaderUtil;

public class xmlTest {
	public static void main(String[] args) {
		try {
			File file = new File("/home/mpower/Desktop/extra/Iaas-Intel-Multi-Data-Center.xml");
			System.out.println(file.length());
			Document doc = SAXReaderUtil.read(file);
			System.out.println(doc.asXML());
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
	}
}
