import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {
    private List<String> text;

    public Text() {
        text = new ArrayList<>();
    }

    public Text(List<String> text) {
        this.text = text;
    }

    public void addLine(String line) {
        text.add(line);
    }

    public List<String> getText() {
        return text;
    }

    public Text removeTags() {
        Text cleanText = new Text();

        Pattern tagsPattern = Pattern.compile("(<[^>]*>)");

        for (var line : text) {
            Matcher tagsMatcher = tagsPattern.matcher(line);
            cleanText.addLine(tagsMatcher.replaceAll(""));
        }

        return cleanText;
    }

    public Integer findFragment(String fragment) {
        int lineNumber = -1;

        var cleanText = removeTags();
        for (int i = 0; i < cleanText.getText().size(); i++) {
            if (cleanText.getText()
                    .get(i).contains(fragment)) {
                lineNumber = i;
                break;
            }
        }

        return lineNumber;
    }

    public Tags getTags() {
        Tags tags = new Tags();

        Pattern openTagsPattern = Pattern.compile("(<[^/][^>]*>)");

        for (var line : text) {
            Matcher openTagsMatcher = openTagsPattern.matcher(line);
            while (openTagsMatcher.find()) {
                tags.addTag(
                        line.substring(openTagsMatcher.start(),
                                openTagsMatcher.end())
                );
            }
        }
        return tags.sorted();
    }
}
