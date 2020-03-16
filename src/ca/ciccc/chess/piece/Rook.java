package ca.ciccc.chess.piece;

public class Rook extends Piece {

    public Rook(boolean isWhite, Position position) {
        super(isWhite, position);
    }

    public Rook(boolean white) {
        super(white);
    }

    @Override
    protected char loadPiece() {
        return getIsWhite() ? ROOK_WHITE : ROOK_BLACK;
    }

}
