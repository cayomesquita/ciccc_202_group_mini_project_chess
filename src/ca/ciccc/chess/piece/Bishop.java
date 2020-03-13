package ca.ciccc.chess.piece;

public class Bishop extends Piece{
    public Bishop(boolean isWhite, Position position){
        super(isWhite, position);
    }


    @Override
    public String getPiece() {
        if (getIsWhite() == true) {
            return "♗";
        }
        return "♝";
    }
}
