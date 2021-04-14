package task_1;

public class StaticMaxMin {

    public static int max(int... array) {
        int max = Integer.MIN_VALUE;
        for (int elem : array)
            if (max < elem)
                max = elem;
        return max;
    }

    public static int min(int... array) {
        int min = Integer.MAX_VALUE;
        for (int elem : array)
            if (min > elem)
                min = elem;
        return min;
    }

}
