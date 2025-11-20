package uz.lb.caches;

import uz.lb.controllers.ChatContentsController;
import uz.lb.controllers.DashboardController;
import uz.lb.controllers.LoginController;
import uz.lb.controllers.SettingsController;

public class ControllerRegistry {
    private static DashboardController dashboardController;
    private static LoginController loginController;

    private static ChatContentsController chatContentsController;
    private static SettingsController settingsController;

    public static SettingsController getSettingsController() {
        return settingsController;
    }

    public static void setSettingsController(SettingsController settingsController) {
        ControllerRegistry.settingsController = settingsController;
    }

    public static void setDashboardController(DashboardController controller) {
        dashboardController = controller;
    }

    public static DashboardController getDashboardController() {
        return dashboardController;
    }


    public static void setChatContentsController(ChatContentsController controller) {
        chatContentsController = controller;
    }

    public static ChatContentsController getChatContentsController() {
        return chatContentsController;
    }

    public static LoginController getLoginController() {
        return loginController;
    }

    public static void setLoginController(LoginController loginController) {
        ControllerRegistry.loginController = loginController;
    }
}
