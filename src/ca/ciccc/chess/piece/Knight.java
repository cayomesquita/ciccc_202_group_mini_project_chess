package ca.ciccc.chess.piece;

public class Knight extends Piece {

    public Knight(boolean isWhite, Position position) {
        super(isWhite, position);
    }


    @Override
    public String getPiece() {
        if (getIsWhite() == true) {
            return "♘";
        }
        return "♞";
    }
}
