package uz.lb.utils;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteUtil {

    private static final String DB_URL = "jdbc:sqlite:data/db_fx_chat.db";

    public static void createDatabaseAndTables() {

        if (!new File("data").isDirectory()) {
            new File("data").mkdirs();
        }

        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            if (conn != null) {
                // Jadval yaratish uchun Statement
                Statement stmt = conn.createStatement();

                // Masalan, "users" jadvalini yaratamiz, agar mavjud bo'lmasa
                String sql = "CREATE TABLE IF NOT EXISTS users (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "username TEXT NOT NULL," +
                        "email TEXT NOT NULL" +
                        ");";

                stmt.execute(sql);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }


}
