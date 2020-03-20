package ca.ciccc.chess.piece;

import java.util.Objects;

public class Position {
    int row;
    int column;

    public Position(String row, int column) throws Exception {
        int x2 = exchange(row);
        if (x2 >= 0 && x2 < 8 && column >= 0 && column < 8) {
            this.row = x2;
            this.column = column;
        }
    }

    public static Position parseBoardPosition(char letter, char number) throws Exception {
        return new Position(exchangeRow(number), exchangeCollumn(letter));
    }

    private static int exchangeCollumn(char letter) throws Exception {
        if (letter >= 'A' && letter <= 'H') {
            return (char) (letter - 'A');
        } else if (letter >= 'a' && letter <= 'h') {
            return (char) (letter - 'a');
        }
        throw new Exception("Row out of range");
    }

    private static int exchangeRow(char letter) throws Exception {
        if (letter >= '1' && letter <= '9') {
            return (char) (letter - '1');
        }
        throw new Exception("Collumn out of range");
    }

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
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

    public int getColumn() {
        return column;
    }

    // setter
    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return row == position.row &&
                column == position.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    @Override
    public String toString() {
        return String.format("%s%s", formatDigit(column), formatLetter(row));
    }

    private char formatLetter(int row) {
        return (char) ('1' + row);
    }

    private char formatDigit(int collumn) {
        return (char) ('a' + collumn);
    }
}

