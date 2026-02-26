package util;

import java.util.Scanner;

public class InputUtil {
    public static int readInt(String message, Scanner scanner){
        System.out.print(message);
        int value = scanner.nextInt();
        scanner.nextLine();

        return value;
    }

    public static String readString(String message, Scanner scanner){
        System.out.print(message);
        return scanner.nextLine();
    }
}
