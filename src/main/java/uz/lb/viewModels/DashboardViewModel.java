package uz.lb.viewModels;

import javafx.beans.property.*;

public class DashboardViewModel {

    private final BooleanProperty isNightMode = new SimpleBooleanProperty(true);
    private final BooleanProperty isFullScreen = new SimpleBooleanProperty(false);
    private final StringProperty searchText = new SimpleStringProperty();

    public BooleanProperty isNightModeProperty() { return isNightMode; }
    public BooleanProperty isFullScreenProperty() { return isFullScreen; }
    public StringProperty searchTextProperty() { return searchText; }

    public void toggleFullScreen() {
        isFullScreen.set(!isFullScreen.get());
        // Bu yerda real full screen funksionalligini chaqirish yoki event yaratish mumkin
    }

    public void toggleNightMode() {
        isNightMode.set(!isNightMode.get());
        // Tema o'zgarishini qo'llash mumkin
    }

    // Settings pane toggle flag yoki metodini shu yerda qiling
    private final BooleanProperty settingsPaneVisible = new SimpleBooleanProperty(false);
    public BooleanProperty settingsPaneVisibleProperty() { return settingsPaneVisible; }
    public void toggleSettingsPane() {
        settingsPaneVisible.set(!settingsPaneVisible.get());
    }
}
