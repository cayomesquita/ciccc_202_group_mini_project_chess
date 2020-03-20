package ca.ciccc.chess.board;

import ca.ciccc.chess.piece.Piece;
import ca.ciccc.chess.piece.Position;

import java.util.Set;

public interface Board {

    void print();

    void add(Piece piece, Position position);

    Piece get(Position position);

    boolean move(Position from , Position to) throws Exception;

    int size();

    Set<Position> getAllPiecePositions(boolean whitePlayer);
}
