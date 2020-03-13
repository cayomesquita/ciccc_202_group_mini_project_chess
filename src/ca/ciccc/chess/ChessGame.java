package ca.ciccc.chess;

import ca.ciccc.chess.board.Board;
import ca.ciccc.chess.board.BoardFactory;

public class ChessGame {

    private Board board;

    public ChessGame() {
        board = BoardFactory.createChessBoard();
    }

    public void start() {
        board.print();
    }
}
