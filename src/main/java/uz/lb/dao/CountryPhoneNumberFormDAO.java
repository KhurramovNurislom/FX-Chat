package uz.lb.dao;

import uz.lb.db.SQLiteConnection;
import uz.lb.models.CountryPhoneNumberForm;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryPhoneNumberFormDAO {

    private static final String TABLE_NAME = "country_phone_number_forms";

    public static long insert(CountryPhoneNumberForm model) {

        String sql = "INSERT INTO " + TABLE_NAME +
                " (country, countryISO, dialCode, mask) VALUES (?, ?, ?, ?)";

        Connection conn = SQLiteConnection.getInstance().getConnection();
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, model.getCountry());
            ps.setString(2, model.getCountryISO());
            ps.setString(3, model.getDialCode());
            ps.setString(4, model.getMask());

            int affected = ps.executeUpdate();
            if (affected == 0) {
                throw new SQLException("Insert qilib bo‘lmadi, 0 ta qator ta'sirlandi");
            }

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    long id = rs.getLong(1);
                    model.setId((int) id);  // endi model ichida id bo‘ladi
                    return id;
                } else {
                    throw new SQLException("Insert bo‘ldi, lekin id qaytmadi");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("CountryPhoneNumberForm INSERT xatosi: " + e.getMessage(), e);
        }
    }

    public static CountryPhoneNumberForm findById(int id) {
        String sql = "SELECT id, country, countryISO, dialCode, mask FROM " + TABLE_NAME + " WHERE id = ?";


        Connection conn = SQLiteConnection.getInstance().getConnection();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                }
            }

            return null;
        } catch (SQLException e) {
            throw new RuntimeException("CountryPhoneNumberForm SELECT by id xatosi: " + e.getMessage(), e);
        }
    }

    public static CountryPhoneNumberForm findByCountryIso(String isoCode) {
        String sql = "SELECT id, country, countryISO, dialCode, mask FROM " + TABLE_NAME +
                " WHERE countryISO = ?";


        Connection conn = SQLiteConnection.getInstance().getConnection();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, isoCode);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                }
            }

            return null;
        } catch (SQLException e) {
            throw new RuntimeException("CountryPhoneNumberForm SELECT by ISO xatosi: " + e.getMessage(), e);
        }
    }


    public static List<CountryPhoneNumberForm> findAll() {
        String sql = "SELECT id, country, countryISO, dialCode, mask FROM " + TABLE_NAME + " ORDER BY country";

        List<CountryPhoneNumberForm> list = new ArrayList<>();

        Connection conn = SQLiteConnection.getInstance().getConnection();
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(mapRow(rs));
            }

            return list;
        } catch (SQLException e) {
            throw new RuntimeException("CountryPhoneNumberForm SELECT ALL xatosi: " + e.getMessage(), e);
        }
    }


    public static boolean update(CountryPhoneNumberForm model) {
        if (model.getId() == null) {
            throw new IllegalArgumentException("Update uchun id bo‘lishi shart");
        }

        String sql = "UPDATE " + TABLE_NAME +
                " SET country = ?, countryISO = ?, dialCode = ?, mask = ? WHERE id = ?";


        Connection conn = SQLiteConnection.getInstance().getConnection();
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, model.getCountry());
            ps.setString(2, model.getCountryISO());
            ps.setString(3, model.getDialCode());
            ps.setString(4, model.getMask());
            ps.setInt(5, model.getId());

            int affected = ps.executeUpdate();
            return affected == 1;
        } catch (SQLException e) {
            throw new RuntimeException("CountryPhoneNumberForm UPDATE xatosi: " + e.getMessage(), e);
        }
    }

    // ===================== DELETE =====================

    /**
     * id bo'yicha yozuvni o'chirish
     */
    public boolean deleteById(int id) {
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";

        Connection conn = SQLiteConnection.getInstance().getConnection();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int affected = ps.executeUpdate();
            return affected == 1;
        } catch (SQLException e) {
            throw new RuntimeException("CountryPhoneNumberForm DELETE xatosi: " + e.getMessage(), e);
        }
    }

    // ===================== UP-SERT YORDAMCHI =====================

    /**
     * Agar id null bo'lsa → INSERT
     * Agar id bor bo'lsa → UPDATE
     */
    public static void save(CountryPhoneNumberForm model) {
        if (model.getId() == null) {
            insert(model);
        } else {
            update(model);
        }
    }

    // ===================== QATORNI MODELLASH =====================

    /**
     * ResultSet dan CountryPhoneNumberForm obyekt yasash
     */
    private static CountryPhoneNumberForm mapRow(ResultSet rs) throws SQLException {
        CountryPhoneNumberForm model = new CountryPhoneNumberForm();
        model.setId(rs.getInt("id"));
        model.setCountry(rs.getString("country"));
        model.setCountryISO(rs.getString("countryISO"));
        model.setDialCode(rs.getString("dialCode"));
        model.setMask(rs.getString("mask"));
        return model;
    }

}
