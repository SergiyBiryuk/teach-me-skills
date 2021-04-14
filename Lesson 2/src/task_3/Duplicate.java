package task_3;

public class Duplicate {

    public static void main(String[] args) {

        boolean flag = false;
        long n = 1234567890L;

        while(n != 0) {
            byte x = (byte)(n % 10);
            long m = n / 10;

            while(m != 0) {
                byte y = (byte)(m % 10);
                if(x == y) {
                    flag = true;
                    break;
                }
                m /= 10;
            }

            if(flag) break;
            n /= 10;
        }

        System.out.println(flag);
    }
}
