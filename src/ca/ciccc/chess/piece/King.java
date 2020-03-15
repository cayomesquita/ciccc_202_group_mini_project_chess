package ca.ciccc.chess.piece;

public class King extends Piece {

    public King(boolean isWhite, Position position) {
        super(isWhite, position);
    }

    @Override
    protected char loadPiece() {
        return getIsWhite() ? KING_WHITE : KING_BLACK;
    }
}
