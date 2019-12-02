import java.util.Iterator;

class DatabaseIterator<T> implements Iterator<T> {
    private Database<T> database;
    private int position;

    DatabaseIterator(Database<T> database) {
        this(database, 0);
    }

    DatabaseIterator(Database<T> database, int position) {
        this.database = database;
        this.position = position;
    }
    @Override
    public boolean hasNext() {
        return (position < database.size());
    }

    @Override
    public T next() {
        return database.get(position++);
    }
}
