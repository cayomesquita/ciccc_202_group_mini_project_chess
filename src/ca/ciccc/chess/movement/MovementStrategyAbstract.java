package ca.ciccc.chess.movement;

import ca.ciccc.chess.board.Board;
import ca.ciccc.chess.piece.Piece;
import ca.ciccc.chess.piece.Position;

import java.util.List;

public abstract class MovementStrategyAbstract implements MovementStrategy {

    protected void forward(List<Position> nextPositions, Position orinalPosition, Board board, boolean isWhite, int horizontal, int vertical) {
        Position nextPosition = move(orinalPosition, horizontal, vertical);
        if (isPositionInsideBoard(nextPosition, board)) {
            Piece piece = board.get(nextPosition);
            if (piece == null) {
                nextPositions.add(nextPosition);
                forward(nextPositions, nextPosition, board, isWhite, horizontal, vertical);
            } else if (piece.getIsWhite() != isWhite) {
                nextPositions.add(nextPosition);
            }
        }
    }

    protected boolean isPositionInsideBoard(Position nextPosition, Board board) {
        return nextPosition.getRow() >= 0 && nextPosition.getRow() < board.size() && nextPosition.getCollumn() >= 0 && nextPosition.getCollumn() < board.size();
    }

    protected Position move(Position position, int horizontal, int vertical) {
        return new Position(position.getRow() + vertical, position.getCollumn() + horizontal);
    }

    protected void checkNewPosition(Position orinalPosition, Board board, boolean isWhite, List<Movement> list, Position position) {
        if (isPositionInsideBoard(position, board)) {
            Piece piece = board.get(position);
            if (piece == null || piece.getIsWhite() != isWhite) {
                list.add(new Movement(orinalPosition, position));
            }
        }
    }

    @Override
    public boolean checkPossibleMoviment(Movement movement, Board board, boolean isWhite) {
        return getPossibleMoviments(movement.getStarting(), board, isWhite).contains(movement);
    }
}
