package task_2;

import java.util.Arrays;

public class Triangle {

    private static final int N = 10;

    public static void main(String[] args) {

        int[][] matrix = new int[N][N];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < i + 1; j++)
                matrix[i][j] = 1;

        for (int[] mass : matrix)
            System.out.println(Arrays.toString(mass));
    }
}
