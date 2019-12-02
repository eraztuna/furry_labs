public interface DatabaseOutput<T> {
    void write(String fileName, Database<T> database);
}
