package Controller;


import CommandLine.Dictionary;
import CommandLine.DictionaryManagement;
import CommandLine.Word;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.*;
import java.net.URL;
import java.util.*;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import CommandLine.DictionaryCommandLine;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class DictionaryController implements Initializable {
    @FXML
    private TextField my_textfield;
    @FXML
    private ListView<String> my_listView;
    @FXML
    private TextArea my_textarea;
    @FXML
    private TextField insertField;
    @FXML
    private TextArea insertArea;
    @FXML
    private AnchorPane insertPane;

    @FXML
    Button bookMark = new Button();

    @FXML
    Button buttonHistory = new Button();

    @FXML
    Button buttonDelete = new Button();

    @FXML
    Button buttonEdit = new Button();

    @FXML
    Button buttonInsert = new Button();

    @FXML
    Button checkUpdated = new Button();

    @FXML
    Button checkInsert = new Button();

    public ListView<String> history ;

    private void fadeInTransition(AnchorPane node) {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), node);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();
    }

    public ArrayList<String> historyword = new ArrayList<>();
    public void search() throws Exception {
        // Chỉ hiển thị listView khi bắt đầu search
        if(!(my_listView.isVisible())) {
            my_listView.setVisible(true);
        }
        initialize(null, null);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        my_textfield.setOnKeyReleased(event -> {
            String str = my_textfield.getText();
            my_listView.getItems().clear(); //Xóa list view để khi tra lại không hiển thị lại các từ đã tra.
//            List<Word> list = DictionaryCommandLine.dictionarySearcher(str);
            List<String> arr = DictionaryCommandLine.dictionarySearcher(str);
            my_listView.getItems().addAll(arr);
        });

        my_listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                String newStr = DictionaryManagement.dictionaryLookup(my_listView.getSelectionModel().getSelectedItem());
                my_textfield.setText(my_listView.getSelectionModel().getSelectedItem());
                my_textarea.setText(newStr);
            }

        });
        my_listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                //////////đọc vào file history
                FileWriter fileWriter = null;
                try {
                    fileWriter = new FileWriter("src\\main\\resources\\Neccessary\\historyword.txt", true);

                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    bufferedWriter.write(newValue);
                    bufferedWriter.newLine();
                    bufferedWriter.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        history.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                String newStr = DictionaryManagement.dictionaryLookup(history.getSelectionModel().getSelectedItem());
                my_textarea.setText(newStr);
            }
        });
    }

    public void addbookmark() {
        String word = my_textfield.getText();
        WordMarkController.bookMark.add(word);
    }

    public void deleteWord() {
        String word = my_textfield.getText();
        DictionaryManagement.removeWord(word);
    }

    public void insertWord() {
        checkInsert.setVisible(true);
        insertPane.setVisible(true);
        fadeInTransition(insertPane);
    }

    public void doneInsert() {
        String newWord = insertField.getText();
        String newMeaning = "\n" + insertArea.getText();
        DictionaryManagement.addWord(newWord, newMeaning);
        checkInsert.setVisible(false);
        insertPane.setVisible(false);
    }

    public void editWord() {
        my_textarea.setEditable(true);
        checkUpdated.setVisible(true);
    }

    public void doneUpdate() {
        String updatedStr = my_textarea.getText();
        DictionaryManagement.update(my_textfield.getText(), updatedStr, "CHANGE");
        my_textarea.setEditable(false);
        checkUpdated.setVisible(false);
    }

    public void Historyword() throws IOException {
        List<String> data_list = new ArrayList<>();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("src\\main\\resources\\Neccessary\\historyword.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        String line;
        while (true) {
            try {
                if (!((line = reader.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            data_list.add(line);
            Collections.reverse(data_list);
        }
        reader.close();
        history.getItems().setAll(data_list);
        history.setVisible(!history.isVisible());

    }
}
