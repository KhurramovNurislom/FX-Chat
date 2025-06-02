//package uz.lb.viewModels;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import uz.lb.models.Log;
//
//public class LogViewModel {
//    private final ObservableList<Log> logs = FXCollections.observableArrayList();
//
//    public ObservableList<Log> getLogs() {
//        return logs;
//    }
//
//    public void loadLogs() {
//        logs.setAll(LogRepository.getAllLogs());
//    }
//
//    public void addLog(Log log) {
//        LogRepository.save(log);
//        logs.add(log);
//    }
//
//    // Update, delete, etc.
//}
