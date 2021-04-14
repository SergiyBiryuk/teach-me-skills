package task_1;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class IncrMatrix {

    private static final int N = 15, M = 20;
    private static final Random rand = new Random(new Date().getTime());

    public static void main(String[] args) {

        int[][] matrix = new int[rand.nextInt(N) + 1][];
        int counter = 0;

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new int[rand.nextInt(M) + 1];
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = ++counter;
            }
            System.out.printf("%d: %s\n", i + 1, Arrays.toString(matrix[i]));
        }
    }
}
