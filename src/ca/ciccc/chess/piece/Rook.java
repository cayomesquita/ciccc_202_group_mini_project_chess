package ca.ciccc.chess.piece;

public class Rook extends Piece{
    public Rook(boolean isWhite, Position position){
        super(isWhite, position);
    }

    @Override
    public String getPiece() {
        if (getIsWhite() == true) {
            return "♖";
        }
        return "♜";
    }
}
