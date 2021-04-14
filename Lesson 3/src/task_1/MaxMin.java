package task_1;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class MaxMin {

    private final static Random rand = new Random(new Date().getTime());
    private final static int SIZE = 20,
            LIMIT = 1000;

    public static void main(String[] args) {

        long[] mass = new long[SIZE];

        for (int i = 0; i < SIZE; i++)
            mass[i] = Math.abs(rand.nextLong() % LIMIT);
        System.out.printf("Mass = %s\n", Arrays.toString(mass));

        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;

        for(long i : mass) {
            if(max < i) max = i;
            if(min > i) min = i;
        }

        System.out.printf("MIN = %d\n", min);
        System.out.printf("MAX = %d\n", max);
    }
}
