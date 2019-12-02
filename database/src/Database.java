import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Database<T> implements Iterable<T> {
    private List<T> data = new ArrayList<>();
    private DatabaseLoader<T> loader;
    private DatabaseOutput<T> output;
    private ILogger logger;
    private Supplier<T> supplier;


    public Database(DatabaseLoader<T> loader,
                    DatabaseOutput<T> output,
                    Supplier<T> supplier,
                    ILogger logger) {
        this.loader = loader;
        this.output = output;
        this.supplier = supplier;
        this.logger = logger;
    }

    public T get(int index) {
        try {
            return data.get(index);
        } catch (ArrayIndexOutOfBoundsException e) {
            logging("get",
                    "ERROR: Index is out of bounds"
            );
            return null;
        }
    }


    public int size() {
        return data.size();
    }


    public void load(String fileName) {
        logging("load",
                "loading database...");

        data = loader.load(fileName);

        logging("load",
                String.format(
                        "%s%d%s",
                        "completed. ",
                        size(),
                        " entries uploaded"
                )
        );
    }


    public Database<T> sortBy(Comparator<? super T> comparator, String fieldName) {
        logging("sortBy",
                String.format(
                        "%s%s%c",
                        "request: group by field \"",
                        fieldName,
                        '"'
                )
        );

        Database<T> sorted = new Database<>(loader, output,
                supplier, logger);

        sorted.data = data
                .stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        return sorted;
    }

    public void write(String fileName) {
        logging("write", "writing database to file");

        output.write(fileName, this);

        logging("write",
                String.format(
                        "%s%d%s",
                        "completed. ",
                        size(),
                        " entries written"
                )
        );
    }

    void logging(String methodName, String message) {
        logger.log(
                String.format(
                        "%s%s%s%s",
                        "database: ",
                        methodName,
                        ": ",
                        message
                )
        );
    }

    @Override
    public Iterator<T> iterator() {
        return new DatabaseIterator<>(this);
    }
}
