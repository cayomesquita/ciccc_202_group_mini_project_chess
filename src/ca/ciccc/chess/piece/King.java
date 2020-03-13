package ca.ciccc.chess.piece;

public class King extends  Piece{
    public King(boolean isWhite, Position position){
        super(isWhite, position);
    }


    @Override
    public String getPiece() {
        if (getIsWhite() == true) {
            return "♔";
        }
        return "♚";
    }
}
