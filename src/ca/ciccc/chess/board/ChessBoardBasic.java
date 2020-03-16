package ca.ciccc.chess.board;

import ca.ciccc.chess.piece.Piece;
import ca.ciccc.chess.piece.Position;

public class ChessBoardBasic extends BoardAbstract {

    public static final int LENGTH_BOARD = 8;
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
        this.boardGraph = new char[LENGTH_BOARD][LENGTH_BOARD];
        this.pieces = new Piece[LENGTH_BOARD][LENGTH_BOARD];
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
        this.pieces[position.getRow()][position.getCollumn()] = piece;
        updateBoard();
    }

    @Override
    public void move(Position from, Position to) throws Exception {
        if (pieces[from.getRow()][from.getCollumn()] == null) {
            throw new Exception("Invalid input. The position does not have a piece");
        } else if (pieces[to.getRow()][to.getCollumn()].getIsWhite() == pieces[from.getRow()][from.getCollumn()].getIsWhite()) {
            throw new Exception("Invalid input. The same color piece is in the new position.");
        }

        pieces[to.getRow()][to.getCollumn()] = pieces[from.getRow()][from.getCollumn()];
        pieces[from.getRow()][from.getCollumn()] = null;
        updateBoard();
    }

    private void updateBoard() {
        graphRefreshed = false;
    }

}
