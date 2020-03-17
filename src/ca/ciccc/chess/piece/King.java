package ca.ciccc.chess.piece;

public class King extends Piece {

    public King(boolean isWhite, Position position) {
        super(isWhite, position);
    }

    public King(boolean white) {
        super(white);
    }

    @Override
    protected char loadPiece() {
        return getIsWhite() ? KING_WHITE : KING_BLACK;
    }


}
