package uz.lb.services.implement;

import uz.lb.factories.LogFactory;
import uz.lb.models.Log;
import uz.lb.repositories.LogRepository;

public class LogService {
    private static LogService instance;
    private final LogRepository logRepository;
    private final LogFactory factory;
    private LogService() {
        this.logRepository = new LogRepository();
        this.factory = LogFactory.getInstance();
    }
    public static synchronized LogService getInstance() {
        if (instance == null) {
            instance = new LogService();
        }
        return instance;
    }
    public void info(String message) {
        Log log = factory.info("logger", message);
        save(log);
    }
    public void error(String message, Exception e) {
        Log log = factory.error("logger", message, e);
        save(log);
    }
    public void debug(String message, Exception e) {
        Log log = factory.error("logger", message, e);
        save(log);
    }
    public void trace(String message, Exception e) {
        Log log = factory.error("logger", message, e);
        save(log);
    }
    public void warn(String message, Exception e) {
        Log log = factory.error("logger", message, e);
        save(log);
    }
    public void getAll(){
        logRepository.getAllLogs();
    }
    private void save(Log log){
        logRepository.save(log);
    }
}
