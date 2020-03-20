package ca.ciccc.chess.movement;

import ca.ciccc.chess.board.Board;
import ca.ciccc.chess.piece.Piece;
import ca.ciccc.chess.piece.Position;

import java.util.ArrayList;
import java.util.List;

public final class MovementBishopStrategy extends MovementStrategyAbstract {

    private static MovementBishopStrategy instance = new MovementBishopStrategy();
    private static Position possiblePosition;
    private boolean stop = false;

    private MovementBishopStrategy() {
        super();
    }

    static MovementBishopStrategy getInstance(){
        return instance;
    }

    @Override
    public List<Movement> getPossibleMoviments(Position originalPosition, Board board, boolean isWhite) {
        List<Movement> list = new ArrayList<>();
            // front right
            int originalRow = originalPosition.getRow();
            int originalCl = originalPosition.getColumn();
            while(originalRow < 8 && originalCl < 8 && stop == false) {
                possiblePosition = new Position(++originalRow, ++originalCl);
                checkNewPosition(originalPosition, board, isWhite, list, possiblePosition);
            }
//             front left
            originalRow = originalPosition.getRow();
            originalCl = originalPosition.getColumn();
            stop = false;
            while(originalRow < 8 && originalCl > 0 && stop == false ) {
                possiblePosition = new Position(++originalRow, --originalCl);
                checkNewPosition(originalPosition, board, isWhite, list, possiblePosition);
            }
            // back right
            originalRow = originalPosition.getRow();
            originalCl = originalPosition.getColumn();
            stop = false;
            while(originalRow > 0 && originalCl < 8 && stop == false) {
                possiblePosition = new Position(--originalRow, ++originalCl);
                checkNewPosition(originalPosition, board, isWhite, list, possiblePosition);
            }
            // back Left
            originalRow = originalPosition.getRow();
            originalCl = originalPosition.getColumn();
            stop = false;
            while(originalRow > 0 && originalCl > 0 && stop == false) {
                possiblePosition = new Position(--originalRow, --originalCl);
                checkNewPosition(originalPosition, board, isWhite, list, possiblePosition);
            }
        return list;
    }
    @Override
    protected void checkNewPosition(Position orinalPosition, Board board, boolean isWhite, List<Movement> list, Position position) {
        if (isPositionInsideBoard(position, board)) {
            Piece piece = board.get(position);
            if (piece == null) {
                list.add(new Movement(orinalPosition, position));
            } else if (piece != null && piece.getIsWhite() != isWhite) {
                list.add(new Movement(orinalPosition, position));
                stop = true;
            } else if (piece != null && piece.getIsWhite() == isWhite) {
                stop = true;
            }
        }
    }}