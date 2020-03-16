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
//
//    // New changes for movement 3/13
//    @Override
//    public boolean isValidMove(Position newPosition) {
//        if (super.isValidMove(newPosition)) {
//            if (newPosition.getX() == this.getPosition().getX() + 1 || newPosition.getX() == this.getPosition().getX() -1) {
//                return true;
//            }
//            if (newPosition.getY() == this.getPosition().getY() + 1 || newPosition.getY() == this.getPosition().getY() -1) {
//                return true;
//            }
//        }
//        return false;
//    }
}
