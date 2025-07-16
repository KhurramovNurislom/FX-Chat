package uz.lb.controllers;

public class ControllerRegistry {
    private static DashboardController dashboardController;

    public static void setDashboardController(DashboardController controller) {
        dashboardController = controller;
    }

    public static DashboardController getDashboardController() {
        return dashboardController;
    }
}
