package com.test.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class abc {
	public static void main(String[] args) throws SAXException, IOException,
			ParserConfigurationException {
		// URL schemaFile = new URL(
		// "http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd");
		// Source xmlFile = new StreamSource(new File("web.xml"));
		// SchemaFactory schemaFactory = SchemaFactory
		// .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		// Schema schema = schemaFactory.newSchema(schemaFile);
		// Validator validator = schema.newValidator();
		// try {
		// validator.validate(xmlFile);
		// System.out.println(xmlFile.getSystemId() + " is valid");
		// } catch (SAXException e) {
		// System.out.println(xmlFile.getSystemId() + " is NOT valid");
		// System.out.println("Reason: " + e.getLocalizedMessage());
		// }

		File xml = new File("src/com/test/xml/MDM.xml");
		File xsd = new File("src/com/test/xml/recipe.xsd"); // XSD as File

		// SchemaFactory sf =
		// SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		// Schema schema = sf.newSchema(xsd);
		//
		// SAXParserFactory spf = SAXParserFactory.newInstance();
		// spf.setSchema(schema);
		// SAXParser sp = spf.newSAXParser();
		// XMLReader xr = sp.getXMLReader();
		// xr.parse(new InputSource(new FileInputStream(xml)));

		System.out.println(validate(xml, xsd));
	}

	public static boolean validate(File xmlFile, File schemaFile)
			throws SAXException, IOException {
		// build the schema
		SchemaFactory factory = SchemaFactory
				.newInstance("http://www.w3.org/2001/XMLSchema");
		// File schemaFile = new File(schemaLocation);
		Schema schema = factory.newSchema(schemaFile);
		Validator validator = schema.newValidator();

		// create a source from a string
		Source source = new StreamSource(xmlFile);

		// check input
		boolean isValid = true;
		try {
			validator.validate(source);
		} catch (SAXException e) {
			System.err.print("Not valid");
			isValid = false;
		}

		return isValid;
	}
}
