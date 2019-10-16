import java.util.List;

public class Test {
    public static void main(String[] args) {
        var input = new Input();

        Text text = input.readText();
        Fragments fragments = input.readFragments();

        var output = new Output();

        List<Integer> lineNumbers = fragments.getLineNumbers(text);
        output.writeLineNumbers(lineNumbers);

        Fragments notFoundFragments = fragments.getNotFoundFragments(text);
        output.writeNotFoundFragments(notFoundFragments);

        Tags tags = text.getTags().unique();
        output.writeTags(tags.sorted());
    }
}
