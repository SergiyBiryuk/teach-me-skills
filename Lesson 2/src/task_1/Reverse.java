package task_1;

public class Reverse {

    public static void main(String[] args) {

        long n = 1234567890123456789L;

        for( ; n != 0 ; n /= 10 ) {
            System.out.print(n % 10);
        }
    }
}
