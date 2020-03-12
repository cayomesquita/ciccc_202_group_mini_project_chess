package ca.ciccc.chess.piece;

public abstract class Piece {
    private Position position;
    private boolean isWhite;

    // constructor
    public Piece(Position position, boolean isWhite) {
        this.position = position;
        this.isWhite = isWhite;
    }

    // getters
    public Position getPosition() {
        return position;
    }

    public boolean getIsWhite() {
        return isWhite;
    }

    //setter
    public void setPosition(Position position) {
        this.position = position;
    }

    public void setColor(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public abstract String getPiece();

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

    @Override
    public boolean equals(Object obj) {
        if (((Piece) obj).getIsWhite() == getIsWhite()) {
            return true;
        }
        return false;
    }
}
