package org.example.chess.domain.entity;

import org.example.chess.domain.enums.ChessColor;
import org.example.chess.domain.enums.ChessPieceType;

public class ChessPiece {
    private final ChessPieceType type;
    private final ChessColor color;
    private Position position;
    private boolean isAlive = true;

    public ChessPiece(ChessPieceType type, ChessColor color, Position initialPosition){
        this.type=type;
        this.color=color;
        this.position=initialPosition;
    }

    public void moveTo(Position targetPosition){
        if (!isAlive){
            throw new IllegalStateException("已死亡的棋子不能移动");
        }
        this.position = targetPosition;
    }
public boolean test(){
        return false;
}
    protected boolean baseMoveCheck(Position targerPosition, Chessboard chessboard){
        if (!isAlive){
            return false;
        }

        if (this.position.equals(targerPosition)){
            return false;
        }

        ChessPiece targetPiece = chessboard.getPieceAt(targerPosition);
        if (targerPosition != null && targetPiece.getColor()==this.color){
            return false;
        }

        return true;
    }

    public ChessPieceType getType() {return type;}

    public ChessColor getColor() {return color;}

    public Position getPosition() {return position;}

    public boolean isAlive() {return isAlive;}

    public void setAlive(boolean alive) {isAlive = alive;}

    @Override
    public String toString(){
        return color.getDesc() + type.getDesc() + "@" + position;
    }
}
