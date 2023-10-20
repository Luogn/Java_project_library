package AppScreen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;


public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource
                    ("/Controller/DictionaryController.fxml"));

//            Image icon = new Image("D:\\file_lap_trinh\\Java\\Java_project_library\\src\\main\\resources\\Neccessary\\snow_icon.png");
//            stage.getIcons().add(icon);

//            stage.setTitle("Demo Window");
//            stage.setResizable(false);
//
//            Group root = new Group();

            Scene scene = new Scene(fxmlLoader.load(), 900, 600, Color.BLACK);

            stage.setScene(scene);
            stage.show();
        }
         catch(Exception e) {
            e.printStackTrace();
         }
    }

    public static void main(String[] args) {
        launch();
    }
}
