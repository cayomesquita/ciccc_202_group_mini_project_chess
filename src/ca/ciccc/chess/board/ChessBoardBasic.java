package ca.ciccc.chess.board;

import ca.ciccc.chess.piece.Piece;
import ca.ciccc.chess.piece.Position;

import java.util.HashSet;
import java.util.Set;

public class ChessBoardBasic extends BoardAbstract {

    public static final char WHITE = '█';
    public static final char BLACK = '▒';
    public static final char VOID = ' ';
    public static final int RADIX = 10;

//                        ╔════════╗
//                        ║♜♞♝♛♚♝♞♜║
//                        ║♟♟♟♟♟♟♟♟║
//                        ║▒█▒█▒█▒█║
//                        ║█▒█▒█▒█▒║
//                        ║▒█▒█▒█▒█║
//                        ║█▒█▒█▒█▒║
//                        ║♙♙♙♙♙♙♙♙║
//                        ║♖♘♗♕♔♗♘♖║
//                        ╚════════╝

    char[][] boardGraph;
    boolean graphRefreshed;
    Piece[][] pieces;

    public ChessBoardBasic() {
        this.boardGraph = new char[size()][size()];
        this.pieces = new Piece[size()][size()];
        refreshBoard();
    }

    private void refreshBoard() {
        for (int row = 0; row < boardGraph.length; row++) {
            for (int collumn = 0; collumn < boardGraph[row].length; collumn++) {
                boardGraph[row][collumn] = pieces[row][collumn] == null ?
                        backgroud(row, collumn) : pieces[row][collumn].getPiece();
            }
        }
        graphRefreshed = true;
    }


    private char backgroud(int i, int j) {
        return ((i + j) % 2) == 0 ? WHITE : BLACK;
    }

    private char topBoardDecoration(int j) {
        return j == 1 ? '╔' : j == boardGraph.length - 2 ? '╗' : '═';
    }

    private char bottonBoardDecoration(int j) {
        return j == 1 ? '╚' : j == boardGraph.length - 2 ? '╝' : '═';
    }

    private char getLetter(int i) {
        return (char) ((int) 'J' - i);
    }

    private char position(int i, int j) {
        if (i == 0 || i == boardGraph.length - 1) {
            return j == 0 || j == boardGraph.length - 1 ? VOID : getDigit(j);
        }
        if (i == 1 || i == boardGraph.length - 2) {
            return j == 1 || j == boardGraph.length - 2 ? VOID : getDigit(j);
        }
        return 0;
    }

    private char getDigit(int j) {
        return Character.forDigit(j, RADIX);
    }

    @Override
    public void print() {
        if (!graphRefreshed) {
            refreshBoard();
        }
        for (int i = boardGraph.length - 1; i >= 0; i--) {
            for (int j = 0; j < boardGraph[i].length; j++) {
                System.out.print(boardGraph[i][j]);
            }
            System.out.println();
        }
    }

    @Override
    public void add(Piece piece, Position position) {
        this.pieces[position.getRow()][position.getColumn()] = piece;
        updateBoard();
    }

    @Override
    public boolean move(Position from, Position to) throws Exception {
        if (pieces[from.getRow()][from.getColumn()] == null) {
            throw new Exception("Invalid input. The position does not have a piece");
        } else if (pieces[to.getRow()][to.getColumn()] != null &&
                pieces[to.getRow()][to.getColumn()].getIsWhite() == pieces[from.getRow()][from.getColumn()].getIsWhite()) {
            throw new Exception("Invalid input. The same color piece is in the new position.");
        }

        pieces[to.getRow()][to.getColumn()] = pieces[from.getRow()][from.getColumn()];
        pieces[from.getRow()][from.getColumn()] = null;
        updateBoard();
        return true;
    }

    @Override
    public Set<Position> getAllPiecePositions(boolean whitePlayer) {
        Set<Position> collection = new HashSet<>();
        for (int i = 0; i < pieces.length; i++) {
            for (int p = 0; p < pieces.length; p++) {
                if (pieces[i][p] != null && pieces[i][p].getIsWhite() == whitePlayer) {
                    collection.add(new Position(i, p));
                }
            }
        }
        return collection;
    }

    @Override
    public Piece get(Position position) {
        return this.pieces[position.getRow()][position.getColumn()];
    }

    private void updateBoard() {
        graphRefreshed = false;
    }

}
