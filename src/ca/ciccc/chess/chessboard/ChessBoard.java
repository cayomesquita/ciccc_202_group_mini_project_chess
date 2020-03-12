package ca.ciccc.chess.chessboard;
import java.awt.*;

public class ChessBoard {

    private Piece[][] board = new Piece[8][8]; //to show game status in text based version
    private ArrayList<Piece> pieces = new ArrayList<Piece>(32); //create 32 pieces, 16 for both players

    public ChessBoard() {
        board = new Piece[8][8];

        // Set up the board
        newBoard();

        wKing = new Point(0, 4);
        bKing = new Point(7, 4);
        bPawn = new Point(7, 4);
        bPawn = new Point(7, 4);



    }
}