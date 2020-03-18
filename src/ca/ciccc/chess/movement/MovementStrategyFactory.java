package ca.ciccc.chess.movement;

import ca.ciccc.chess.piece.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public final class MovementStrategyFactory {

    public static List<MovementStrategy> getStrategies(Piece piece) {
        if (piece instanceof King) {
            // TODO
            return Arrays.asList();
        }
        if (piece instanceof Queue) {
            // TODO
            return Arrays.asList();
        }
        if (piece instanceof Bishop) {
            // TODO
            return Arrays.asList();
        }
        if (piece instanceof Rook) {
            return Arrays.asList(MovementHorizontalStrategy.getInstance(), MovementVerticalStrategy.getInstance());
        }
        if (piece instanceof Knight) {
            // TODO
            return Arrays.asList();
        }
        if (piece instanceof Pawn) {
            // TODO
            return Arrays.asList();
        }
        return Collections.emptyList();
    }
}
