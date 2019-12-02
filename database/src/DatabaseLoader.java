import java.util.List;

public interface DatabaseLoader<T> {
    List<T> load(String fileName);
}
