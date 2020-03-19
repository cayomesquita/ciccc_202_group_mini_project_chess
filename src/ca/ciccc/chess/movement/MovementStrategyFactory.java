package ca.ciccc.chess.movement;

import ca.ciccc.chess.piece.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public final class MovementStrategyFactory {

    public static List<MovementStrategy> getStrategies(Piece piece) {
        if (piece instanceof King) {
            // TODO Zack
            return Arrays.asList(MovementKingStrategy.getInstance());
        }
        if (piece instanceof Queen) {
            // TODO Tomna
            return Arrays.asList(MovementBishopStrategy.getInstance(), MovementHorizontalStrategy.getInstance(), MovementVerticalStrategy.getInstance());
        }
        if (piece instanceof Bishop) {
            // TODO Tomna
            return Arrays.asList(MovementBishopStrategy.getInstance());
        }
        if (piece instanceof Rook) {
            return Arrays.asList(MovementHorizontalStrategy.getInstance(), MovementVerticalStrategy.getInstance());
        }
        if (piece instanceof Knight) {
            // TODO Zack
            return Arrays.asList();
        }
        if (piece instanceof Pawn) {
            // TODO Tomona
            return Arrays.asList(MovementPawnStrategy.getInstance());
        }
        return Collections.emptyList();
    }
}
