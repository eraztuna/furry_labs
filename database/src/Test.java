import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        try (var logger = new Logger("logfile.txt")) {
            logger.log("application launch");

            var humanCSVDatabase = new Database<Human>(
                    new CSVDatabaseLoader<>(
                            logger,
                            new CSVParser<>(Human::new)
                    ),
                    new CSVDatabaseOutput<>(logger),
                    Human::new,
                    logger
            );
            humanCSVDatabase.load("data.csv");
            humanCSVDatabase
                    .sortBy(Comparator.comparing(Human::getState), "state")
                    .write("sortedCSVByState.csv");

            var humanJsonDatabase = new Database<Human>(
                    new JSONDatabaseLoader<>(
                            new JSONParser<>(Human::new),
                            logger
                    ),
                    new CSVDatabaseOutput<>(logger),
                    Human::new,
                    logger
            );
            humanJsonDatabase.load("data1.json");
            humanJsonDatabase
                    .sortBy(Comparator.comparing(Human::getState), "state")
                    .write("sortedJsonByState.csv");
            logger.log(String.format("%s", "application termination\n"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
