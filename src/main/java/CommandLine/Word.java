package CommandLine;

import java.util.Objects;

public class Word {
    private String wordTarget;
    private String wordExplain;

    public Word(){};
    public Word(String wordTarget, String wordExplain) {
        this.wordTarget = wordTarget;
        this.wordExplain = wordExplain;
    }
    public String getWordTarget() {
        return wordTarget;
    }

    public String getWordExplain() {
        return wordExplain;
    }

    public void setWordTarget(String wordTarget) {
        this.wordTarget = wordTarget;
    }

    public void setWordExplain(String wordExplain) {
        this.wordExplain = wordExplain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word word)) return false;
        // if (this.hashCode() == o.hashCode()) return true;
        return Objects.equals(wordTarget, word.getWordTarget());
    }

    @Override
    public int hashCode() {
        return Objects.hash(wordTarget, wordExplain);
    }

    @Override
    public String toString() {
        return wordTarget + " \t\t|\t" + wordExplain;
    }
}