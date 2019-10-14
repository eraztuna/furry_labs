import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Output {
    public void writeTags(Tags tags) {
        try (var out = new FileWriter("output3.out")) {
            out.write(tags.toString());
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public void writeNotFoundFragments(Fragments notFoundFragments) {
        try (var out = new FileWriter("output2.out")) {
            out.write(notFoundFragments.toString());
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public void writeLineNumbers(List<Integer> lineNumbers) {
        try (var out = new FileWriter("output1.out")) {
            for (var number : lineNumbers) {
                out.write(number.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
