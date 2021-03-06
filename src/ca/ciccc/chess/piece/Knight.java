package ca.ciccc.chess.piece;

public class Knight extends Piece {

    public Knight(boolean isWhite, Position position) {
        super(isWhite, position);
    }

    public Knight(boolean white) {
        super(white);
    }

    @Override
    protected char loadPiece() {
        return getIsWhite() ? KNIGHT_WHITE : KNIGHT_BLACK;
    }
}
