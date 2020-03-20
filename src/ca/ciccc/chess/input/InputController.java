package ca.ciccc.chess.input;

import ca.ciccc.chess.movement.Movement;
import ca.ciccc.chess.piece.Position;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputController {

    private final static Scanner scan = new Scanner(System.in);
    private final static String helpmessage = "* type 'help' for help\n" +
            "* type 'board' to see board again\n" +
            "* type 'resign' to resign\n" +
            "* type 'moves' to list all possible moves\n" +
            "* type a square (e.g. b1, e2) to list possible moves for that square\n" +
            "* type UCI (e.g. b1c3, e7e8q) to make a move";

    private final static String startmessage = "Enter UCI (Type 'help' for help): ";
    public static final int SQUARE_INPUT_LENGTH = 2;
    public static final int UCI_MOVE_INPUT_LENGTH = 4;
    public static final String BLACK = "Black";
    public static final String WHITE = "White";

    public static Command inputMenu() throws Exception {
        while (true) {
            System.out.print(startmessage);
            String input = scan.nextLine();
            if (Command.CMD_HELP.equals(input)) {
                System.out.println(helpmessage);
                continue;
            }
            if (Command.CMD_BOARD.equals(input) || Command.CMD_RESIGN.equals(input) || Command.CMD_MOVES.equals(input)) {
                return new Command(input);
            }
            if (isSquare(input)) {
                char[] arr = input.toCharArray();
                int index = 0;
                return new Command(Command.CMD_SQUARE, Position.parseBoardPosition(arr[index++], arr[index]));
            }
            if (isUCIMove(input)) {
                return new Command(Command.CMD_UCI_MOVE, Movement.getMovement(input));
            }
            System.out.println("Invalid input, please try again");
        }

    }

    private static boolean isUCIMove(String input) {
        if (input != null && input.length() == UCI_MOVE_INPUT_LENGTH) {
            char[] charArr = input.toCharArray();
            int index = 0;
            return isValidLetter(charArr[index++]) && isValidDigit(charArr[index++]) &&
                    isValidLetter(charArr[index++]) && isValidDigit(charArr[index]);
        }
        return false;
    }

    private static boolean isSquare(String input) {
        if (input != null && input.length() == SQUARE_INPUT_LENGTH) {
            char[] charArr = input.toCharArray();
            int index = 0;
            return isValidLetter(charArr[index++]) && isValidDigit(charArr[index]);
        }
        return false;
    }

    private static boolean isValidDigit(char c) {
        return c >= '1' && c <= '8';
    }

    private static boolean isValidLetter(char c) {
        return c >= 'a' && c <= 'h';
    }

    public static void printWelcome() {
        System.out.println("\nWelcome to the Chess Game\n");
    }

    public static void printTurn(boolean whitePlayer) {
        System.out.printf("%s to move\n", whitePlayer ? WHITE : BLACK);
    }

    public static void printWinnerByResignation(boolean whitePlayer) {
        System.out.printf("Game over - %s won by resignation!\n", whitePlayer ? WHITE : BLACK);
    }

    public static void printWinner(boolean whitePlayer) {
        System.out.printf("Game over - %s won!\n", whitePlayer ? WHITE : BLACK);
    }

    public static void close() {
        if (scan != null) {
            scan.close();
        }
    }

    public static void printNoPiecePosition(Position position) {
        System.out.println("No piece in this position");
    }

    public static void printAllPossibleMovements(Set<Movement> movements) {
        if (movements.isEmpty()) {
            System.out.println("No possible movements!");
        } else {
            System.out.println(movements.stream()
                    .map(movement -> movement.toString())
                    .collect(Collectors.joining(", ", "[", "]")));

        }
    }

    public static void printPieceOtherPlayer() {
        System.out.println("Chose your (Color) piece!");
    }

    public static void printInvalidMovement() {
        System.out.println("Invalid movement!");
    }
}