public class Main {

    public static void main(String[] args) {

        double[][] matrix1 = {
                {1, 2},
                {3, 4}
        };

        double[][] matrix2 = {
                {0, 5},
                {6, 7}
        };

        Matrix m1 = new Matrix(matrix1);
        Matrix m2 = new Matrix(matrix2);

        System.out.println(Matrix.kronecker(m1, m2));

    }

}
