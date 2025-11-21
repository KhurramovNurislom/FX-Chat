package uz.lb.db;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

public class ModelTableMapper {

    // Model klassdagi fieldlardan: columnName → SQL type xaritasi tuzamiz
    public static Map<String, String> columnsFromModel(Class<?> modelClass) {
        Map<String, String> map = new LinkedHashMap<>();

        for (Field field : modelClass.getDeclaredFields()) {
            String fieldName = field.getName();          // masalan: "countryISO"
            Class<?> type = field.getType();             // masalan: String.class

            // id bo'lsa primary key qilamiz (xohlasang annotation bilan ham boshqarish mumkin)
            if ("id".equalsIgnoreCase(fieldName)) {
                map.put(fieldName, "INTEGER PRIMARY KEY AUTOINCREMENT");
                continue;
            }

            // Java turiga qarab SQLite turini tanlaymiz
            String sqlType = javaTypeToSqlType(type);

            // Hozircha NOT NULL yoki NULLni qo'lda hal qilasan,
            // soddalik uchun TEXT/INTEGER bo'lib turadi:
            map.put(fieldName, sqlType);
        }

        return map;
    }

    private static String javaTypeToSqlType(Class<?> type) {
        if (type == Integer.class || type == int.class ||
            type == Long.class    || type == long.class) {
            return "INTEGER";
        }

        if (type == Boolean.class || type == boolean.class) {
            return "INTEGER"; // 0/1 qilib saqlaymiz
        }

        if (type == Double.class || type == double.class ||
            type == Float.class  || type == float.class) {
            return "REAL";
        }

        // default: String, boshqa unknown turlar
        return "TEXT";
    }
}
