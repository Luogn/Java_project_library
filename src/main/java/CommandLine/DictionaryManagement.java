package CommandLine;

import java.util.Scanner;
import java.io.BufferedReader;
//import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class DictionaryManagement {
    static final String filepath_read = "file:/dictionary.txt";
    static final String filepath_write = "file:/words_alpha.txt";

    public static void insertFromCommandline() {

        System.out.println("please enter the number of words you want to add:");
        int numOfWords = Integer.parseInt(DictionaryCommandLine.sc.nextLine());
        Scanner sd = new Scanner(System.in);
        for(int i=0;i<numOfWords;i++) {
            System.out.println("the word you want to add");
            String engWords = sd.nextLine();
            System.out.println("its meaning:");
            String meaning = sd.nextLine();
            Word rand = new Word(engWords, meaning);
            addWord(rand);
        }
    }

    public static void insertFromFile() throws Exception{
        // Read data from text file
        InputStreamReader read = new InputStreamReader(new FileInputStream(filepath_read), "UTF-8");
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(read);

            while (true) {
                String inputLine = bufferedReader.readLine();
                // System.out.println(inputLine);
                if(inputLine == null) break;
                // Tách các từ từ dòng đọc được
                String[] words = inputLine.split("[|]");

                Word rand = new Word(words[0].trim(), words[1].trim());

                addWord(rand);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void dictionaryExportToFile() throws Exception {
        try {
            FileWriter fileWriter = new FileWriter(filepath_write, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for(int i=0;i<Dictionary.getSize();i++){
                bufferedWriter.write(Dictionary.getWordList().get(i).getWordTarget() + "\t\t");
                bufferedWriter.write(Dictionary.getWordList().get(i).getWordExplain());
                bufferedWriter.newLine();
            }

            bufferedWriter.close();

            // System.out.println("success");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void dictionaryLookup(String wordTarget) {
        int cnt = 0;
        for(int i =0 ;i<Dictionary.getSize();i++) {
            if(!(Dictionary.getWordList().get(i).getWordTarget().equals(wordTarget))) {
                cnt++;
            }
        }

        if(cnt == Dictionary.getSize()) {
            System.out.println("Word not found!");
            return;
        }

        for(int i = 0; i < Dictionary.getSize(); i++) {
            Word rand = Dictionary.getWordList().get(i);
            if(rand.getWordTarget().equals(wordTarget)) {
                System.out.println(rand.getWordTarget() + " " + rand.getWordExplain());
            }
        }
    }

    public static void addWord(Word word) {
        Dictionary.getWordList().add(word);
    }

    public static void removeWord(String word) {
        for (int i = 0; i < Dictionary.getSize(); i++) {
            if (Dictionary.getWordList().get(i).getWordTarget().equals(word)) {
                Dictionary.getWordList().remove(i);
                i--;
            }
        }
    }

    public static void update(String wordE,String wordM, String action) {
        int cnt = 0;
        for(int i =0 ;i<Dictionary.getSize();i++) {
            if(!(Dictionary.getWordList().get(i).getWordTarget().equals(wordE))) {
                cnt++;
            }
        }

        if(cnt == Dictionary.getSize()) {
            System.out.println("Word not found!");
            return;
        }

        for(int i =0 ;i<Dictionary.getSize();i++) {

            if(Dictionary.getWordList().get(i).getWordTarget().equals(wordE))
            {
                if(action.equals("ADD")) {
                    String tmp = Dictionary.getWordList().get(i).getWordExplain() + " " + wordM;
                    Dictionary.getWordList().get(i).setWordExplain(tmp);
                }

                if(action.equals("CHANGE")) {
                    Dictionary.getWordList().get(i).setWordExplain(wordM);
                }
            }
        }
    }
}
