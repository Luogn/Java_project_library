package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class DictionaryController {
    @FXML
    TextField my_textfield;

    public void getText() {
        System.out.print(my_textfield.getText());
    }
}
