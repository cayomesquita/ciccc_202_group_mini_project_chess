package ca.ciccc.chess.movement;

import ca.ciccc.chess.board.Board;
import ca.ciccc.chess.piece.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovementVerticalStrategy extends MovementStrategyAbstract {

    private static MovementVerticalStrategy instance = new MovementVerticalStrategy();

    private MovementVerticalStrategy() {
        super();
    }

    static MovementVerticalStrategy getInstance() {
        return instance;
    }

    @Override
    public List<Movement> getPossibleMoviments(Position orinalPosition, Board board, boolean isWhite) {
        ArrayList<Movement> movements = new ArrayList<>();
        movements.addAll(forwardUp(orinalPosition, board, isWhite));
        movements.addAll(forwardDown(orinalPosition, board, isWhite));
        return movements;
    }

    private List<Movement> forwardUp(Position orinalPosition, Board board, boolean isWhite) {
        List<Position> nextPositions = new ArrayList<>();
        forward(nextPositions, orinalPosition, board, isWhite, 0, 1);
        return nextPositions.stream()
                .map(position -> new Movement(orinalPosition, position))
                .collect(Collectors.toList());
    }

    private List<Movement> forwardDown(final Position orinalPosition, Board board, boolean isWhite) {
        List<Position> nextPositions = new ArrayList<>();
        forward(nextPositions, orinalPosition, board, isWhite, 0, -1);
        return nextPositions.stream()
                .map(position -> new Movement(orinalPosition, position))
                .collect(Collectors.toList());
    }

}
