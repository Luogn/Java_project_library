package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TranslationController extends SceneController {
    public void gotoDictionary(ActionEvent event) throws Exception {
        super.swichToScene1(event);
    }

    public void gotoGame(ActionEvent event) throws Exception {
        super.swichToScene3(event);
    }
}
