package mypack;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class HelloWorldUsingProp {

	static final Logger logger = Logger.getLogger(HelloWorldUsingProp.class);

	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");
		logger.debug("Sample debug message");
		logger.info("Sample info message");
		logger.warn("Sample warn message");
		logger.error("Sample error message");
		logger.fatal("Sample fatal message");
	}
}