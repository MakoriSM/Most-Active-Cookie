package logger;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProgramLogger {

    private static Logger m_logger = Logger.getLogger( Logger.GLOBAL_LOGGER_NAME);

    public void setLogger(Logger logger) {
        m_logger = logger;
    }

    public static Logger getLogger(){
        return m_logger;
    }

    public ProgramLogger() {
        Logger logger = Logger.getLogger( Logger.GLOBAL_LOGGER_NAME);
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.INFO);
        logger.addHandler(ch);
        setLogger(logger);
    }




}
