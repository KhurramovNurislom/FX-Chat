package uz.lb;

import uz.lb.config.AppConfig;

public class Test {
    public static void main(String[] args) {
        AppConfig.add("test.test", String.valueOf(true));
        System.out.println(AppConfig.getBoolean("theme.light"));
    }
}
