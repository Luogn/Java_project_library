package Controller;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Objects;

public class SceneController {
    @FXML
    AnchorPane parentPane;


    ImageView imgView1 = new ImageView(new Image(Objects.requireNonNull
            (getClass().getResourceAsStream("/Icon/search_symbol.png"))));
    ImageView imgView2 = new ImageView(new Image(Objects.requireNonNull
            (getClass().getResourceAsStream("/Icon/bookmark.png"))));
    ImageView imgView3 = new ImageView(new Image(Objects.requireNonNull
            (getClass().getResourceAsStream("/Icon/games.png"))));
    final ImageView imgView4 = new ImageView(new Image(Objects.requireNonNull
        (getClass().getResourceAsStream("/Icon/google_translate.png"))));

    @FXML
    Button button1;
    @FXML
    Button button2;
    @FXML
    Button button3;
    @FXML
    Button button4;


    private Stage stage;
    private Scene scene;
    private Parent root;

    public void displayButton() {
        imgView1.setFitHeight(button4.getHeight());
        imgView1.setFitWidth(button4.getWidth());

        imgView2.setFitHeight(button4.getHeight());
        imgView2.setFitWidth(button4.getWidth());

        imgView3.setFitHeight(button4.getHeight());
        imgView3.setFitWidth(button4.getWidth());

        imgView4.setFitHeight(button4.getHeight());
        imgView4.setFitWidth(button4.getWidth());

        System.out.println(button1.getHeight());
        System.out.println(button1.getWidth());
        System.out.println(button2.getHeight());
        System.out.println(button2.getWidth());

        button2.setGraphic(imgView2);
        button3.setGraphic(imgView3);
        button1.setGraphic(imgView1);
        button4.setGraphic(imgView4);
    }

    private void fadeInTransition(AnchorPane node) {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), node);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();
    }

    private void translateTransition(AnchorPane node, double fromX, double toX, double fromY, double toY) {
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(1000), node);
        translateTransition.setFromX(fromX);
        translateTransition.setToX(toX);
        translateTransition.setFromY(fromY);
        translateTransition.setToY(toY);
        translateTransition.play();
    }

    public void switchToScene1() throws Exception {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/Controller/DictionaryController.fxml"));
        DictionaryController paneDict = fxml.getController();
        button1.setScaleX(1.5);
        button1.setScaleY(1.5);

        // Phóng to button khác về kích thước ban đầu
        button2.setScaleX(1.0);
        button2.setScaleY(1.0);
        button3.setScaleX(1.0);
        button3.setScaleY(1.0);
        button4.setScaleX(1.0);
        button4.setScaleY(1.0);
        AnchorPane childPane = fxml.load();
        fadeInTransition(childPane);

        parentPane.getChildren().setAll(childPane);

    }

    public void switchToScene2() throws Exception {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/Controller/WordMarkController.fxml"));
        DictionaryController paneDict = fxml.getController();
        // Phóng to button hiện tại
        button2.setScaleX(1.5);
        button2.setScaleY(1.5);

        // Phóng to button khác  về kích thước ban đầu
        button1.setScaleX(1.0);
        button1.setScaleY(1.0);
        button3.setScaleX(1.0);
        button3.setScaleY(1.0);
        button4.setScaleX(1.0);
        button4.setScaleY(1.0);

        AnchorPane childPane = fxml.load();
        translateTransition(childPane, -300, 0, 0, 0);
        parentPane.getChildren().setAll(childPane);
    }

    public void switchToScene3() throws Exception {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/Controller/GameController.fxml"));
        DictionaryController paneDict = fxml.getController();

        // Phóng to button hiện tại
        button3.setScaleX(1.5);
        button3.setScaleY(1.5);

        // Phóng to button khác về kích thước ban đầu
        button1.setScaleX(1.0);
        button1.setScaleY(1.0);
        button2.setScaleX(1.0);
        button2.setScaleY(1.0);
        button4.setScaleX(1.0);
        button4.setScaleY(1.0);
        AnchorPane childPane = fxml.load();
        translateTransition(childPane, 900, 0, 0, 0);
        parentPane.getChildren().setAll(childPane);
    }

    public void switchToScene4() throws Exception {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/Controller/TranslationController.fxml"));
        DictionaryController paneDict = fxml.getController();

        button4.setScaleX(1.5);
        button4.setScaleY(1.5);

        // Phóng to button khác về kích thước ban đầu
        button1.setScaleX(1.0);
        button1.setScaleY(1.0);
        button2.setScaleX(1.0);
        button2.setScaleY(1.0);
        button3.setScaleX(1.0);
        button3.setScaleY(1.0);
        AnchorPane childPane = fxml.load();
        translateTransition(childPane, 0, 0, -200, 0);
        parentPane.getChildren().setAll(childPane);
    }
}
