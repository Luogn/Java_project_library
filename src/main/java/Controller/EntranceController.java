package Controller;

import CommandLine.DictionaryManagement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EntranceController {
    @FXML
    TextField nameTextField;
    @FXML
    Button loginButton;
    @FXML
    Label label = new Label("WELCOME TO SNOW-E");
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void login(ActionEvent event) throws Exception {
        try {
            DictionaryManagement.insertFromFile();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        String username = nameTextField.getText();

        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/Controller/SceneController.fxml"));
        root = fxml.load();

        SceneController scene_ = fxml.getController();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        scene_.displayButton();
        scene_.displayTime();

        stage.show();
    }
}
