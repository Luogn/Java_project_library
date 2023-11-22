package Controller;

import CommandLine.DictionaryManagement;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class WordMarkController implements Initializable {
    @FXML
    ListView<String> listbookmark;
    @FXML
    TextArea textArea;
    public static ArrayList<String> searchHistory = new ArrayList<>();
    public static ArrayList<String> bookMark = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listbookmark.getItems().setAll(bookMark);
        listbookmark.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                String newStr = DictionaryManagement.dictionaryLookup(listbookmark.getSelectionModel().getSelectedItem());
                textArea.setText(newStr);
            }
        });
    }


}
