package ca.ciccc.chess.movement;

import ca.ciccc.chess.board.Board;
import ca.ciccc.chess.piece.Position;

import java.util.ArrayList;
import java.util.List;

public final class MovementKnightStrategy extends MovementStrategyAbstract {

    private static MovementKnightStrategy instance = new MovementKnightStrategy();

    private MovementKnightStrategy() {
        super();
    }

    static MovementKnightStrategy getInstance(){
        return instance;
    }

    @Override
    public List<Movement> getPossibleMoviments(Position orinalPosition, Board board, boolean isWhite) {
        List<Movement> list = new ArrayList<>();

        Position upright1 = move(orinalPosition, 1, 2);
        Position upright2 = move(orinalPosition, 2, 1);
        Position upleft1 = move(orinalPosition, -2, 1);
        Position upleft2 = move(orinalPosition, -1, 2);
        Position downright1 = move(orinalPosition, 2, -1);
        Position downright2 = move(orinalPosition, 1, -2);
        Position downleft1 = move(orinalPosition, -2, -1);
        Position downleft2 = move(orinalPosition, -1, -2);

        checkNewPosition(orinalPosition, board, isWhite, list, upright1);
        checkNewPosition(orinalPosition, board, isWhite, list, upright2);
        checkNewPosition(orinalPosition, board, isWhite, list, upleft1);
        checkNewPosition(orinalPosition, board, isWhite, list, upleft2);
        checkNewPosition(orinalPosition, board, isWhite, list, downright1);
        checkNewPosition(orinalPosition, board, isWhite, list, downright2);
        checkNewPosition(orinalPosition, board, isWhite, list, downleft1);
        checkNewPosition(orinalPosition, board, isWhite, list, downleft2);
        return list;
    }
}