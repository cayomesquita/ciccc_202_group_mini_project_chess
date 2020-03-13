package ca.ciccc.chess.piece;

public abstract class Piece {
    private boolean isWhite;
    private Position position;

    // constructor
    public Piece(boolean isWhite, Position position) {
        this.isWhite = isWhite;
        this.position = position;
    }

    // getters
    public boolean getIsWhite() {
        return isWhite;
    }

    public Position getPosition() { return position; }

    //setter
    public void setPosition(Position position) { this.position = position; }
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

    // New changes for movement 3/13
    // check is the position OK or Not
    public boolean isValidMove(Position newPosition) {
        if(newPosition.getX() > 0 && newPosition.getY() > 0
        && newPosition.getX() < 8 && newPosition.getY() < 8) {
            return true;
        }
        else {
            return false;
        }
    }

    public void setNewPosition(Position newPosition) {
        if (isValidMove(newPosition)){
            this.position = newPosition;
        }
    }
}