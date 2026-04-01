package org.example.chess.domain.entity;

import org.example.chess.domain.enums.ChessColor;
import org.example.chess.domain.enums.ChessPieceType;

public class CannonPiece extends ChessPiece{
    public CannonPiece(ChessColor color,Position position){
        super(ChessPieceType.CANNON,color,position);
    }

    @Override
    public String getSymbol(){
        return getColor() == ChessColor.RED ? "炮" : "砲";
    }

    @Override
    public boolean isValidMove(Position target, Chessboard chessboard){
        //依旧写在父类
        int currX = getPosition().getX();
        int currY = getPosition().getY();
        int toX = target.getX();
        int toY = target.getY();

        if (currX != toX && currY != toY){
            return false;
        }
        int count = 0;
        if (currX == toX){
            int min = Math.min(currY,toY)+1;
            int max = Math.max(currY,toY);
            for (int y = min; y < max; y++) {
                if (! chessboard.isEmpty(Position.of(currX,y))) count++;
            }
        }else {
            int min = Math.min(currX,toY)+1;
            int max = Math.max(currX,toY);
            for (int x = min; x < max; x++) {
                if (! chessboard.isEmpty(Position.of(x,currY))) count++;
            }
        }

        boolean targetEmpty = chessboard.isEmpty(target);
        return targetEmpty ? count == 0 : count==1;
    }
}
