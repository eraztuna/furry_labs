import java.util.concurrent.*;

class MatrixProduct {
    private double[][] lhs;
    private double[][] rhs;
    private ExecutorService es;

    MatrixProduct(double[][] lhs, double[][] rhs, int poolSize) {
        this.lhs = lhs;
        this.rhs = transpose(rhs);
        es = Executors.newFixedThreadPool(poolSize);
    }

    double[][] parallelMultiply() {
        int rows = lhs.length;
        int cols = rhs[0].length;
        double[][] answer = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            int fi = i;
            es.execute(() -> {
                for (int j = 0; j < cols; j++) {
                    answer[fi][j] = scalarProduct(fi, j);
                }
            });
        }
        es.shutdown();
        try {
            es.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return answer;
    }

    double[][] multiply() {
        int rows = lhs.length;
        int cols = rhs[0].length;
        double[][] answer = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                answer[i][j] = scalarProduct(i, j);
            }
        }
        return answer;
    }

    private double scalarProduct(int lInd, int rInd) {
        double scalar = 0;

        for (int k = 0; k < rhs.length; k++) {
            scalar += lhs[lInd][k] * rhs[rInd][k];
        }
        return scalar;
    }

    private double[][] transpose(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] transposed = new double[rows][cols];

        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                transposed[j][i] = matrix[i][j];
            }
        }

        return transposed;
    }
}
