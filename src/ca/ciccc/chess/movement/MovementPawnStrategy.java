package ca.ciccc.chess.movement;

import ca.ciccc.chess.board.Board;
import ca.ciccc.chess.piece.Pawn;
import ca.ciccc.chess.piece.Piece;
import ca.ciccc.chess.piece.Position;

import java.util.ArrayList;
import java.util.List;

public final class MovementPawnStrategy extends MovementStrategyAbstract {

    private static MovementPawnStrategy instance = new MovementPawnStrategy();

    private MovementPawnStrategy() {
        super();
    }

    static MovementPawnStrategy getInstance(){
        return instance;
    }

    @Override
    public List<Movement> getPossibleMoviments(Position originalPosition, Board board, boolean isWhite) {
        List<Movement> list = new ArrayList<>();
        Position up1 = move(originalPosition, 0, 1);
        checkNewPosition(originalPosition, board, isWhite, list, up1);

        if (isWhite == true && originalPosition.getRow() == 1) {
            Position up2 = move(originalPosition, 0, 2);
            checkNewPosition2(originalPosition, board, isWhite, list, up2);
        } else if (isWhite == false && originalPosition.getRow() == 6) {
            Position up2 = move(originalPosition, 0, -2);
            checkNewPosition2(originalPosition, board, isWhite, list, up2);
        }
        return list;
    }

    @Override
    protected void checkNewPosition(Position originalPosition, Board board, boolean isWhite, List<Movement> list, Position position) {
        Position frontRight = move(originalPosition, 1, 1);
        Position frontLeft = move(originalPosition, -1, 1);
        if (isPositionInsideBoard(position, board)) {
            Piece piece = board.get(position);
                if (piece == null) {
                list.add(new Movement(originalPosition, position));
            }
        }
        if (isPositionInsideBoard(frontRight, board)) {
            Piece piece = board.get(frontRight);
            if (piece != null && piece.getIsWhite() != isWhite) {
                list.add(new Movement(originalPosition, frontRight));
            }
        }
        if (isPositionInsideBoard(frontLeft, board)) {
            Piece piece = board.get(frontLeft);
            if (piece != null && piece.getIsWhite() != isWhite) {
                list.add(new Movement(originalPosition, frontLeft));
            }
        }
    }

    protected void checkNewPosition2(Position originalPosition, Board board, boolean isWhite, List<Movement> list, Position position) {
        Position front = move(originalPosition, 0, 1);
        if (isPositionInsideBoard(position, board)) {
            Piece piece = board.get(position);
            Piece piece2 = board.get(front);
            if (piece == null && piece2 == null) {
                list.add(new Movement(originalPosition, position));
            }
        }


    }
}
