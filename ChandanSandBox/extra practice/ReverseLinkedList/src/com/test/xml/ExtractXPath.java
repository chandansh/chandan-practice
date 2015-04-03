package com.test.xml;

import java.io.FileInputStream;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

public class ExtractXPath {

	public static void main(String[] args) throws Exception {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser sp = spf.newSAXParser();
		XMLReader xr = sp.getXMLReader();

		FragmentContentHandler handler = new FragmentContentHandler(xr);
		xr.setContentHandler(handler);
		xr.parse(new InputSource(
				new FileInputStream("src/com/test/xml/Iaas-Intel-Multi-Data-Center.xml")));
		List<String> pathList = handler.getPathList();

		//System.out.println(pathList.size());
		for (String path : pathList) {
			System.out.println(path);
		}

	}
}
