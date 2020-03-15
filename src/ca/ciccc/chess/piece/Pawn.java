package ca.ciccc.chess.piece;

public class Pawn extends Piece {
    private boolean promoted;
    private Piece newPiece;
    private static int proceeding; // for check if it's the first movement or not, and if it reaches the final line.

    public Pawn(boolean isWhite, Position position) {
        super(isWhite, position);
        this.promoted = false;
        this.proceeding = 1;
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

    public boolean isPromoted() {
        return promoted;
    }

    @Override
    protected char loadPiece() {
        return getIsWhite() ? PAWN_WHITE : PAWN_BLACK;
    }

//    @Override
//    public boolean isValidMove(Position newPosition) {
//        if(!super.isValidMove(position)) {
//            return false;
//        }
//        if (this.proceeding == 1) {
//            if (newPosition.getRow() == getPosition().getRow() + 1
//                    && newPosition.getCol() == getPosition().getCol() + 1) {
//                return true;
//            } else if (newPosition.getRow() == getPosition().getRow()
//                    && newPosition.getCol() == getPosition().getCol() + 2) {
//                return true;
//            }
//        } else {
//            if (newPosition.getRow() == getPosition().getRow() + 1
//                    && newPosition.getCol() == getPosition().getCol() + 1) {
//                return true;
//            }
//        }
//         return false;
//    }
}