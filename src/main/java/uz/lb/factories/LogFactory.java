package uz.lb.factories;

import uz.lb.models.Log;

public class LogFactory {
    private static LogFactory instance;

    public static LogFactory getInstance() {
        if (instance == null) {
            synchronized (LogFactory.class) {
                if (instance == null) {
                    instance = new LogFactory();
                }
            }
        }
        return instance;
    }

    public Log info(String logger, String message) {
        return log("INFO", logger, message, null);
    }

    public Log error(String logger, String message, Exception ex) {
        return log("ERROR", logger, message, ex != null ? ex.toString() : null);
    }

    public Log warn(String logger, String message) {
        return log("WARN", logger, message, null);
    }

    public Log debug(String logger, String message) {
        return log("DEBUG", logger, message, null);
    }

    public Log trace(String logger, String message) {
       return log("TRACE", logger, message, null);
    }


    private Log log(String level, String logger, String message, String exception) {
        return new Log(level, logger, message, exception);
    }
}
