package util;

import java.util.Random;
import java.util.Scanner;

public class Utility {
    static Scanner scanner = new Scanner(System.in);

    private static String getRandomCode() {
        Random random = new Random();
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int digit = random.nextInt(10);
            code.append(digit);
        }
        return code.toString();
    }
    public static void generateRandomCode() {
        while (true) {
            String randomCode = getRandomCode();
            System.out.println(randomCode);
            System.out.println("enter random code: ");
            String randomCode1 = scanner.nextLine();
            if (!(randomCode1.equals(randomCode))) {
                System.out.println("wrong code");
            } else {
                break;
            }
        }
    }
}
