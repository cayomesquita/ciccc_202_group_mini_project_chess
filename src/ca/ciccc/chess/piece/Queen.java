package ca.ciccc.chess.piece;

public class Queen extends Piece {
    public Queen(boolean isWhite, Position position){
        super(isWhite, position);
    }


    @Override
    public String getPiece() {
        if (getIsWhite() == true) {
            return "♕";
        }
        return "♛";
    }

}
