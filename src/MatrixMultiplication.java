import java.util.Date;

/**
 * Normal way to do matrix multiplication.
 *
 * @author JavaProgramTo.com
 *
 */
public class MatrixMultiplication {

    public static void main(String[] args) {

        Date start = new Date();

        int[][] m1 = MatrixGeneratorUtil.generateMatrix(3, 3);
        int[][] m2 = MatrixGeneratorUtil.generateMatrix(3, 3);

        int[][] result = multiply(m1, m2);

        System.out.println("Matrix 1 : ");
        MatrixGeneratorUtil.print(m1);

        System.out.println("\nMatrix 2 : ");
        MatrixGeneratorUtil.print(m2);

        System.out.println("\nOutput Matrix : ");
        MatrixGeneratorUtil.print(result);

        Date end = new Date();
        System.out.println("\nTime taken in milli seconds: " + (end.getTime() - start.getTime()));

    }

    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {
        int resultRows = matrix1.length;
        int resultColumns = matrix2[0].length;
        int commonRows = matrix1[0].length;

        int[][] result = new int[resultRows][resultColumns];

        for (int i = 0; i < resultRows; i++) {
            for (int j = 0; j < resultColumns; j++) {
                result[i][j] = 0;
                for (int k = 0; k < commonRows; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;

    }

    public static boolean equals(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length && matrix1[0].length != matrix2[0].length) {
            return false;
        }

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}