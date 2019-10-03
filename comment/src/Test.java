import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        String path;

        var sc = new Scanner(System.in);
        path = sc.nextLine();

        var files = new Files();
        files.filesFromFolder(new File(path));
    }
}
