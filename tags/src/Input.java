import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Input {
    public Text readText() {
        Text text = new Text();

        try (var in = new Scanner(new File("input1.html"))) {
            while (in.hasNext()) {
                text.addLine(in.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("HTML file not found");
        }
        return text;
    }


    public Fragments readFragments() {
        var fragments = new Fragments();

        try (var in = new Scanner(new File("input2.in"))) {
            while (in.hasNext()) {
                fragments.addFragments(in.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fragments not found");
        }
        return fragments;
    }
}
