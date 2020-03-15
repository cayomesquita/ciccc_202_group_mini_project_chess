package ca.ciccc.chess.piece;

public class Bishop extends Piece {

    public Bishop(boolean isWhite, Position position) {
        super(isWhite, position);
    }

    @Override
    protected char loadPiece() {
        return getIsWhite() ? BISHOP_WHITE : BISHOP_BLACK;
    }
}
