package org.example.chess.domain.entity;

import org.example.chess.domain.enums.ChessColor;
import org.example.chess.domain.enums.ChessPieceType;

public class ElephantPiece extends ChessPiece{

    public ElephantPiece(ChessColor color,Position position){
        super(ChessPieceType.ELEPHANT,color,position);
    }

    @Override
    public String getSymbol(){
        return getColor() == ChessColor.RED ? "相" : "象";
    }

    @Override
    public boolean isValidMove(Position target , Chessboard chessboard){
        //这里在父类写baseMoveCheck的判断，然后super 就不用每个子类都写了
        int dx = Math.abs(target.getX()- getPosition().getX());
        int dy = Math.abs(target.getY())- getPosition().getY();

        if (dx != 2 || dy != 2){
            return false;
        }

        if ((getColor()==ChessColor.RED && target.isInBlackRiverArea())
            || (getColor() == ChessColor.BLACK && target.isInRedRiverArea())){
            return false;
        }

        int midX = (getPosition().getX()+ target.getX()) /2;
        int midY = (getPosition().getY() + target.getY()) /2;
        Position center = Position.of(midX,midY);
        return  chessboard.isEmpty(center);
    }
}
