package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.net.URL;

public class GameController implements Initializable {

    @FXML
    private Text EndOfGameText;

    @FXML
    private Text TextForWord;

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
            }
        }
    }

    @FXML
    void getTextInput(ActionEvent event) {
        if (word == null ) {
            word = Guess.getText();
            setupWord();
            Guess.clear();
        }
        else {
            playTurn();
        }
    }
    @FXML
    void reset (ActionEvent event) {
        word = null;
        secretWord.setLength(0);
        livePos = 0;
        hangmanTextArea.setText(hangManLives.get(0));
        EndOfGameText.setText("");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hangmanTextArea.setText(hangManLives.get(livePos));
    }
}
