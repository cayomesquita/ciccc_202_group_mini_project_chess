package ca.ciccc.chess.board;

public abstract class BoardAbstract implements Board {

    public static final int LENGTH_BOARD = 8;

    char[][] position;

    @Override
    public void print() {
        for (int i = 0; i < position.length; i++) {
            for (int j = 0; j < position[i].length; j++) {
                System.out.print(position[i][j]);
            }
            System.out.println();
        }
    }

    @Override
    public int size() {
        return LENGTH_BOARD;
    }
}
