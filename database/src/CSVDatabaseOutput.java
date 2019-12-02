import java.io.FileWriter;
import java.io.IOException;

public class CSVDatabaseOutput<T extends CSVFormatEntry>
        implements DatabaseOutput<T> {
    private ILogger logger;

    CSVDatabaseOutput(ILogger logger) {
        this.logger = logger;
    }

    @Override
    public void write(String fileName, Database<T> database) {
        try (var fw = new FileWriter(fileName, false)) {
            for (var entry : database) {
                fw.write(entry.toCSVString() + "\n");
            }
        } catch (IOException e) {
            logger.log(String.format("%s%s%s",
                    "CSVDatabaseOutput: ",
                    "output: ",
                    "ERROR: failed to write to file")
            );
        }
    }
}
