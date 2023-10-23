package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class DictionaryController extends SceneController {
    @FXML
    TextField my_textfield;

    @FXML
    Pane my_pane;

    public void gotoMark(ActionEvent event) throws Exception {
        super.switchToScene2(event);
    }

    public void gotoGame(ActionEvent event) throws Exception {
        super.switchToScene3(event);
    }

    public void gotoTranslation(ActionEvent event) throws Exception {
        super.switchToScene4(event);
    }

    public void getText() {
        System.out.print(my_textfield.getText());
    }
}
