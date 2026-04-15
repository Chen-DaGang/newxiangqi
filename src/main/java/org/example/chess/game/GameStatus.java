package org.example.chess.game;

public class GameStatus {
    public static final int STATUS_READY = 0;
    public static final int STATUS_PLAYING = 1;
    public static final int STATUS_OVER = 2;

    private final Player[] players;
    private int currentPlayerIndex;
    private int gameStatus;
    private int winner= -1;
    private int noCaptureSteps = 0;

    public GameStatus(Player player1, Player player2){
        this.players = new Player[]{player1,player2};
        this.currentPlayerIndex=0;
        this.gameStatus = STATUS_READY;
    }

    public Player[] getPlayers(){return players;}
    public int getCurrentPlayerIndex() { return currentPlayerIndex; }
    public int getGameStatus() { return gameStatus; }
    public void setGameStatus(int gameStatus) { this.gameStatus = gameStatus; }
    public int getWinner() { return winner; }
    public void setWinner(int winner) { this.winner = winner; }
    public int getNoCaptureSteps() { return noCaptureSteps; }
    public void incrementNoCaptureSteps() { noCaptureSteps++; }
    public void resetNoCaptureSteps() { noCaptureSteps = 0; }
}
