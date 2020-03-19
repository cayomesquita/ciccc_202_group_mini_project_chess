package ca.ciccc.chess.input;

import java.util.Scanner;

public class InputController {

    public static String input() {

        System.out.println("\nWelcome to the Chess Game");

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter UCI (Type 'help' for help): ");
        while (true) {
            String input = scan.nextLine();
            if (input == "help") {
                return input;
            }
            if (input.length() == 4) {
                if (input.charAt(0) >= 'A' && input.charAt(0) <= 'H' &&
                        input.charAt(0) >= 'a' && input.charAt(0) <= 'h' && input.charAt(1) >= '1' && input.charAt(1) <= '8' &&
                        input.charAt(2) >= 'A' && input.charAt(2) <= 'H' && input.charAt(2) >= 'a' && input.charAt(2) <= 'h' &&
                        input.charAt(3) >= '1' && input.charAt(3) <= '8')
                    return input;
            }
            System.out.println("Invalid input, please try again");
        }
    }
}
