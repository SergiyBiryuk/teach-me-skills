package task_2;

public class MaxMin {

    int max = Integer.MIN_VALUE,
            min = Integer.MAX_VALUE;
    final int [] array;

    public MaxMin(final int[] array) {
        this.array = array;
        countMaxMin();
    }

    public int getMax() {
        return max;
    }
    public int getMin() {
        return min;
    }

    private void countMaxMin() {
        for(int i : array) {
            if(max < i) max = i;
            if(min > i) min = i;
        }
    }
}
