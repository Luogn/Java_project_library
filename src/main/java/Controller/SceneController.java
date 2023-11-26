package Controller;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
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

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Objects;


public class SceneController {
    @FXML
    AnchorPane parentPane;
    @FXML
    Label timeLabel = new Label();
    @FXML
    Label periodLabel = new Label();
    @FXML
    Label dateLabel = new Label();

    LocalDateTime dateTime = LocalDateTime.now();

    private final ImageView imgView1 = new ImageView(new Image(Objects.requireNonNull
            (getClass().getResourceAsStream("/Icon/search_symbol.png"))));
    private final ImageView imgView2 = new ImageView(new Image(Objects.requireNonNull
            (getClass().getResourceAsStream("/Icon/bookmark.png"))));
    private final ImageView imgView3 = new ImageView(new Image(Objects.requireNonNull
            (getClass().getResourceAsStream("/Icon/games.png"))));
    private final ImageView imgView4 = new ImageView(new Image(Objects.requireNonNull
        (getClass().getResourceAsStream("/Icon/google_translate.png"))));
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

        imgView6.setFitHeight(button6.getHeight());
        imgView6.setFitWidth(button6.getWidth());


        button2.setGraphic(imgView2);
        button3.setGraphic(imgView3);
        button1.setGraphic(imgView1);
        button4.setGraphic(imgView4);
        button6.setGraphic(imgView6);
    }

    public void updateTimeLabel() {
        LocalDate today = LocalDate.now();
        DayOfWeek dayOfWeek = today.getDayOfWeek();
        String dayOfWeekString = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault());

        Thread updateTimeThread = new Thread(() -> {
            while (true) {
                Platform.runLater(() -> {
                    LocalDateTime currentDateTime = LocalDateTime.now();

                    // Định dạng ngày
                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String formattedDate = currentDateTime.format(dateFormatter);
                    dateLabel.setText(dayOfWeekString+" "+formattedDate);

                    // Định dạng thời gian
                    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                    String formattedTime = currentDateTime.format(timeFormatter);
                    timeLabel.setText(formattedTime);

                    // Phân biệt sáng, trưa, chiều, tối
                    int hour = currentDateTime.getHour();
                    String period;
                    if (hour >= 5 && hour < 12) {
                        period = "Morning!";
                    } else if (hour >= 12 && hour < 15) {
                        period = "Noon!";
                    } else if (hour >= 15 && hour < 19) {
                        period = "Afternoon!";
                    } else {
                        period = "Evening!";
                    }
                    periodLabel.setText("Good " + period);
                });

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        updateTimeThread.setDaemon(true);
        updateTimeThread.start();
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

//    public void displayTime() {
//        String str = String.format("%-19s" , dateTime.toString());
//        dateDisplay.setText(dateTime.toString());
//    }
    public void closeAllScene() {
        parentPane.getChildren().clear();
    }
}
