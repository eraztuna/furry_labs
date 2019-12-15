public class Matrix {
    private double[][] data;

    Matrix(int rows, int cols) {
        data = new double[rows][cols];
    }

    public Matrix transpose() {
        var transposed = new Matrix(data.length, data[0].length);
        int i = 0;

        for (var vector : data) {
            transposed.setCol(i++, vector);
        }

        return transposed;
    }

    public void setRow(int row, double[] vector) {
        System.arraycopy(vector, 0, data[row], 0, vector.length);
    }

    public void setCol(int col, double[] vector) {
        for (int i = 0; i < vector.length; i++) {
            data[i][col] = vector[i];
        }
    }

    double[] get(int index) {
        return data[index];
    }
}
