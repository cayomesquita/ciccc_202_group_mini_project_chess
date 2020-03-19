package ca.ciccc.chess.movement;

import ca.ciccc.chess.board.Board;
import ca.ciccc.chess.piece.Position;

import java.util.ArrayList;
import java.util.List;

public final class MovementKingStrategy extends MovementStrategyAbstract {

    private static MovementKingStrategy instance = new MovementKingStrategy();

    private MovementKingStrategy() {
        super();
    }

    static MovementKingStrategy getInstance(){
        return instance;
    }

    @Override
    public List<Movement> getPossibleMoviments(Position orinalPosition, Board board, boolean isWhite) {
        List<Movement> list = new ArrayList<>();
        Position right = move(orinalPosition, 1, 0);
        Position left = move(orinalPosition, -1, 0);
        Position up = move(orinalPosition, 0, 1);
        Position down = move(orinalPosition, 0, -1);

        Position upright = move(orinalPosition, 1, 1);
        Position downright = move(orinalPosition, 1, -1);
        Position upleft = move(orinalPosition, -1, 1);
        Position downleft = move(orinalPosition, -1, -1);


        checkNewPosition(orinalPosition, board, isWhite, list, right);
        checkNewPosition(orinalPosition, board, isWhite, list, left);
        checkNewPosition(orinalPosition, board, isWhite, list, up);
        checkNewPosition(orinalPosition, board, isWhite, list, down);

        checkNewPosition(orinalPosition, board, isWhite, list, upright);
        checkNewPosition(orinalPosition, board, isWhite, list, downright);
        checkNewPosition(orinalPosition, board, isWhite, list, upleft);
        checkNewPosition(orinalPosition, board, isWhite, list, downleft);
        return list;
    }

}