package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SceneController {
    @FXML
    Label nameLabel;

    @FXML
    AnchorPane parentPane;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void displayName(String username) {
        nameLabel.setText("Welcom to SnowFlake " + username);
    }

    public void switchToScene1(ActionEvent event) throws Exception {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/Controller/DictionaryController.fxml"));
        DictionaryController paneDict = fxml.getController();

        AnchorPane childPane = fxml.load();
        parentPane.getChildren().setAll(childPane);
//        root = fxml.load();
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
    }

    public void switchToScene2(ActionEvent event) throws Exception {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/Controller/WordMarkController.fxml"));
        DictionaryController paneDict = fxml.getController();

        AnchorPane childPane = fxml.load();
        parentPane.getChildren().setAll(childPane);
    }

    public void switchToScene3(ActionEvent event) throws Exception {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/Controller/GameController.fxml"));
        DictionaryController paneDict = fxml.getController();

        AnchorPane childPane = fxml.load();
        parentPane.getChildren().setAll(childPane);
    }

    public void switchToScene4(ActionEvent event) throws Exception {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/Controller/TranslationController.fxml"));
        DictionaryController paneDict = fxml.getController();

        AnchorPane childPane = fxml.load();
        parentPane.getChildren().setAll(childPane);
    }
}
