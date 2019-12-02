import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger implements ILogger, AutoCloseable {
    private FileWriter writer;

    public Logger(String fileName){
        try {
            writer = new FileWriter(fileName, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void log(String message) {
        try {
            if (writer != null) {
                var sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss ");
                String date = sdf.format(new Date());
                writer.write(String.format("%s%s%s", date, message, "\r\n"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        writer.close();
    }
}