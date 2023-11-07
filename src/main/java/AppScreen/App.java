package AppScreen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;


public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource
                    ("/Controller/EntranceController.fxml"));
            Image icon = new Image("D:\\file_lap_trinh\\Java\\Java_project_library\\src\\main\\resources\\Neccessary\\snow_icon.png");
            stage.getIcons().add(icon);
            stage.setTitle("Demo Window");
            Scene scene = new Scene(fxmlLoader.load(), Color.BLACK);
            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest(windowEvent -> {
                windowEvent.consume();
                logout(stage);
            });
        }
         catch(Exception e) {
            e.printStackTrace();
         }
    }

    public void logout(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You are about to exit");
        alert.setContentText("Do you want to exit?");

        if(alert.showAndWait().get() == ButtonType.OK) {
            System.out.print("You have exited");
            stage.close();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
