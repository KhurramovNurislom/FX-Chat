package uz.lb.caches;

import uz.lb.controllers.ChatContentsController;
import uz.lb.controllers.DashboardController;

public class ControllerRegistry {
    private static DashboardController dashboardController;

    private static ChatContentsController chatContentsController;

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
}
