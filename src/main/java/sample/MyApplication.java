package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author jwright
 */
public class MyApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent components = FXMLLoader.load(getClass().getResource("/MemberManager.fxml"));

        Scene scene = new Scene(components);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
