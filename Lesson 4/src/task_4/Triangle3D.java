package task_4;

public class Triangle3D {

    private static final int N = 8, M = 10;

    public static void main(String[] args) {

        int[][][] mass = new int[N][M][M];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                for (int k = 0; k < j + 1; k++)
                    mass[i][j][i % 2 == 0 ? k : mass[i][j].length - k - 1] = 1;

        for(int j = 0; j < M; j++) {
            for(int i = 0; i < N; i++) {
                for(int k = 0; k < M; k++)
                    System.out.print(mass[i][j][k] + " ");
                System.out.print("| ");
            }
            System.out.println();
        }
    }
}
