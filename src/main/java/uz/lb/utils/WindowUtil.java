package uz.lb.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class WindowUtil {

    public static void openWindow(String fxmlPath, String title, Stage parentStage) {
        try {
            FXMLLoader loader = new FXMLLoader(WindowUtil.class.getResource(fxmlPath));
            Parent root = loader.load();

            Stage newStage = new Stage();
            newStage.setTitle(title);
            newStage.setScene(new Scene(root));

            if (parentStage != null) {
                newStage.initOwner(parentStage);
                newStage.initModality(Modality.NONE);
            }

            newStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
