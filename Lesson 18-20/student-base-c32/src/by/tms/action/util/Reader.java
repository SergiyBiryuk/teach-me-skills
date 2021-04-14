package by.tms.action.util;

import java.util.Scanner;

public class Reader {

    public static String readLine() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if (line.isEmpty()) {
            Writer.write("Was entered empty string,try again!");
            return null;
        }
        return line;
    }

    public static long readId() {
        while (true) {
            try {

                // FIXME: 5/27/20
                Writer.writeln("Input Student ID: ");
                long id = Long.parseLong(readLine());
                if (id < 0) throw new NumberFormatException();
                return id;
            } catch (NumberFormatException e) {
                Writer.write("Id incorrect! Try again!");
            }
        }
    }

    public static int readMenuChoice() {
        while (true) {
            try {
                int input = Integer.parseInt(readLine());
                if (input < 0) throw new NumberFormatException();
                return input;
            } catch (NumberFormatException e) {
                return -1;
            }
        }
    }
}
