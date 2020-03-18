package ca.ciccc.chess;

import ca.ciccc.chess.board.BoardController;
import ca.ciccc.chess.movement.Movement;
import ca.ciccc.chess.piece.Piece;
import ca.ciccc.chess.piece.Position;
import ca.ciccc.chess.piece.Rook;

import java.util.List;
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

        Position position1 = new Position(1, 3);
        Position position2 = new Position(1, 7);
        Position position3 = new Position(2, 3);
        boardController.addPieceTest(new Rook(true), position1)
                .addPieceTest(new Rook(false), position2)
                .addPieceTest(new Rook(false), position3);
        Piece piece = boardController.getByPosition(position1);

        System.out.println(position2);
        System.out.println(position1);
        List<Movement> result = boardController.getPossibleMovements(position1);
        System.out.println(result.size());
        System.out.println(result.stream()
                .map(movement -> movement.toString())
                .collect(Collectors.joining(", ", "[", "]")));

        boardController.printBoard();
    }


}
