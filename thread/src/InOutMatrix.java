import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InOutMatrix {

    double[][] load(String fileName) {
        List<List<Double>> matrix = new ArrayList<>();

        try (var fr = new FileReader(fileName)) {
            var fileScanner = new Scanner(fr);
            while (fileScanner.hasNextLine()) {
                var lineScanner = new Scanner(fileScanner.nextLine());
                var row = new ArrayList<Double>();
                while (lineScanner.hasNextDouble()) {
                    row.add(lineScanner.nextDouble());
                }
                matrix.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        double[][] ret = new double[matrix.size()][];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = new double[matrix.get(i).size()];
            for (int j = 0; j < ret[i].length; j++) {
                ret[i][j] = matrix.get(i).get(j);
            }
        }

        return ret;
    }

    void print(double[][] matrix, String fileName) {
        try (var fw = new FileWriter(fileName)) {
            for (var row : matrix) {
                for (var elem : row) {
                    fw.write(String.format("%s%s", String.valueOf(elem), ' '));
                }
                fw.write("\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
