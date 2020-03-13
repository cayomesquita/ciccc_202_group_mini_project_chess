package ca.ciccc.chess.piece;

public abstract class Piece {
    private boolean isWhite;

    // constructor
    public Piece(boolean isWhite) {
        this.isWhite = isWhite;
    }

    // getters
    public boolean getIsWhite() {
        return isWhite;
    }

    //setter

    public void setColor(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public abstract String getPiece();


    @Override
    public boolean equals(Object obj) {
        if (((Piece) obj).getIsWhite() == getIsWhite()) {
            return true;
        }
        return false;
    }

    //    //    public abstract void canMove();
//    public boolean isValidMove(Position newPosition) {
//        if(newPosition.getRow() > 0 && newPosition.getCol() > 0
//        && newPosition.getRow() < 8 && newPosition.getCol() < 8) {
//            return true;
//        }
//        else {
//            return false;
//        }
//    }
}