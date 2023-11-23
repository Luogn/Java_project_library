package CommandLine;

import java.util.List;
import java.util.ArrayList;
import Trie.Trie;

public class Dictionary {
    static Trie trie = new Trie();
    private static final List<Word> wordList = new ArrayList<>(); //list to store the smaller group of word according to the given request

    public static List<Word> getWordList() {
        return wordList;
    }

    public static int getSize() {
        return wordList.size();
    }

    public static List<String> getTargetList(List<Word> list) {
        List<String> newList = new ArrayList<>();
        for(Word s : list) {
            newList.add(s.getWordTarget());
        }
        return newList;
    }

    public static Trie getTrie() {return trie;}

    public static void putWordsinTree() {
        List<String> newList = getTargetList(wordList);
        for(String s : newList) {
            trie.insert(s);
        }
    }
}