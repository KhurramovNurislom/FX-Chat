package uz.lb.utils;

import javafx.stage.Stage;

public class WindowBounds {
    private double x;
    private double y;
    private double width;
    private double height;
    
    public WindowBounds() {}
    
    public WindowBounds(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    // Getters and Setters
    public double getX() { return x; }
    public void setX(double x) { this.x = x; }
    
    public double getY() { return y; }
    public void setY(double y) { this.y = y; }
    
    public double getWidth() { return width; }
    public void setWidth(double width) { this.width = width; }
    
    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }
    
    public void saveFromStage(Stage stage) {
        this.x = stage.getX();
        this.y = stage.getY();
        this.width = stage.getWidth();
        this.height = stage.getHeight();
    }
    
    public void applyToStage(Stage stage) {
        stage.setX(x);
        stage.setY(y);
        stage.setWidth(width);
        stage.setHeight(height);
    }
}