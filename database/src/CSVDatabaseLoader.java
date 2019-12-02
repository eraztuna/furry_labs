import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CSVDatabaseLoader<T extends Entry>
        implements DatabaseLoader<T> {
    private ILogger logger;
    private CSVParser<T> parser;

    CSVDatabaseLoader(ILogger logger, CSVParser<T> parser) {
        this.logger = logger;
        this.parser = parser;
    }

    @Override
    public List<T> load(String fileName) {
        List<T> data = new ArrayList<>();
        try (var fr = new FileReader(fileName)) {
            var sc = new Scanner(fr);
            var fieldsNames = Arrays.asList(sc.nextLine().split(";"));
            parser.setFieldsNames(fieldsNames);
            while (sc.hasNext()) {
                data.add(parser.parse(sc.nextLine()));
            }
        } catch (IOException e) {
            logger.log(String.format("%s%s%s",
                    "CSVDatabaseLoader: ",
                    "load: ",
                    "ERROR: failed to load data from file")
            );
        }
        return data;
    }
}
