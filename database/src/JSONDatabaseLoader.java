import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JSONDatabaseLoader<T> implements DatabaseLoader<T> {
    private Parser<T> parser;
    private ILogger logger;

    JSONDatabaseLoader(Parser<T> parser, ILogger logger) {
        this.parser = parser;
        this.logger = logger;
    }

    @Override
    public List<T> load(String fileName) {
        List<T> data = new ArrayList<>();
        try (var fr = new FileReader(fileName)) {
            var sc = new Scanner(fr);
            sc.nextLine();
            while (sc.hasNext()) {
                var line = sc.nextLine();
                if (!line.equals("]")) {
                    data.add(parser.parse(line));
                }
            }
        } catch (IOException e) {
            logger.log(
                    String.format(
                            "%s%s%s",
                            "JSONDatabaseLoader: ",
                            "load: ",
                            "ERROR: failed to load data from file"
                    )
            );
        }
        return data;
    }

}
