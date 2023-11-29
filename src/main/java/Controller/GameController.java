package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class GameController implements Initializable {

    @FXML
    private Text EndOfGameText;

    @FXML
    private Text TextForWord;
    @FXML
    private Text scoreText;
    @FXML
    private TextField Guess;

    @FXML
    private Text hangmanTextArea;
    private String word;
    private StringBuilder secretWord = new StringBuilder();
    private int livePos = 0;
    ArrayList<String> hangManLives = new ArrayList<>(Arrays.asList(
            """
            +---+
            |   |
                |
                | 
                |
                |
          =========""",
            """
            +---+
            |   |
            O   |
                |
                |
                |
          =========""",
            """
            +---+
            |   |
            O   |
            |   |
                |
                |
          =========""",
            """
            +---+
            |   |
            O   |
           /|   |
                |
                |
          =========""",
            """
            +---+
            |   |
            O   |
           /|\\  |
                |
                |
          =========""",
            """
            +---+
            |   |
            O   |
           /|\\  |
           /    |
                |
          =========""",
            """
            +---+
            |   |
            O   |
           /|\\  |
           / \\  |
                |
          ========="""
    ));
    private int score = 0;
    private String getRandomWordFromHistoryFile(String filePath) {
        try {
            Path path = Paths.get("src\\main\\resources\\Neccessary\\historyword.txt");
            List<String> words = Files.readAllLines(path);
            if (!words.isEmpty()) {
                int randomIndex = new Random().nextInt(words.size());
                return words.get(randomIndex);
            } else {
                return "defaults";
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            return  "default";
        }
    }
    public void setupWord() {
        int wordLength = word.length();
        secretWord.append("*".repeat(wordLength));
        TextForWord.setText(String.valueOf(secretWord));
    }
    public void playTurn() {
        String Guess = this.Guess.getText();
        ArrayList<Integer> positions = new ArrayList<>();
        char[] wordChars = word.toCharArray();
        char letterGuess = Guess.charAt(0);
        if(word.equals(Guess)) {
            EndOfGameText.setText("You Won !");
            score += 10;
            scoreText.setText("Score: " + score);
            return;
        }
        if (word.contains(Guess)){
            for (int i = 0 ; i < word.length() ; i++) {
                if (wordChars[i] == letterGuess ) {
                    positions.add(i);
                }
            }
            positions.forEach(pos->{
                secretWord.setCharAt(pos,letterGuess);
            });
            TextForWord.setText(String.valueOf(secretWord));
        }
        else {
            hangmanTextArea.setText(hangManLives.get(++livePos));
            if (livePos == 6) {
                EndOfGameText.setText("You lost !");
                score -= 5;
                scoreText.setText("Score: " + score);
            }
        }
    }

    @FXML
    void getTextInput(ActionEvent event) {
        playTurn();
    }
    @FXML
    void reset (ActionEvent event) {
        word = getRandomWordFromHistoryFile("src\\main\\resources\\Neccessary\\historyword.txt");
        secretWord.setLength(0);
        livePos = 0;
        hangmanTextArea.setText(hangManLives.get(0));
        EndOfGameText.setText("");
        setupWord();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        word = getRandomWordFromHistoryFile("src\\main\\resources\\Neccessary\\historyword.txt");
        setupWord();
        hangmanTextArea.setText(hangManLives.get(livePos));
    }
}
