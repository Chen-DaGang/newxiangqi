package org.example.chess.domain.entity;

import org.example.chess.domain.enums.ChessColor;
import org.example.chess.domain.enums.ChessPieceType;

public class AdvisorPiece extends ChessPiece {
    public AdvisorPiece(ChessColor color, Position position) {
        super(ChessPieceType.ADVISOR, color, position);
    }

    @Override
    public String getSymbol() {
        return getColor() == ChessColor.RED ? "仕" : " 士";
    }

    @Override
    public boolean isValidMove(Position target, Chessboard chessboard) {
        if (!baseMoveCheck(target, chessboard)) {
            return false;
        }
        int dx = Math.abs(target.getX() - getPosition().getX());
        int dy = Math.abs(target.getY() - getPosition().getY());

        if (dx != 1 || dy != 1) {
            return false;
        }

        return getColor() == ChessColor.RED
                ? target.isInRedPalace()
                : target.isInBlackPalace();
    }
}
