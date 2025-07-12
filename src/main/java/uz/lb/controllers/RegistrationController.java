package uz.lb.controllers;

import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import org.junit.platform.commons.logging.LoggerFactory;
import uz.lb.utils.theme.ThemeBinder;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class RegistrationController implements Initializable {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(RegistrationController.class);
    public AnchorPane id_apRoot;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ThemeBinder.bind(id_apRoot,
                "/css/dashboard/dashboard-dark.css",
                "/css/dashboard/dashboard-light.css",
                null
        );


    }
}
