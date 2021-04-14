package task_2;

public class MaxMin {

    public static void main(String[] args) {

        long n = 345678672435876543L;

        byte min = 9,
                max = 0;

        while(n != 0) {
            byte z = (byte)(n % 10);
            if(min > z) min = z;
            if(max < z) max = z;
            n /= 10;
        }

        System.out.println("Min = " + min);
        System.out.println("Max = " + max);
    }
}
