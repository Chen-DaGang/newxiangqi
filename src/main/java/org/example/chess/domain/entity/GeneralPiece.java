package org.example.chess.domain.entity;

import org.example.chess.domain.enums.ChessColor;
import org.example.chess.domain.enums.ChessPieceType;

public class GeneralPiece extends ChessPiece {
    public GeneralPiece(ChessColor color, Position position) {
        super(ChessPieceType.GENERAL, color, position);
    }
    @Override
    public String getSymbol(){
        return getColor() == ChessColor.RED ? "帅" : "将";
    }
    @Override
    public boolean isValidMove(Position target, Chessboard chessboard){
        if (!baseMoveCheck(target,chessboard)){
            return false;
        }

        int dx = Math.abs(target.getX() - getPosition().getX());
        int dy = Math.abs(target.getY() - getPosition().getY());

        boolean isOneStep = (dx == 1 && dy == 0) || (dx == 0 && dy == 1);
        if (! isOneStep){
            return false;
        }
        if (getColor() ==ChessColor.RED){
            return target.isInRedPalace();
        }else {
            return target.isInBlackPalace();
        }
    }
}

