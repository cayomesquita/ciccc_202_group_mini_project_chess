package ca.ciccc.chess.piece;

//                        ╔════════╗
//                        ║♜♞♝♛♚♝♞♜║
//                        ║♟♟♟♟♟♟♟♟║
//                        ║▒█▒█▒█▒█║
//                        ║█▒█▒█▒█▒║
//                        ║▒█▒█▒█▒█║
//                        ║█▒█▒█▒█▒║
//                        ║♙♙♙♙♙♙♙♙║
//                        ║♖♘♗♕♔♗♘♖║
//                        ╚════════╝

public abstract class Piece {

    public final static char KING_BLACK = '♔';
    public final static char QUENN_BLACK = '♕';
    public final static char BISHOP_BLACK = '♗';
    public final static char KNIGHT_BLACK = '♘';
    public final static char ROOK_BLACK = '♖';
    public final static char PAWN_BLACK = '♙';
    public final static char KING_WHITE = '♚';
    public final static char QUENN_WHITE = '♛';
    public final static char BISHOP_WHITE = '♝';
    public final static char KNIGHT_WHITE = '♞';
    public final static char ROOK_WHITE = '♜';
    public final static char PAWN_WHITE = '♟';

    private boolean isWhite;
    private Position position;
    private char piece;

    // constructor
    public Piece(boolean isWhite, Position position) {
        this(isWhite);
        this.position = position;
    }

    public Piece(boolean isWhite) {
        this.isWhite = isWhite;
        this.piece = loadPiece();
    }

    protected abstract char loadPiece();

    // getters
    public boolean getIsWhite() {
        return isWhite;
    }

    public Position getPosition() {
        return position;
    }

    //setter
    public void setPosition(Position position) {
        this.position = position;
    }

    public void setColor(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public char getPiece() {
        return this.piece;
    }

    @Override
    public boolean equals(Object obj) {
        if (((Piece) obj).getIsWhite() == getIsWhite()) {
            return true;
        }
        return false;
    }

}