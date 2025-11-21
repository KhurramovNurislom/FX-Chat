package uz.lb;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import uz.lb.db.SQLiteConnection;
import uz.lb.services.WindowManager;
import uz.lb.config.AppConfig;
import uz.lb.views.DashboardView;
import uz.lb.utils.ResizableWindowHelper;

import java.security.Security;

public class RemusDesktop extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        AppConfig.config();
        Security.addProvider(new BouncyCastleProvider());
        SQLiteConnection.getInstance().initialize();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Dashboard.fxml"));
        Parent root = loader.load();

        stage.getIcons().add(new Image("/images/logo.png"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.centerOnScreen();
        stage.setFullScreenExitHint("");
        stage.setScene(scene);
        stage.setMinHeight(570);
        stage.setMinWidth(700);

        ResizableWindowHelper.makeResizable(stage);
        DashboardView controller = loader.getController();

        Pane titlePane = controller.getTitlePane();

        if (titlePane != null) {
            WindowManager wm = WindowManager.getInstance();
            wm.init(stage, titlePane);
        } else {
            System.out.println("error, title pane not found !..");
        }

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
