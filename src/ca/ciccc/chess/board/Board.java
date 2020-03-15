package ca.ciccc.chess.board;

import ca.ciccc.chess.piece.Piece;

import java.util.List;

public interface Board {

    void print();

    void print(List<Piece> asList);
}
