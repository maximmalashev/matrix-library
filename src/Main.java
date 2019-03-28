public class Main {

    public static void main(String[] args) {

        double[][] matrix1 = {
                {1, 2},
                {0, 1},
                {2, 7}
        };

        double[][] matrix2 = {
                {2, 5, 5},
                {6, 7, 8},
                {1, 2, 1}
        };

        Matrix m1 = new Matrix(matrix1);
        Matrix m2 = new Matrix(matrix2);

        System.out.println(m1.switchRows(0, 1));

    }

}
