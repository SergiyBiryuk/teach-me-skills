package task_5;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class Sorting {

    private static final int N = 15, M = 20, LIMIT = 1000;
    private static final Random rand = new Random(new Date().getTime());

    public static void main(String[] args) {

        int[][] matrix = new int[rand.nextInt(N) + 1][];
        int[] sizes = new int[matrix.length];
        int elNumber = 0;

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new int[rand.nextInt(M) + 1];
            sizes[i] = matrix[i].length;
            elNumber += sizes[i];
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = rand.nextInt(LIMIT);
            }
            System.out.printf("%d: %s\n", i + 1, Arrays.toString(matrix[i]));
        }
        System.out.println();

        // BUBBLE SORT
        for (int i = 0; i < elNumber - 1; i++) {
            for (int j = 0; j < elNumber - i - 1; j++) {

                // COUNTING 'I' AND 'J' FOR FIRST ARGUMENT
                int currSize = sizes[0], currSizeId = 0;
                int aI = 0, aJ = 0;
                while(j / currSize != 0) {
                    currSize += sizes[++currSizeId];
                    aI++;
                }
                aJ = sizes[currSizeId] - (currSize - j);

                // COUNTING 'I' AND 'J' FOR SECOND ARGUMENT
                int bI = 0, bJ = 0;
                currSize = sizes[0]; currSizeId = 0;
                while((j + 1) / currSize != 0) {
                    currSize += sizes[++currSizeId];
                    bI++;
                }
                bJ = sizes[currSizeId] - (currSize - (j + 1));

                // COMPARE
                if(matrix[aI][aJ] > matrix[bI][bJ]) {
                    int temp = matrix[aI][aJ];
                    matrix[aI][aJ] = matrix[bI][bJ];
                    matrix[bI][bJ] = temp;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++)
            System.out.printf("%d: %s\n", i + 1, Arrays.toString(matrix[i]));
    }
}
