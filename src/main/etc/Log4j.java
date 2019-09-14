package main.etc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j {
    private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    public static void main(String[] args) {

        logger.info("test");
        logger.error("error");
        logger.warn("warn");
    }
}
