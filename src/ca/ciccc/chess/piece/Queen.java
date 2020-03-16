package ca.ciccc.chess.piece;

public class Queen extends Piece {

    public Queen(boolean isWhite, Position position) {
        super(isWhite, position);
    }

    public Queen(boolean white) {
        super(white);
    }

    @Override
    protected char loadPiece() {
        return getIsWhite() ? QUENN_WHITE : QUENN_BLACK;
    }


}
