import java.util.ArrayList;
import java.util.List;

public class Words {
    private List<Word> words = new ArrayList<Word>();

    public void addLine(String line) {
        for (var word : (line.split("[., ]"))) {
            words.add(new Word(word));
        }
    }

    public void addWord(Word word) {
        words.add(word);
    }

    public List<Word> getWords() {
        return new ArrayList<Word>(words);
    }

    public Words findPalindromes() {
        var palindromes = new Words();
        for (var word : words) {
            if (word.isPalindrome()) {
                palindromes.addWord(word);
            }
        }
        return palindromes;
    }

    public Word getLongestWord() {
        int maxLength = 0;
        Word longestWord = new Word("");
        for (var word : words) {
            if (word.getLength() > maxLength) {
                maxLength = word.getLength();
                longestWord = word;
            }
        }
        return longestWord;
    }
}
