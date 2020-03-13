package ca.ciccc.chess.piece;

public class Position {
    int x;
    int y;

    public Position(String x, int y) throws Exception {
        int x2 = exchange(x);
        if (x2 >= 0 && x2 < 8 && y >= 0 && y < 8) {
            this.x = x2;
            this.y = y;
        }
    }

    private int exchange(String x) throws Exception {
        switch (x) {
            case "A":
                return 0;
            case "B":
                return 1;
            case "C":
                return 2;
            case "D":
                return 3;
            case "E":
                return 4;
            case "F":
                return 5;
            case "G":
                return 6;
            case "H":
                return 7;
            default:
                throw new Exception("Invalid letter. Type 'A' to 'H'");
        }
    }

    // getter
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    // setter
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
}

