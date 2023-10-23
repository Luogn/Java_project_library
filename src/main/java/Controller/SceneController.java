package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void swichToScene1(ActionEvent event) throws Exception {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/Controller/DictionaryController.fxml"));
        Parent root = fxml.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void swichToScene3(ActionEvent event) throws Exception {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/Controller/GameController.fxml"));
        Parent root = fxml.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void swichToScene4(ActionEvent event) throws Exception {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/Controller/TranslationController.fxml"));
        Parent root = fxml.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
