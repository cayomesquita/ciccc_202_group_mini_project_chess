package ca.ciccc.chess.board;

import ca.ciccc.chess.piece.*;

public class BoardController {

    private static BoardController instance = new BoardController();

    private Board board;

    private BoardController() {
        super();
        this.board = BoardFactory.createBasicChessBoard();
    }

    public static BoardController getInstante() {
        return instance;
    }

    public void initialize() {
        addWhitePieces();
        addBlackPieces();
    }

    private void addWhitePieces() {
        boolean white = true;
        int row = 0;
        int collumn = 0;
        board.add(new Rook(white), new Position(row, collumn++));
        board.add(new Knight(white), new Position(row, collumn++));
        board.add(new Bishop(white), new Position(row, collumn++));
        board.add(new Queen(white), new Position(row, collumn++));
        board.add(new King(white), new Position(row, collumn++));
        board.add(new Bishop(white), new Position(row, collumn++));
        board.add(new Knight(white), new Position(row, collumn++));
        board.add(new Rook(white), new Position(row++, collumn));
        for (; collumn >= 0; collumn--) {
            board.add(new Pawn(white), new Position(row, collumn));
        }
    }

    private void addBlackPieces() {
        boolean white = false;
        int row = 7;
        int collumn = 0;
        board.add(new Rook(white), new Position(row, collumn++));
        board.add(new Knight(white), new Position(row, collumn++));
        board.add(new Bishop(white), new Position(row, collumn++));
        board.add(new Queen(white), new Position(row, collumn++));
        board.add(new King(white), new Position(row, collumn++));
        board.add(new Bishop(white), new Position(row, collumn++));
        board.add(new Knight(white), new Position(row, collumn++));
        board.add(new Rook(white), new Position(row--, collumn));
        for (; collumn >= 0; collumn--) {
            board.add(new Pawn(white), new Position(row, collumn));
        }
    }

    public void printBoard() {
        board.print();
    }
}
