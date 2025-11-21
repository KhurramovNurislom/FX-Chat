package uz.lb.db;

import uz.lb.models.Contact;
import uz.lb.models.CountryPhoneNumberForm;
import uz.lb.models.User;

import java.io.File;
import java.sql.*;
import java.util.Map;
import java.util.Set;

public class SQLiteConnection {
    private static final String DB_FOLDER = "data";
    private static final String DB_FILE = "db_fx_chat.db";
    private static final String DB_URL = "jdbc:sqlite:" + DB_FOLDER + "/" + DB_FILE;
    private static final SQLiteConnection INSTANCE = new SQLiteConnection();
    private boolean initialized = false;

    private SQLiteConnection() {
    }
    public static SQLiteConnection getInstance() {
        return INSTANCE;
    }

    // --- public API --- //
    public synchronized void initialize() {
        if (initialized) return;

        createDatabaseFolder();
        createDatabaseFile();

        createOrUpdateTable("country_phone_number_forms",
                ModelTableMapper.columnsFromModel(CountryPhoneNumberForm.class));
        createOrUpdateTable("users",
                ModelTableMapper.columnsFromModel(User.class));
        createOrUpdateTable("contacts",
                ModelTableMapper.columnsFromModel(Contact.class));

        initialized = true;
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            System.err.println("Data bazaga ulanishda xatolik...");
        }
        return null;
    }


    // --- private helperlar (endi static emas) --- //

    private void createDatabaseFolder() {
        File folder = new File(DB_FOLDER);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    private void createDatabaseFile() {
        File dbFile = new File(DB_FOLDER + "/" + DB_FILE);
        if (!dbFile.exists()) {
            try {
                dbFile.createNewFile();
            } catch (Exception e) {
                throw new RuntimeException("DB faylini yaratib bo‘lmadi: " + e.getMessage());
            }
        }
    }

    private void createOrUpdateTable(String tableName, Map<String, String> columns) {
        try (Connection conn = getConnection()) {

            if (!tableExists(conn, tableName)) {
                createTable(conn, tableName, columns);
                return;
            }

            Set<String> existingCols = getExistingColumns(conn, tableName);

            for (var entry : columns.entrySet()) {
                String colName = entry.getKey();
                String colType = entry.getValue();

                if (!existingCols.contains(colName)) {
                    addMissingColumn(conn, tableName, colName, colType);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Table create/update xatosi: " + tableName, e);
        }
    }

    private boolean tableExists(Connection conn, String tableName) {
        String sql = "SELECT name FROM sqlite_master WHERE type='table' AND name = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tableName);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            System.err.println("tableExists -> " + "muommo");
        }
        return false;
    }

    private Set<String> getExistingColumns(Connection conn, String tableName) {
        Set<String> cols = new java.util.HashSet<>();
        String sql = "PRAGMA table_info(" + tableName + ")";
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                cols.add(rs.getString("name"));
            }
            return cols;
        } catch (SQLException e) {
            System.err.println("getExistingColumns -> " + "muommo");
        }
        return null;
    }

    private void addMissingColumn(Connection conn, String tableName, String columnName, String columnType) {
        String sql = "ALTER TABLE " + tableName + " ADD COLUMN " + columnName + " " + columnType;

        try (Statement st = conn.createStatement()) {
            st.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("COLUMN ADDED: " + tableName + "." + columnName + " (" + columnType + ")");
    }

    private void createTable(Connection conn, String tableName, Map<String, String> columns) {
        StringBuilder sb = new StringBuilder("CREATE TABLE ");
        sb.append(tableName).append(" (");

        boolean first = true;
        for (var entry : columns.entrySet()) {
            if (!first) sb.append(", ");
            sb.append(entry.getKey()).append(" ").append(entry.getValue());
            first = false;
        }
        sb.append(");");

        try (Statement st = conn.createStatement()) {
            st.execute(sb.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("TABLE CREATED: " + tableName);
    }

}

