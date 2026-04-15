package org.example.chess.handle;

import org.example.chess.domain.entity.Chessboard;
import org.example.chess.domain.entity.Position;
import org.example.chess.game.GameStatus;
import org.example.chess.game.MoveHandler;
import org.example.chess.game.Player;

public class Handle {

    private static Chessboard chessboard;
    private static GameStatus gameStatus;

    public Handle(){
        //TODO
    }

    private static int getPlayerIndex(Player player){
        Player[] players = gameStatus.getPlayers();
        for(int i = 0; i < 2; i++){
            if(players[i] == player){
                return i;
            }
        }

        return -1;
    }

    public static boolean move(Position begin, Position end) {
        return MoveHandler.isMoveValid(chessboard, begin, end);
    }

    public static void surrender(Player player) { //投降
        int loser = getPlayerIndex(player);
        int winner = (loser + 1) % 2;

        gameStatus.setWinner(winner);
        gameStatus.setGameStatus(GameStatus.STATUS_OVER);

    }

    public boolean askPeace(Player player){
        int ask = getPlayerIndex(player);
        int answer = ( ask + 1 ) % 2;
        boolean result = false;

        //TODO

        return result;
    }

    public boolean regret(){
        return false;
        //TODO
    }

}