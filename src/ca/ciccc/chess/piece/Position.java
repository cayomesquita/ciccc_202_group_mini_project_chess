package ca.ciccc.chess.piece;

public class Position {
    int row;
    int collumn;

    public Position(String row, int collumn) throws Exception {
        int x2 = exchange(row);
        if (x2 >= 0 && x2 < 8 && collumn >= 0 && collumn < 8) {
            this.row = x2;
            this.collumn = collumn;
        }
    }

    public static Position parseBoardPosition(char letter, char number) throws Exception {
        return new Position(exchangeRow(letter), exchangeCollumn(number));
    }

    private static int exchangeCollumn(char number) throws Exception {
        if (number >= '1' && number <= '9') {
            return (char) (number - '1');
        }
        throw new Exception("Collumn out of range");
    }

    private static int exchangeRow(char letter) throws Exception {
        if (letter >= 'A' && letter <= 'H') {
            return (char) (letter - 'A');
        } else if (letter >= 'a' && letter <= 'h') {
            return (char) (letter - 'a');
        }
        throw new Exception("Row out of range");
    }

    public Position(int row, int collumn) {
        this.row = row;
        this.collumn = collumn;
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
    public int getRow() {
        return row;
    }

    public int getCollumn() {
        return collumn;
    }

    // setter
    public void setRow(int row) {
        this.row = row;
    }

    public void setCollumn(int collumn) {
        this.collumn = collumn;
    }
}

