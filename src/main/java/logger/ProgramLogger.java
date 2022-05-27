package logger;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import static logger.ProgramLogger.setLogger;

public class ProgramLogger {

    private static Logger LOGGER = Logger.getLogger( Logger.GLOBAL_LOGGER_NAME);

    public static void setLogger(Logger logger) {
        LOGGER = logger;
    }

    public static Logger getLogger(){
        return LOGGER;
    }

    public static void setProgramLogger() {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        logger.setLevel(Level.SEVERE);
        setLogger(logger);
    }




}
