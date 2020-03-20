package ca.ciccc.chess.board;

import ca.ciccc.chess.movement.MovementStrategy;
import ca.ciccc.chess.movement.MovementStrategyFactory;
import ca.ciccc.chess.movement.Movement;
import ca.ciccc.chess.piece.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BoardController {

    private static BoardController instance = new BoardController();

    private Board board;

    private BoardController() {
        super();
        this.board = BoardFactory.createBasicChessBoard();
    }

    public static BoardController getInstante() {
        return instance;
    }

    public void addPieceTest() {
        addWhitePieces();
        addBlackPieces();
    }

    private void addWhitePieces() {
        boolean white = true;
        int row = 0;
        int collumn = 0;
        board.add(new Rook(white), new Position(row, collumn++));
        board.add(new Knight(white), new Position(row, collumn++));
        board.add(new Bishop(white), new Position(row, collumn++));
        board.add(new Queen(white), new Position(row, collumn++));
        board.add(new King(white), new Position(row, collumn++));
        board.add(new Bishop(white), new Position(row, collumn++));
        board.add(new Knight(white), new Position(row, collumn++));
        board.add(new Rook(white), new Position(row++, collumn));
        for (; collumn >= 0; collumn--) {
            board.add(new Pawn(white), new Position(row, collumn));
        }
    }

    private void addBlackPieces() {
        boolean white = false;
        int row = 7;
        int collumn = 0;
        board.add(new Rook(white), new Position(row, collumn++));
        board.add(new Knight(white), new Position(row, collumn++));
        board.add(new Bishop(white), new Position(row, collumn++));
        board.add(new Queen(white), new Position(row, collumn++));
        board.add(new King(white), new Position(row, collumn++));
        board.add(new Bishop(white), new Position(row, collumn++));
        board.add(new Knight(white), new Position(row, collumn++));
        board.add(new Rook(white), new Position(row--, collumn));
        for (; collumn >= 0; collumn--) {
            board.add(new Pawn(white), new Position(row, collumn));
        }
    }

    public void printBoard() {
        board.print();
    }

    //FIXME remove test
    public BoardController addPieceTest(Piece piece, Position position) {
        board.add(piece, position);
        return this;
    }

    public Piece getByPosition(Position position) {
        return board.get(position);
    }

    public Set<Movement> getPossibleMovements(Position position) throws Exception {
        Piece piece = board.get(position);
        if (piece == null) {
            throw new Exception("No piece in position");
        }
        List<MovementStrategy> strategies = MovementStrategyFactory.getStrategies(piece);
        Set<Movement> possibleMovements = new HashSet<>();
        for (MovementStrategy strategy : strategies) {
            possibleMovements.addAll(strategy.getPossibleMoviments(position, board, piece.getIsWhite()));
        }
        return possibleMovements;
    }

    public boolean move(Movement movement) throws Exception {
        Piece piece = board.get(movement.getStarting());
        if (piece == null) {
            throw new Exception("No piece in position");
        }
        List<MovementStrategy> strategies = MovementStrategyFactory.getStrategies(piece);
        Set<Movement> possibleMovements = new HashSet<>();
        for (MovementStrategy strategy : strategies) {
            if (strategy.checkPossibleMoviment(movement, board, piece.getIsWhite())) {
                return board.move(movement.getStarting(),movement.getArrival());
            }
        }
        return false;
    }


    // Check if the game is over or not
    public boolean checkmateOrNot(Position toPosition) {
        Piece target = board.get(toPosition);
        if (target.getClass().getName() == "King$1") {
            if(target.getIsWhite() == true) {
                System.out.println("The White King was killed.\n Team Black is winner.");
                return true;
            } else {
                System.out.println("The Black King was killed.\n Team White is winner.");
                return true;
            }
        }
        return false;
    }
}
