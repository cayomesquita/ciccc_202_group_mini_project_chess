package ca.ciccc.chess.movement;

import ca.ciccc.chess.board.Board;
import ca.ciccc.chess.piece.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class MovementHorizontalStrategy extends MovementStrategyAbstract {

    private static MovementHorizontalStrategy instance = new MovementHorizontalStrategy();

    private MovementHorizontalStrategy() {
        super();
    }

    static MovementHorizontalStrategy getInstance(){
        return instance;
    }

    @Override
    public List<Movement> getPossibleMoviments(Position orinalPosition, Board board, boolean isWhite) {
        ArrayList<Movement> movements = new ArrayList<>();
        movements.addAll(forwardRight(orinalPosition, board, isWhite));
        movements.addAll(forwardLeft(orinalPosition, board, isWhite));
        return movements;
    }

    private List<Movement> forwardLeft(Position orinalPosition, Board board, boolean isWhite) {
        List<Position> nextPositions = new ArrayList<>();
        forward(nextPositions, orinalPosition, board, isWhite, -1, 0);
        return nextPositions.stream()
                .map(position -> new Movement(orinalPosition, position))
                .collect(Collectors.toList());
    }

    private List<Movement> forwardRight(final Position orinalPosition, Board board, boolean isWhite) {
        List<Position> nextPositions = new ArrayList<>();
        forward(nextPositions, orinalPosition, board, isWhite, 1, 0);
        return nextPositions.stream()
                .map(position -> new Movement(orinalPosition, position))
                .collect(Collectors.toList());
    }

}
