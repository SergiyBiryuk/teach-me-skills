package task_1;

public class AgeChecking {

    private static final int LOW_AGE = 18,
            HIGH_AGE = 74;

    public static void checkAge(final int age) {

        System.out.printf("Age = %d : ", age);

        if(age >= LOW_AGE && age <= HIGH_AGE)
            System.out.println("ACCESS GRANTED!");
        else
            System.out.println("ACCESS DENIED!");
    }

    public static void main(String[] args) {

        checkAge(15);
        checkAge(18);
        checkAge(36);
        checkAge(74);
        checkAge(80);
    }
}
