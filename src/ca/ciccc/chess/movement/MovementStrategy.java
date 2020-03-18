package ca.ciccc.chess.movement;

import ca.ciccc.chess.board.Board;
import ca.ciccc.chess.piece.Position;

import java.util.List;

public interface MovementStrategy {

    List<Movement> getPossibleMoviments(Position orinalPosition, Board board, boolean isWhite);

}
