package ca.ciccc.chess.board;

import ca.ciccc.chess.piece.Piece;
import ca.ciccc.chess.piece.Position;

public interface Board {

    void print();

    void add(Piece piece, Position position);

    void move(Position from , Position to) throws Exception;
}
