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

//
//    // New changes for movement 3/13
//    @Override
//    public boolean isValidMove(Position newPosition) {
//        if (super.isValidMove(newPosition)) {
//            if (this.getPosition().getX() % 2 == 0) {
//                if (newPosition.getX() % 2 == 0 && newPosition.getY() % 2 == 0) {
//                    return true;
//                }
//            } else {
//                if (newPosition.getX() % 2 == 1 && newPosition.getY() % 2 == 1) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}
