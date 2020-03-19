package ca.ciccc.chess.piece;

public class Pawn extends Piece {
    private boolean promoted;
    private Piece newPiece;
    private int proceeding; // for check if it's the first movement or not, and if it reaches the final line.

    public Pawn(boolean isWhite, Position position) {
        super(isWhite, position);
        this.promoted = false;
        this.proceeding = 1;
    }

    public Pawn(boolean white) {
        super(white);
    }

    public void promote(Piece newPiece) {
        if (!promoted && proceeding == 7) {
            this.promoted = true;
            this.newPiece = newPiece;
        }
    }

    public Piece getNewPiece() {
        return newPiece;
    }

    public int getProceeding() {
        return proceeding;
    }

    public boolean isPromoted() {
        return promoted;
    }

    @Override
    protected char loadPiece() {
        return getIsWhite() ? PAWN_WHITE : PAWN_BLACK;
    }
}
