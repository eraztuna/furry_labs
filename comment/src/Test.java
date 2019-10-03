import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        var code = new Code();

        var in = new Scanner(System.in);
        String line;

        while ((line = in.nextLine()).length() != 0) {
            code.addLine(line);
        }

        var cleanCodeRegex = code.removeCommentsRegex();
        System.out.println(cleanCodeRegex);
    }
}
