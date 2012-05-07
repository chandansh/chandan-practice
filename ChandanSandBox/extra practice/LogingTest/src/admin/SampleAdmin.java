package admin;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import report.SampleReport;

public class SampleAdmin {

	static Logger logger = Logger.getLogger(SampleAdmin.class);

	public static void main(String[] args) {
		PropertyConfigurator.configure("diffModuleAppender.properties");
		logger.debug("Sample debug message");
		logger.info("Sample info message");
		logger.warn("Sample warn message");
		logger.error("Sample error message");
		logger.fatal("Sample fatal message");
		SampleReport obj = new SampleReport();
		obj.generateReport();
	}

}