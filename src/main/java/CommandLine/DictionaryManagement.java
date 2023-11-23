package CommandLine;

import java.io.*;
import java.util.Scanner;
//import java.io.FileReader;


public class DictionaryManagement {
    static final String filepath_read = "src\\main\\resources\\dictionaries.txt";
    static final String filepath_write = "src\\main\\resources\\words_alpha.txt";

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

    public static void insertFromFile() {
        try {
            FileReader fileReader = new FileReader(filepath_read);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String englishWord = bufferedReader.readLine();
            englishWord = englishWord.replace("|", "");
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Word word = new Word();
                word.setWordTarget(englishWord.trim());
                String meaning = line + "\n";
                while ((line = bufferedReader.readLine()) != null)
                    if (!(line.startsWith("|"))) {
                        meaning += line + "\n";
                    } else {
                        englishWord = line.replace("|", "");
                        break;
                    }
                word.setWordExplain(meaning.trim());
                addWord(word);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("An error occur with file: " + e);
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e);
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

    public static String dictionaryLookup(String wordTarget) {
        StringBuilder res = new StringBuilder();
        int cnt = 0;
        for(int i =0 ;i<Dictionary.getSize();i++) {
            if(!(Dictionary.getWordList().get(i).getWordTarget().equals(wordTarget))) {
                cnt++;
            }
        }

        if(cnt == Dictionary.getSize()) {
            res.append("Word not found!");
            return res.toString();
        }

        for(int i = 0; i < Dictionary.getSize(); i++) {
            Word rand = Dictionary.getWordList().get(i);
            if(rand.getWordTarget().equals(wordTarget)) {
                res.append(rand.getWordTarget()).append(" ").append(rand.getWordExplain());
            }
        }
        return res.toString();
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
