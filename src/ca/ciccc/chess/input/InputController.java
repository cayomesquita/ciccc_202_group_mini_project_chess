package ca.ciccc.chess.input;

import ca.ciccc.chess.ChessGame;

import java.util.Scanner;

public class InputController {

    public static String input() {

        String helpmessage = "* type 'help' for help\n" +
                "* type 'board' to see board again\n" +
                "* type 'resign' to resign\n" +
                "* type 'moves' to list all possible moves\n" +
                "* type a square (e.g. b1, e2) to list possible moves for that square\n" +
                "* type UCI (e.g. b1c3, e7e8q) to make a move";
        String startmessage = "Enter UCI (Type 'help' for help): ";

        System.out.println("\nWelcome to the Chess Game");

        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print(startmessage);
            String input = scan.nextLine();
            if (input.equals("help")) {
                System.out.println(helpmessage);
                continue;
            }
            if (input.length() == 4) {
                if (input.charAt(0) >= 'A' && input.charAt(0) <= 'H' &&
                        input.charAt(0) >= 'a' && input.charAt(0) <= 'h' && input.charAt(1) >= '1' && input.charAt(1) <= '8' &&
                        input.charAt(2) >= 'A' && input.charAt(2) <= 'H' && input.charAt(2) >= 'a' && input.charAt(2) <= 'h' &&
                        input.charAt(3) >= '1' && input.charAt(3) <= '8')
                    return input;
            }
            if (input.equals("board")) {
                System.out.println("Function to Print a New Board");
                continue;
            }
            if (input.equals("resign")) {
                System.out.println("GAME OVER! Won by Resignation");
                continue;

            }
            if (input.equals("moves")) {
                System.out.println("Function to show possible moves");
                continue;
            }
            System.out.println("Invalid input, please try again");
        }
    }
}