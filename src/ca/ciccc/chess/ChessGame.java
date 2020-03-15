package ca.ciccc.chess;

import ca.ciccc.chess.board.Board;
import ca.ciccc.chess.board.BoardFactory;
import ca.ciccc.chess.piece.Piece;
import ca.ciccc.chess.piece.Pawn;
import ca.ciccc.chess.piece.Position;

import java.util.Arrays;

public class ChessGame {

    private Board board;

    public ChessGame() {
        board = BoardFactory.createChessBoard();
    }

    public void start() throws Exception {
        Piece pawn = new Pawn(true, new Position(3, 4));
        board.print(Arrays.asList(pawn));
    }
}
