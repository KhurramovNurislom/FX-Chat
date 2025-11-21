package uz.lb.caches;

import uz.lb.views.ChatContentsView;
import uz.lb.views.DashboardView;
import uz.lb.views.LoginView;
import uz.lb.views.SettingsView;

public class ControllerRegistry {
    private static DashboardView dashboardView;
    private static LoginView loginView;

    private static ChatContentsView chatContentsView;
    private static SettingsView settingsView;

    public static SettingsView getSettingsController() {
        return settingsView;
    }

    public static void setSettingsController(SettingsView settingsView) {
        ControllerRegistry.settingsView = settingsView;
    }

    public static void setDashboardController(DashboardView controller) {
        dashboardView = controller;
    }

    public static DashboardView getDashboardController() {
        return dashboardView;
    }


    public static void setChatContentsController(ChatContentsView controller) {
        chatContentsView = controller;
    }

    public static ChatContentsView getChatContentsController() {
        return chatContentsView;
    }

    public static LoginView getLoginController() {
        return loginView;
    }

    public static void setLoginController(LoginView loginView) {
        ControllerRegistry.loginView = loginView;
    }
}
