package ca.ciccc.chess;

import ca.ciccc.chess.board.BoardController;
import ca.ciccc.chess.input.Command;
import ca.ciccc.chess.input.InputController;
import ca.ciccc.chess.movement.Movement;
import ca.ciccc.chess.piece.*;

import java.util.Set;
import java.util.stream.Collectors;

public class ChessGame {

    private BoardController boardController;
    private boolean running = true;
    private boolean whitePlayer = true;

    public ChessGame() {
        boardController = BoardController.getInstante();
    }

    public void start() throws Exception {
        initialize();
        InputController.printWelcome();
        while (running) {
            InputController.printTurn(whitePlayer);
            Command command = InputController.inputMenu();
            Piece piece = null;
            Position position = null;
            switch (command.getCommand()) {
                case Command.CMD_RESIGN:
                    swiftPlayer();
                    InputController.printWinnerByResignation(whitePlayer);
                    running = false;
                    break;
                case Command.CMD_BOARD:
                    boardController.printBoard();
                    break;
                case Command.CMD_MOVES:
                    InputController.printAllPossibleMovements(boardController.getAllPossibleMovements(whitePlayer));
                    break;
                case Command.CMD_SQUARE:
                    position = (Position) command.getPayload();
                    piece = boardController.getByPosition(position);
                    if (piece == null) {
                        InputController.printNoPiecePosition(position);
                        break;
                    }
                    InputController.printAllPossibleMovements(boardController.getPossibleMovements(position));
                    break;
                case Command.CMD_UCI_MOVE:
                    Movement movement = (Movement) command.getPayload();
                    position = movement.getStarting();
                    piece = boardController.getByPosition(position);
                    if (piece == null) {
                        InputController.printNoPiecePosition(position);
                        break;
                    } else if (piece.getIsWhite() != whitePlayer) {
                        InputController.printPieceOtherPlayer();
                        break;
                    }
                    if (boardController.move(movement)) {
                        swiftPlayer();
                    } else {
                        InputController.printInvalidMovement();
                    }
                    break;
                default:
                    break;
            }
        }
        InputController.close();
    }

    private void initialize() {
        boardController.initialize();
        boardController.printBoard();
        running = true;
        whitePlayer = true;
    }

    private void swiftPlayer() {
        whitePlayer = !whitePlayer;
    }

    //FIXME remove test
    public void startTest() throws Exception {

//        Position position1 = new Position(3, 3);
//        Position position2 = new Position(0, 3);
//        Position position3 = new Position(2, 4);
//        Position position4 = new Position(2, 2);
//        boardController.addPieceTest(new Knight(true), position1)
//                .addPieceTest(new Rook(false), position2)
//                .addPieceTest(new Rook(true), position3)
//                .addPieceTest(new Rook(true), position4);
//        Piece piece = boardController.getByPosition(position1);

        Position position1 = new Position(0, 1);
        Position position2 = new Position(2, 2);
        Position position3 = new Position(1, 1);
        Position position4 = new Position(1, 2);
        boardController.initialize(new King(true), position1)
                .initialize(new King(false), position2)
                .initialize(new King(false), position3)
                .initialize(new King(false), position4);
        Piece piece = boardController.getByPosition(position1);

//        Position position1 = new Position(1, 1);
//        Position position2 = new Position(2, 2);
//        Position position3 = new Position(2, 1);
//        Position position4 = new Position(1, 3);
//        boardController.addPieceTest(new Queen(false), position1)
//                .addPieceTest(new Rook(false), position2)
//                .addPieceTest(new Rook(false), position3)
//                .addPieceTest(new Rook(true), position4);
//        Piece piece = boardController.getByPosition(position1);

        System.out.println(position2);

        Set<Movement> result = boardController.getPossibleMovements(position1);

        System.out.println("You have " + result.size() + " movements to to.");
        System.out.println(result.stream()
                .map(movement -> movement.toString())
                .collect(Collectors.joining(", ", "[", "]")));

        boardController.printBoard();
        InputController.inputMenu();

        Movement movement1 = new Movement(position1, position3);
        System.out.println(boardController.checkmateOrNot(movement1.getArrival()));
        System.out.println(movement1);
        boardController.move(movement1);

        boardController.printBoard();


        // Check if the game is over or not
        if (boardController.checkmateOrNot(movement1.getArrival())) {
            return;
        }
    }
}
