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

import java.time.LocalDateTime;
import java.util.Objects;


public class SceneController {
    @FXML
    AnchorPane parentPane;
    @FXML
    Label dateDisplay;
    LocalDateTime dateTime = LocalDateTime.now();

    private final ImageView imgView1 = new ImageView(new Image(Objects.requireNonNull
            (getClass().getResourceAsStream("/Icon/search_symbol.png"))));
    private final ImageView imgView2 = new ImageView(new Image(Objects.requireNonNull
            (getClass().getResourceAsStream("/Icon/bookmark.png"))));
    private final ImageView imgView3 = new ImageView(new Image(Objects.requireNonNull
            (getClass().getResourceAsStream("/Icon/games.png"))));
    private final ImageView imgView4 = new ImageView(new Image(Objects.requireNonNull
        (getClass().getResourceAsStream("/Icon/google_translate.png"))));

//    private final ImageView imgView5 = new ImageView(new Image(Objects.requireNonNull
//            (getClass().getResourceAsStream("/Icon/history.png"))));
    private final ImageView imgView6 = new ImageView(new Image(Objects.requireNonNull
            (getClass().getResourceAsStream("/Icon/logout.png"))));

    @FXML
    Button button1;
    @FXML
    Button button2;
    @FXML
    Button button3;
    @FXML
    Button button4;
//    @FXML
//    Button button5;
    @FXML
    Button button6;


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

//        imgView5.setFitHeight(button5.getHeight());
//        imgView5.setFitWidth(button5.getWidth());

        imgView6.setFitHeight(button6.getHeight());
        imgView6.setFitWidth(button6.getWidth());


        button2.setGraphic(imgView2);
        button3.setGraphic(imgView3);
        button1.setGraphic(imgView1);
        button4.setGraphic(imgView4);
//        button5.setGraphic(imgView5);
        button6.setGraphic(imgView6);
    }

//    private void fadeInTransition(AnchorPane node) {
//        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), node);
//        fadeTransition.setFromValue(0.0);
//        fadeTransition.setToValue(1.0);
//        fadeTransition.play();
//    }

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

        translateTransition(childPane, -300, 0, 0, 0);

        parentPane.getChildren().setAll(childPane);
    }

    public void switchToScene2() throws Exception {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/Controller/WordMarkController.fxml"));
        WordMarkController paneDict = fxml.getController();
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
        GameController paneDict = fxml.getController();

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
        translateTransition(childPane, -300, 0, 0, 0);
        parentPane.getChildren().setAll(childPane);
    }

    public void switchToScene4() throws Exception {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/Controller/TranslationController.fxml"));
        TranslationController paneDict = fxml.getController();

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
        translateTransition(childPane, -300, 0, 0, 0);
        parentPane.getChildren().setAll(childPane);
    }

    public void displayTime() {
        String str = String.format("%-19s" , dateTime.toString());
        dateDisplay.setText(dateTime.toString());
    }
    public void closeAllScene() {
        parentPane.getChildren().clear();
        displayTime();
    }
}
