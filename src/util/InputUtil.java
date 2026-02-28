package util;

import java.util.Scanner;
import exceptions.InvalidInputException;

public class InputUtil {
    public static int readInt(String message, Scanner scanner) throws InvalidInputException {
    System.out.print(message);
    
    if (!scanner.hasNextInt()) {
        scanner.nextLine(); // clear invalid input
        throw new InvalidInputException("Invalid input: expected an integer.");
    }
    
    int value = scanner.nextInt();
    scanner.nextLine();
    return value;
}

    public static String readString(String message, Scanner scanner){
        System.out.print(message);
        return scanner.nextLine();
    }
}
