import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Code {
    private StringBuilder code;

    public Code() {
        this("");
    }

    public Code(String code) {
        this.code = new StringBuilder(code);
    }

    public void addLine(String line) {
        code.append(line);
        code.append("\n");
    }

    public Code removeCommentsRegex() {
        var cleanCode = new Code(code.toString());

        Pattern pattern = Pattern.compile(
                "(?: \"(?: [^\"\\\\] | \\\\.)*+ \"" +
                        "| '(?: [^'\\\\] | \\\\.)*+ '" +
                        "| (?: [^'\"/])+" +
                        "| / (?! [/*])" +
                        ")*+" +
                        "(//.*\n | /\\*(?s).*?\\*/)",
                Pattern.MULTILINE | Pattern.COMMENTS
        );
        Matcher matcher = pattern.matcher(code);

        List<Pair<Integer, Integer>> boundaries = new ArrayList<>();
        while (matcher.find()) {
            boundaries.add(new Pair<>(matcher.start(1),
                    matcher.end(1)));
        }

        Collections.reverse(boundaries);
        for (var boundary : boundaries) {
            cleanCode.code.replace(boundary.getKey(),
                    boundary.getValue(), "");
        }
        return cleanCode;
    }

    @Override
    public String toString() {
        return code.toString();
    }
}
