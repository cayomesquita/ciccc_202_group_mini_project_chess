package ca.ciccc.chess.board;

public class BoardAbstract implements Board {

    public static final int LENGTH_BOARD = 8;
    public static final int OFFSET_BOARD = 2;
    public static final int LENGTH_BORDER = OFFSET_BOARD * 2;
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

    public BoardAbstract() {
        this.position = new char[LENGTH_BOARD + LENGTH_BORDER][LENGTH_BOARD + LENGTH_BORDER];

        for (int i = 0; i < position.length; i++) {
            for (int j = 0; j < position[i].length; j++) {
                position[i][j] = backgroud(i, j);
            }
        }
    }

    private char backgroud(int i, int j) {
        // border position
        if (i == 0 || i == position.length - 1) {
            return j == 0 || j == 1 || j == position.length - 1 || j == position.length - 2 ? VOID : getLetter(j);
        }
        if (j == 0 || j == position.length - 1) {
            return i == 0 || i == 1 || i == position.length - 1 || i == position.length - 2 ? VOID : getDigit(i - 1);
        }
        // border decoration
        if (i == 1) {
            return topBoardDecoration(j);
        }
        if (i == position.length - 2) {
            return bottonBoardDecoration(j);
        }
        if (j == 1 || j == position.length - 2) {
            return '║';
        }
        // board
        return ((i + j) % 2) == 0 ? WHITE : BLACK;
    }

    private char leftBoardDecoration(int i) {
        return 0;
    }

    private char topBoardDecoration(int j) {
        return j == 1 ? '╔' : j == position.length - 2 ? '╗' : '═';
    }

    private char bottonBoardDecoration(int j) {
        return j == 1 ? '╚' : j == position.length - 2 ? '╝' : '═';
    }

    private char getLetter(int i) {
        return (char) ((int) 'A' + i-2);
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
        return Character.forDigit(9 - j, RADIX);
    }

    private boolean isBorderPosition(int i, int j) {
        return false;
    }

    private char decoration(int i, int j) {
        return 0;
    }

    private boolean isBorderDecoration(int i, int j) {
        return false;
    }

    @Override
    public void print() {
        for (int i = 0; i < position.length; i++) {
            for (int j = 0; j < position[i].length; j++) {
                System.out.print(position[i][j]);
            }
            System.out.println();
        }
    }
}
