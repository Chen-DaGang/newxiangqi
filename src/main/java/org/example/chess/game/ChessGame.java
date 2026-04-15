package org.example.chess.game;

import org.example.chess.domain.entity.Chessboard;
import org.example.chess.domain.entity.Position;

public class ChessGame {
    private final Chessboard chessboard;
    private final GameStatus status;

    public ChessGame(Player player1, Player player2){
        this.chessboard = new Chessboard();
        this.status = new GameStatus(player1,player2);
        this.status.setGameStatus(GameStatus.STATUS_PLAYING);
    }

    public boolean playerMove(int fromX, int fromY, int toX, int toY){
        if (status.getGameStatus()==GameStatus.STATUS_OVER){
            return false;
        }

        Position from = Position.of(fromX,fromY);
        Position to = Position.of(toX,toY);

        boolean success = Move.isMoveValid(chessboard,from,to);

        if (success){
            boolean hasCapture = chessboard.getPieceAt(to) != null;
            if (hasCapture){
                status.resetNoCaptureSteps();
            }else {
                status.incrementNoCaptureSteps();
            }
            status.switchPlayer();
        }
        return success;
    }
    public Chessboard getChessboard(){return chessboard;}
    public GameStatus getStatus(){return status;}
}
