import task_1.StaticMaxMin;
import task_2.MaxMin;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class Main {

    private static final int LIMIT = 100;
    private static final Random rand = new Random(new Date().getTime());

    public static void main(String[] args) {

        int[] array = new int[rand.nextInt(LIMIT) + 1];
        for(int i = 0; i < array.length; i++)
            array[i] = rand.nextInt() % LIMIT;
        System.out.println(Arrays.toString(array));
        System.out.println();

        System.out.println("Max = " + StaticMaxMin.max(array));
        System.out.println("Min = " + StaticMaxMin.min(array));
        System.out.println();

        MaxMin m = new MaxMin(array);
        System.out.println("Max = " + m.getMax());
        System.out.println("Min = " + m.getMin());
    }
}
