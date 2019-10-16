import java.util.*;

public class Tags {
    List<String> tags;

    public Tags() {
        this(new ArrayList<>());
    }

    public Tags(List<String> tags) {
        this.tags = tags;
    }

    public void addTag(String tag) {
        tags.add(tag);
    }

    public Tags sorted() {
        List<String> sortedTags = tags;
        sortedTags.sort(Comparator.comparingInt(String::length));
        return new Tags(sortedTags);
    }

    public Tags unique() {
        Set<String> uniqueTags = new HashSet<>(tags);
        return new Tags(new ArrayList<String>(uniqueTags));
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        for (var tag : tags) {
            sb.append(tag);
            sb.append("\n");
        }
        return sb.toString();
    }
}
