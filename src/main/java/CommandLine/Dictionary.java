package CommandLine;

import java.util.List;
import java.util.ArrayList;

public abstract class Dictionary {
    private static final List<Word> wordList = new ArrayList<>(); //list to store the smaller group of word according to the given request


    public static List<Word> getWordList() {
        return wordList;
    }

    public static int getSize() {
        return wordList.size();
    }

    public static void addWord(Word word) {
        wordList.add(word);
    }

    public static void removeWord(String word) {
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).getWordTarget().equals(word)) {
                wordList.remove(i);
            }
            i--;
        }
    }
}