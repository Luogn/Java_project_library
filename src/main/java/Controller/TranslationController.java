package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


public class TranslationController {
    @FXML
    private  TextArea sourceLangField;
    @FXML
    private TextArea toLangField;
    @FXML
    private Button translateBtn;
    String texten;

    @FXML
    private Label englishLabel , vietnameseLabel;
    private static String translate(String langFrom, String langTo, String text) throws IOException {
        String urlStr = "https://script.google.com/macros/s/AKfycbxzCfT78zpe2hPNd75uEzo7Joq2m-ach6UxoEuKpnf0JEgUcBc4C7SKL6QFeZ5ghDJM/exec"
                +
                "?q=" + URLEncoder.encode(text, StandardCharsets.UTF_8) +
                "&target=" + langTo +
                "&source=" + langFrom;
        URL url = new URL(urlStr);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    public  void  translateEnToVi() {
        try {
            texten = sourceLangField.getText();
            System.out.println(sourceLangField.getText());
            String a= translate("en", "vi", texten);
            System.out.println(a);
            toLangField.setText(a);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void  translateViToEn() {
        try {
            texten = sourceLangField.getText();
            System.out.println(sourceLangField.getText());
            String a= translate("vi", "en", texten);
            System.out.println(a);
            toLangField.setText(a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
