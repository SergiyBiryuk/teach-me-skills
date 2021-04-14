package task_5;

import java.util.Arrays;

public class Palindrome {

    public static void main(String[] args) {

        long[] mass = {1234567, 343, 54, 2332, 1234554321, 467, 765, 4344, 1239321 };

        System.out.printf("Mass = %s\n", Arrays.toString(mass));

        for(int i = 0; i < mass.length; i++) {

            long num = mass[i];
            byte length = 0;
            byte[] digits = new byte[50];

            for( ; num != 0; num /= 10) {
                digits[length++] = (byte)(num % 10);
            }

            boolean flag = true;
            for(int j = 0; j < length / 2; j++)
                if(digits[j] != digits[length - j - 1]) {
                    flag = false;
                    break;
                }

            if(flag) System.out.print(mass[i] + " ");
        }
        System.out.println();
    }
}
