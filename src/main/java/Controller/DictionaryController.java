package Controller;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import CommandLine.DictionaryCommandLine;
import java.util.List;

public class DictionaryController implements Initializable {
    @FXML
    private TextField my_textfield;
    @FXML
    private ListView<String> my_listView;
    @FXML
    private TextArea my_textarea;

    public void search() {
        // Chỉ hiển thị listView khi bắt đầu search
        if(!(my_listView.isVisible())) {
            my_listView.setVisible(true);
        }
        initialize(null, null);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String str = my_textfield.getText();
        my_listView.getItems().clear(); //Xóa list view để khi tra lại không hiển thị lại các từ đã tra.
        List<String> list = DictionaryCommandLine.dictionarySearcher(str);
        my_listView.getItems().addAll(list);

        my_listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                my_listView.setVisible(false);
                my_textarea.setText(str);
            }
        });
    }
}