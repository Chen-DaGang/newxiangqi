package org.example.chess.domain.entity;

import org.example.chess.domain.enums.ChessColor;
import org.example.chess.domain.enums.ChessPieceType;

public class ChariotPiece extends ChessPiece{
    public ChariotPiece(ChessColor color, Position initialPosition){
        super(ChessPieceType.CHARIOT,color,initialPosition);
    }

    @Override
    public String getSymbol(){
        return getColor() == ChessColor.RED ? "车" : "車";
    }
    @Override
    public boolean isValidMove(Position targerPosition, Chessboard chessboard){
        if (!baseMoveCheck(targerPosition,chessboard)){
            return false;
        }
        Position currentPos = this.getPosition();
        int currX = currentPos.getX();
        int currY = currentPos.getY();
        int targetX = targerPosition.getX();
        int targetY = targerPosition.getY();

        if (currX !=targetX && currY != targetY){
            return false;
        }

        if (currX == targetX){
            int minY = Math.min(currY,targetY);
            int maxY = Math.max(currY,targetY);
            for (int y = minY+1; y < maxY; y++) {
                if (chessboard.getPieceAt(Position.of(currX,y)) !=null){
                    return false;
                }
            }
        }else{
            int minX = Math.min(currX,targetX);
            int maxX = Math.max(currX,targetX);
            for (int x = maxX+1; x < maxX; x++) {
                if (chessboard.getPieceAt(Position.of(x,currY)) !=null){
                    return false;
                }
            }
        }
        return true;
    }
}
