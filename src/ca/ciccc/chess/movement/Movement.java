package ca.ciccc.chess.movement;

import ca.ciccc.chess.piece.Position;

import java.util.Objects;

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

    public Position getStarting() {
        return starting;
    }

    public Position getArrival() {
        return arrival;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movement movement = (Movement) o;
        return starting.equals(movement.starting) &&
                arrival.equals(movement.arrival);
    }

    @Override
    public int hashCode() {
        return Objects.hash(starting, arrival);
    }

    @Override
    public String toString() {
        return "[" +
                starting +
                ", " + arrival +
                ']';
    }
}

