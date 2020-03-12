package ca.ciccc.chess.board;

public final class BoardFactory {

    public static Board createChessBoard(){
        return new ChessBoardBasic();
    }
}
