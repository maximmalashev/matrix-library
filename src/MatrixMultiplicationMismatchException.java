public class MatrixMultiplicationMismatchException extends RuntimeException {

    public MatrixMultiplicationMismatchException() {

        super("Number of cols in the first matrix does not equal to number of rows in the second matrix");

    }
}
