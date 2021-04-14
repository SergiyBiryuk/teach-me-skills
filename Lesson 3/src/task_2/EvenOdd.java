package task_2;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class EvenOdd {

    private final static Random rand = new Random(new Date().getTime());
    private final static int SIZE = 20,
            LIMIT = 1000;

    public static void main(String[] args) {

        long[] mass = new long[SIZE];

        for (int i = 0; i < SIZE; i++)
            mass[i] = Math.abs(rand.nextLong() % LIMIT);
        System.out.printf("Mass = %s\n", Arrays.toString(mass));

        System.out.print("Even: ");
        for(long i : mass)
            if(i % 2 == 0)
                System.out.printf("%d ", i);
        System.out.println();

        System.out.print("Odd: ");
        for(long i : mass)
            if(i % 2 != 0)
                System.out.printf("%d ", i);
        System.out.println();

    }
}
