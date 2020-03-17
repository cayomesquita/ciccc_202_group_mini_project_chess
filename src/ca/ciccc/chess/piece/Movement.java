package ca.ciccc.chess.piece;

public class Movement {
    private Position starting;
    private Position arrival;

    public Movement(Position starting, Position arrival) {
        this.starting = starting;
        this.arrival = arrival;
    }

    public static Movement getMovement(String userInput) throws Exception {
        char[] letters = userInput.toCharArray();
        if (letters == null || letters.length != 4) {
            throw new Exception("Invalid input for movement.");
        }
        int index = 0;
        Position starting = Position.parseBoardPosition(letters[index++], letters[index++]);
        Position arrival = Position.parseBoardPosition(letters[index++], letters[index]);
        return new Movement(starting, arrival);
    }


}

