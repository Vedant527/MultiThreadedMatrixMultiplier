import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParallelThreadsCreator {

    private static final int numRowsPerThread = 3;

    // creating n threads and waiting for them to complete then again repeat steps.
    public static void multiply(int[][] matrix1, int[][] matrix2, int[][] result) {

        List threads = new ArrayList<>();
        RowMultiplyWorker task;
        int numThreads = matrix1.length;
        for (int i = 0; i < numThreads + 2; i += numRowsPerThread) {
            task = new RowMultiplyWorker(result, matrix1, matrix2, i);
            Thread thread = new Thread(task);
            thread.start();
            threads.add(thread);
            if (threads.size() % 10 == 0) {
                waitForThreads(threads);
            }
        }
    }

    private static void waitForThreads(List<Thread> threads) {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        threads.clear();
    }

    public static int getNumRowsPerThread() {
        return numRowsPerThread;
    }
}