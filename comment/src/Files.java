import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Files {
    public void filesFromFolder(File folder) throws IOException {
        File[] folderElement = folder.listFiles();
        assert folderElement != null;
        for (var element : folderElement) {
            if (element.isDirectory()) {
                filesFromFolder(element);
            }
            UpdateFile(element);
        }
    }

    public void UpdateFile(File file) throws IOException {
        var code = new Code();
        String line;

        var in = new Scanner(new File(file.getPath()));
        try(in) {
            while (in.hasNext()) {
                code.addLine(in.nextLine());
            }
        }
        in.close();

        var cleanCodeRegex = code.removeCommentsRegex();
        var out =  new BufferedWriter(new FileWriter(file.getPath()));
        out.write(cleanCodeRegex.toString());
        out.flush();
        out.close();
    }
}
