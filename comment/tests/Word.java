public class Word {
    private String word;

    public Word(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return word;
    }

    public int getLength() {
        return word.length();
    }

    public boolean isPalindrome() {
        String reverseWord = (new StringBuffer(word))
                .reverse()
                .toString();
        return word.equals(reverseWord);
    }
}
