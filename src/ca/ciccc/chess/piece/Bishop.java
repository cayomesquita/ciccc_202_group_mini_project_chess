package ca.ciccc.chess.piece;

public class Bishop extends Piece {

    public Bishop(boolean isWhite, Position position) {
        super(isWhite, position);
    }

    public Bishop(boolean white) {
        super(white);
    }

    @Override
    protected char loadPiece() {
        return getIsWhite() ? BISHOP_WHITE : BISHOP_BLACK;
    }
}
