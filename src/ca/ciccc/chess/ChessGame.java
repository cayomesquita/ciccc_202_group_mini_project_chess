package ca.ciccc.chess;

import ca.ciccc.chess.board.BoardController;

public class ChessGame {

    private BoardController boardController;

    public ChessGame() {
        boardController = BoardController.getInstante();
    }

    public void start() throws Exception {
        boardController.initialize();
        boardController.printBoard();
    }
}
