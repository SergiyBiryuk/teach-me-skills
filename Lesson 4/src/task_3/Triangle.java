package task_3;

public class Triangle {

    private static final int N = 10;

    public static void main(String[] args) {

        int[][] matrix = new int[N][N];

        for(int i = 0; i < matrix.length; i++) {
            System.out.printf("%02d: ", i + 1);
            for (int j = 0; j < i + 1; j++) {
                matrix[i][j] = 1;
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
