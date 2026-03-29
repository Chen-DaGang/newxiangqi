package org.example.chess.domain.entity;

import org.example.chess.domain.enums.ChessColor;
import org.example.chess.domain.enums.ChessPieceType;

public class HorsePiece extends ChessPiece{
    public HorsePiece(ChessColor color,Position position){
        super(ChessPieceType.HORSE,color,position);
    }
    @Override
    public String getSymbol(){
        return getColor() == ChessColor.RED ? "马" : "馬";
    }

    @Override
    public boolean isValidMove(Position target, Chessboard chessboard){
        //一样在父类方法里写
        int dx = Math.abs(target.getX() - getPosition().getX());
        int dy = Math.abs(target.getY()- getPosition().getY());

        if (!((dx == 1 && dy == 2) || (dx == 2 && dy == 1))){
            return false;
        }

        int legX = getPosition().getX();
        int legY = getPosition().getY();
        if (dx == 2){
            legX = (getPosition().getX() + target.getX())/2;
        }else {
            legY = (getPosition().getY() + target.getY()) /2;
        }

        Position legPos = Position.of(legX,legY);
        return chessboard.isEmpty(legPos);
    }

}
