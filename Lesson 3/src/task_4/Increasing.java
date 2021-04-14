package task_4;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class Increasing {

    private final static Random rand = new Random(new Date().getTime());
    private final static int SIZE = 20,
            LIMIT = 1000;

    public static void main(String[] args) {

        long[] mass = new long[SIZE];

        for (int i = 0; i < SIZE; i++)
            mass[i] = Math.abs(rand.nextLong() % LIMIT);
        System.out.printf("Mass = %s \n", Arrays.toString(mass));

        for(int i = 0; i < SIZE - 1; i++) {
            if(mass[i] < mass[i+1]) {
                while(i < SIZE - 1 && mass[i] < mass[i+1])
                    System.out.print(mass[i++] + " ");
                System.out.print(mass[i] + " ");
            }
        }
        System.out.println();
    }
}
