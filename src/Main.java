import java.util.Date;

/**
 * Normal way to do matrix multiplication.
 *
 * @author JavaProgramTo.com
 *
 */
public class Main {

    public static void main(String[] args) {


        int[][] m1 = MatrixGeneratorUtil.generateMatrix(7000, 7000);
        int[][] m2 = MatrixGeneratorUtil.generateMatrix(7000, 76);

        int[][] result_multithreaded = new int[m1.length][m2[0].length];
        Date start = new Date();
        ParallelThreadsCreator.multiply(m1, m2, result_multithreaded);
        Date end = new Date();
        System.out.println("\nTime taken in milli seconds with multithreading: " + (end.getTime() - start.getTime()));

        start = new Date();
        int[][] result_singlethreaded = MatrixMultiplication.multiply(m1, m2);
        end = new Date();
        System.out.println("\nTime taken in milli seconds without multithreading: " + (end.getTime() - start.getTime()));
        System.out.println("Results are equal: " + MatrixMultiplication.equals(result_multithreaded, result_singlethreaded));


    }

}