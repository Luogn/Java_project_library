package Trie;


import java.util.ArrayList;
import java.util.List;

public class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }
        return node.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }
        return true;
    }

    public List<String> getAllWordsWithPrefix(String prefix) {
        List<String> result = new ArrayList<>();
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.children.get(c) == null) {
                return result;
            }
            node = node.children.get(c);
        }
        getAllWordsFromNode(node, prefix, result);
        return result;
    }

    private void getAllWordsFromNode(TrieNode node, String prefix, List<String> result) {
        if (node.isWord()) {
            result.add(prefix);
        }
        for (char c = 'a'; c <= 'z'; c++) {
            TrieNode child = node.children.get(c);
            if (child != null) {
                getAllWordsFromNode(child, prefix + c, result);
            }
        }
    }
}
