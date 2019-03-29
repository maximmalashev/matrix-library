public class Matrix {

    public Matrix(double[][] values) {

        if (values == null) throw new EmptyMatrixException();

        this.rows = values.length;
        this.cols = values[0].length;

        this.values = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.values[i][j] = values[i][j];
            }
        }
    }

    private int rows;
    private int cols;

    private double[][] values;

    public static Matrix add(Matrix m1, Matrix m2) {

        if (m1.cols != m2.cols || m1.rows != m2.rows) {
            throw new MatrixDimensionMismatchException();
        }

        double[][] newValues = m1.generateArray();

        for (int i = 0; i < newValues.length; i++) {
            for (int j = 0; j < newValues[0].length; j++) {
                newValues[i][j] += m2.getValue(i, j);
            }
        }

        return new Matrix(newValues);
    }

    public static Matrix scale(double multiplier, Matrix m) {

        double[][] newValues = m.generateArray();

        for (int i = 0; i < newValues.length; i++) {
            for (int j = 0; j < newValues[0].length; j++) {
                newValues[i][j] *= multiplier;
            }
        }

        return new Matrix(newValues);
    }

    public static Matrix transpose(Matrix m) {

        double[][] newValues = new double[m.cols][m.rows];

        for (int i = 0; i < newValues.length; i++) {
            for (int j = 0; j < newValues[0].length; j++) {
                newValues[i][j] = m.getValue(j, i) ;
            }
        }

        return new Matrix(newValues);
    }

    public static Matrix multiply(Matrix m1, Matrix m2) {

        if (m1.cols != m2.rows) throw new MatrixMultiplicationMismatchException();

        double[][] newValues = new double[m1.rows][m2.cols];

        for (int i = 0; i < newValues.length; i++) {
            for (int j = 0; j < newValues[i].length; j++) {
                newValues[i][j] = 0;
                for (int k = 0; k < newValues.length; k++) {
                    newValues[i][j] += m1.getValue(i, k) * m2.getValue(k, j);
                }
            }
        }

        return new Matrix(newValues);
    }

    public Matrix addRow(int row, int to) {

        // TODO: check for invalid row index

        for (int i = 0; i < cols; i++) {
            values[to][i] += values[row][i];
        }

        return this;
    }

    public Matrix multiplyRow(int row, double multiplier) {

        // TODO: check for invalid row index

        for (int i = 0; i < cols; i++) {
            values[row][i] *= multiplier;
        }

        return this;
    }

    public Matrix switchRows(int row1, int row2) {

        // TODO: check for invalid row index

        for (int i = 0; i < cols; i++) {
            double tmp = values[row1][i];
            values[row1][i] = values[row2][i];
            values[row2][i] = tmp;
        }

        return this;
    }

    public static Matrix hadamard(Matrix m1, Matrix m2)
    {
        if (m1.cols != m2.cols || m1.rows != m2.rows) {
            throw new MatrixDimensionMismatchException();
        }

        double[][] newValues = m1.generateArray();

        for (int i = 0; i < newValues.length; i++) {
            for (int j = 0; j < newValues[0].length; j++) {
                newValues[i][j] *= m2.getValue(i, j);
            }
        }

        return new Matrix(newValues);
    }

    public static Matrix kronecker(Matrix m1, Matrix m2) {

        double[][] newValues = new double[m1.rows * m2.rows][m1.cols * m2.cols];

        for (int i = 0; i < m1.rows; i++) {
            for (int j = 0; j < m1.cols; j++) {
                double[][] tmp = scale(m1.getValue(i, j), m2).generateArray();
                for (int k = 0; k < tmp.length; k++) {
                    for (int l = 0; l < tmp[k].length; l++) {
                        newValues[tmp.length * i + k][tmp[k].length * j + l] = tmp[k][l];
                    }
                }
            }
        }

        return new Matrix(newValues);
    }


    public double getValue(int row, int col) {

        return values[row][col];

    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    @Override
    public String toString() {

        String s = "";

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                s += values[i][j] + " ";
            }
            s += '\n';
        }

        return s;
    }

    private double[][] generateArray() {

        double[][] array = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = values[i][j];
            }
        }

        return array;
    }

}
