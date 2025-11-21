package uz.lb.models;

import java.io.Serializable;
import java.sql.Timestamp;

public class Log implements Serializable {


    public Log() {}
    public Log(String level, String logger, String message, String exception) {
        this.level = level;
        this.logger = logger;
        this.message = message;
        this.exception = exception;
    }
    public Log(Long id, String level, String logger, String message, String exception, Timestamp createdAt) {
        this.id = id;
        this.level = level;
        this.logger = logger;
        this.message = message;
        this.exception = exception;
        this.createdAt = createdAt;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLogger() {
        return logger;
    }

    public void setLogger(String logger) {
        this.logger = logger;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", level='" + level + '\'' +
                ", logger='" + logger + '\'' +
                ", message='" + message + '\'' +
                ", exception='" + exception + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    private Long id;
    private String level;
    private String logger;
    private String message;
    private String exception;
    private Timestamp createdAt;


}
