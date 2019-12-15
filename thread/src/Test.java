public class Test {
    public static void main(String[] args) {
        var ioMatrix = new InOutMatrix();

        var lhs = ioMatrix.load("first_matrix.txt");
        var rhs = ioMatrix.load("second_matrix.txt");

        int poolSize = 8;
        if (args.length != 0) {
            poolSize = Integer.parseInt(args[0]);
        }

        var mp = new MatrixProduct(lhs, rhs, poolSize);
        long start = System.currentTimeMillis();
        var parallel_product = mp.parallelMultiply();
        System.out.println(System.currentTimeMillis() - start);
        ioMatrix.print(parallel_product, "matrix_product.txt");
    }
}