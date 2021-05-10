package RetailProduct;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class gnLogger extends getResultSet {

	private Logger logger;

	public void loggerInfoEntry(String className, String myMessage) {
		vname = ApplicationDrivename + "AKN\\";
		DOMConfigurator.configure(vname + "//LogFile//Log4j.xml");
		// Class myclass = (Class)className ;
		// logger = Logger.getLogger(className.class);
		logger = Logger.getLogger(className);
		logger.info(myMessage);
	}

	public void loggerDebugEntry(String className, String myMessage) {
		vname = ApplicationDrivename + "AKN\\LogFile";
		DOMConfigurator.configure(vname + "//Log4j.xml");
		logger = Logger.getLogger(className);
		logger.debug(myMessage);
	}

}
