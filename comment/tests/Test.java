import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        String line;
        var in = new Scanner(System.in);
        var words = new Words();

        while ((line = in.nextLine()).length() != 0) {
            words.addLine(line);
        }

        var palindromes = words.findPalindromes();
        System.out.println(palindromes.getLongestWord());
    }
}
