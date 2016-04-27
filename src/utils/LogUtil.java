package utils;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.ErrorHandler;
import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;


public class LogUtil {
	private static Logger logger = Logger.getLogger(LogUtil.class.getName());

	public static void startTestCase(String className,String testCaseID){
		logger.info("                                                                                                                             ");
		logger.info("=============================================================================================================================");
		logger.info("Starting execution of test case: "+ testCaseID + " of Class: "+ className);
		logger.info("=============================================================================================================================");
	}
	
	public static void endTestCase() {
        logger.info("==================================  ******** END OF TEST CASE ********  =====================================================");
    }
	
	public static void errorMessageWithStackTrace(String message, Throwable throwable) {
        logger.error("ERROR EXECUTING TEST");
        logger.error("=========================================TEST CASE FAILED===================================================================");
        logger.error(message, throwable);
    }
	
	public static void info(String message) {
        logger.info(message);
    }

    public static void warn(String message) {
        logger.warn(message);
    }

    public static void error(String message) {
        logger.error(message);
    }
    
    public static void fatal(String message) {
        logger.fatal(message);
    }

    public static void debug(String message) {
        logger.debug(message);
    }   

}
