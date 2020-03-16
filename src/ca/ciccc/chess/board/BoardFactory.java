package ca.ciccc.chess.board;

public final class BoardFactory {

    public static Board createBasicChessBoard(){
        return new ChessBoardBasic();
    }
}
