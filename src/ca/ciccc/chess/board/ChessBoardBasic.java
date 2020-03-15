package ca.ciccc.chess.board;

import ca.ciccc.chess.piece.Piece;
import ca.ciccc.chess.piece.Position;

import java.util.*;

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

    char[][] position;

    public ChessBoardBasic() {
        this.position = new char[LENGTH_BOARD][LENGTH_BOARD];

        loadBoard(Collections.emptyList());
    }

    private void loadBoard(Collection<Piece> pieces) {
        final PriorityQueue<Piece> orderedPieces = new PriorityQueue<Piece>(Comparator.comparing(Piece::getPosition, (p1, p2) -> Integer.compare(p1.getX(), p2.getX()))
                .thenComparing(Piece::getPosition, (p1, p2) -> Integer.compare(p1.getY(), p2.getY())));
        pieces.forEach(piece -> orderedPieces.add(piece));
        Piece piece = orderedPieces.poll();
        for (int row = 0; row < position.length; row++) {
            for (int collumn = 0; collumn < position[row].length; collumn++) {
                if (piece != null && piece.getPosition().getXBoard() == collumn && piece.getPosition().getYBoard() == row) {
                    position[row][collumn] = piece.getPiece();
                } else {
                    position[row][collumn] = backgroud(row, collumn);
                }
            }
        }
    }


    private char backgroud(int i, int j) {
        return ((i + j) % 2) == 0 ? WHITE : BLACK;
    }

    private char topBoardDecoration(int j) {
        return j == 1 ? '╔' : j == position.length - 2 ? '╗' : '═';
    }

    private char bottonBoardDecoration(int j) {
        return j == 1 ? '╚' : j == position.length - 2 ? '╝' : '═';
    }

    private char getLetter(int i) {
        return (char) ((int) 'J' - i);
    }

    private char position(int i, int j) {
        if (i == 0 || i == position.length - 1) {
            return j == 0 || j == position.length - 1 ? VOID : getDigit(j);
        }
        if (i == 1 || i == position.length - 2) {
            return j == 1 || j == position.length - 2 ? VOID : getDigit(j);
        }
        return 0;
    }

    private char getDigit(int j) {
        return Character.forDigit(j, RADIX);
    }

    @Override
    public void print() {
        for (int i = position.length - 1; i >= 0; i--) {
            for (int j = 0; j < position[i].length; j++) {
                System.out.print(position[i][j]);
            }
            System.out.println();
        }
    }

    @Override
    public void print(List<Piece> pieces) {
        loadBoard(pieces);
        print();
    }

}
