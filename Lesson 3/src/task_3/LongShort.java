package task_3;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class LongShort {

    private final static Random rand = new Random(new Date().getTime());
    private final static int SIZE = 20,
            LIMIT = 100000;

    public static void main(String[] args) {

        long[] mass = new long[SIZE];

        for (int i = 0; i < SIZE; i++)
            mass[i] = Math.abs(rand.nextLong() % (LIMIT / (i + 1) / SIZE)); // Для разнообразия размеров
        System.out.printf("Mass = %s\n", Arrays.toString(mass));

        int longId = 0, shortId = 0;
        int longSize = Integer.MIN_VALUE, shortSize = Integer.MAX_VALUE;

        for(int i = 0; i < SIZE; i++) {

            int count = 0;
            long n = mass[i];

            for( ; n != 0; n /= 10) count++;

            if(longSize < count) {
                longSize = count;
                longId = i;
            }
            if(shortSize > count) {
                shortSize = count;
                shortId = i;
            }
        }

        System.out.printf("First shortest: mass[%d] = %d\n", shortId, mass[shortId]);
        System.out.printf("First longest: mass[%d] = %d\n", longId, mass[longId]);
    }
}
