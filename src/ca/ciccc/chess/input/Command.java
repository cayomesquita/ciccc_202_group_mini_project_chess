package ca.ciccc.chess.input;

public class Command {

    public static final String CMD_HELP = "help";
    public static final String CMD_BOARD = "board";
    public static final String CMD_RESIGN = "resign";
    public static final String CMD_MOVES = "moves";
    public static final String CMD_SQUARE = "square";
    public static final String CMD_UCI_MOVE = "uci_move";

    private String command;
    private Object payload;

    public Command(String command) {
        this.command = command;
    }
    public Command(String command, Object payload) {
        this(command);
        this.payload = payload;
    }

    public String getCommand() {
        return command;
    }

    public Object getPayload() {
        return payload;
    }
}
