package org.example.chess.domain.entity;

import org.example.chess.domain.enums.ChessColor;
import org.example.chess.domain.enums.ChessPieceType;

public class SoldierPiece extends ChessPiece{
    public SoldierPiece(ChessColor color,Position position){
        super(ChessPieceType.SOLDIER,color,position);
    }

    @Override
    public String getSymbol(){
        return getColor() == ChessColor.RED? "兵" : "卒";
    }

    @Override
    public boolean isValidMove(Position target, Chessboard chessboard){
        //依旧写在父类
        int currY = getPosition().getY();
        int toY = target.getY();
        int dx = Math.abs(target.getX() - getPosition().getX());
        int dy = toY - currY;

        boolean isRed = getColor() == ChessColor.RED;
        boolean crossRiver = isRed ? currY <=4 : currY >= 5;

        if (!crossRiver){
            return isRed ? (dx == 0 && dy == -1) : (dx == 0 && dy == 1);
        }
        return isRed
                ? (dx == 1 && dy == 0) || (dx == 0 && dy == -1)
                : (dx == 1 && dy == 0) || (dx == 0 && dy == 1);
    }
}
