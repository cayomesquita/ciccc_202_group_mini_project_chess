package ca.ciccc.chess;

import ca.ciccc.chess.board.BoardController;
import ca.ciccc.chess.input.InputController;
import ca.ciccc.chess.movement.Movement;
import ca.ciccc.chess.piece.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class ChessGame {

    private BoardController boardController;

    public ChessGame() {
        boardController = BoardController.getInstante();
    }

    public void start() throws Exception {
        boardController.addPieceTest();
        boardController.printBoard();

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


        Position position1 = new Position(3, 3);
//        Position position2 = new Position(2, 2);
//        Position position3 = new Position(4, 1);
//        Position position4 = new Position(1, 2);
        boardController
                .addPieceTest(new Knight(true), position1);
//                .addPieceTest(new Rook(true), position2)
//                .addPieceTest(new Rook(false), position3)
//                .addPieceTest(new Rook(true), position4);
        Piece piece = boardController.getByPosition(position1);

        System.out.println(position2);


//        Position position1 = new Position(1, 1);
//        Position position2 = new Position(2, 2);
//        Position position3 = new Position(2, 1);
//        Position position4 = new Position(1, 3);
//        boardController.addPieceTest(new Queen(false), position1)
//                .addPieceTest(new Rook(false), position2)
//                .addPieceTest(new Rook(false), position3)
//                .addPieceTest(new Rook(true), position4);
//        Piece piece = boardController.getByPosition(position1);

        System.out.println(position1);
>>>>>>> bec6669d7306d3c45ab03d872a5ec40ba786d9b0

        Set<Movement> result = boardController.getPossibleMovements(position1);
        System.out.println("You have " + result.size() + " movements to to.");
        System.out.println(result.stream()
                .map(movement -> movement.toString())
                .collect(Collectors.joining(", ", "[", "]")));

        boardController.printBoard();
    }
}