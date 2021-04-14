package task_4;

import java.util.Random;

public class Decrease {

    public static void main(String[] args) {

        byte left = 0, middle = 0, right = 0;
        // Generate random positive long number
        long n = Math.abs(new Random().nextLong());
        System.out.println("N = " + n);

        while(n != 0) {
            left = (byte)(n % 10);
            if(left + 1 == middle || middle + 1 == right)
                System.out.print(middle);
            right = middle;
            middle = left;
            n /= 10;
        }

        if(middle + 1 == right)
            System.out.print(middle);
        System.out.println();
    }
}
