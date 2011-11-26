package mypack;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class MultipleAppenderLog4jXml {
	static final Logger logger = Logger.getLogger(MultipleAppenderLog4jXml.class);

	public static void main(String[] args) {
		DOMConfigurator.configure("MultipleAppenderLog4j.xml");
		logger.debug("Sample debug message");
		logger.info("Sample info message");
		logger.warn("Sample warn message");
		logger.error("Sample error message");
		logger.fatal("Sample fatal message");
	}
}
