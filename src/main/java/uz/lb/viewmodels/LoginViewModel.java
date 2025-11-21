package uz.lb.viewmodels;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginViewModel {
    private final StringProperty password = new SimpleStringProperty("");
    private final BooleanProperty loginSuccess = new SimpleBooleanProperty(false);
    private final BooleanProperty loginError = new SimpleBooleanProperty(false);

    public StringProperty passwordProperty() { return password; }
    public BooleanProperty loginSuccessProperty() { return loginSuccess; }
    public BooleanProperty loginErrorProperty() { return loginError; }

    public void login() {
        String pass = password.get();

        if ("qweqwe".equals(pass)) {
            loginSuccess.set(true);
            loginError.set(false);
        } else {
            loginSuccess.set(false);
            loginError.set(true);
        }
    }
}
