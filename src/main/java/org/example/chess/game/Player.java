package org.example.chess.game;

import org.example.chess.domain.enums.ChessColor;

public class Player {
    private final int id;
    private final String name;
    private final ChessColor color;

    public Player (int id, String name, ChessColor color){
        this.id = id;
        this.name = name;
        this.color = color;
    }
    public int getId(){return id;}
    public String getName(){return name;}
    public ChessColor getColor(){return color;}
}
