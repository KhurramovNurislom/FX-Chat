package uz.lb.repositories;

import uz.lb.models.Log;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LogRepository {
    private static final String DB_URL = "jdbc:sqlite:logs.db";

    public LogRepository() {
        createTableIfNotExists();
    }

    private void createTableIfNotExists() {
        String sql = """
                  CREATE TABLE logs (
                          id INTEGER PRIMARY KEY AUTOINCREMENT,
                          level TEXT,
                          logger TEXT,
                          message TEXT,
                          exception TEXT,
                          createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                      );
                """;
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(Log log) {
        String sql = "INSERT INTO logs(level, logger, message, exception) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, log.getLevel());
            pstmt.setString(2, log.getLogger());
            pstmt.setString(3, log.getMessage());
            pstmt.setString(4, log.getException());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(); // yoki logga yozing
        }
    }

    public List<Log> getAllLogs() {
        List<Log> logs = new ArrayList<>();
        String sql = "SELECT * FROM logs";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Log log = new Log(
                        rs.getLong("id"),
                        rs.getString("level"),
                        rs.getString("logger"),
                        rs.getString("message"),
                        rs.getString("exception"),
                        rs.getTimestamp("createdAt")
                );
                logs.add(log);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // yoki log faylga yozing
        }

        return logs;
    }

}