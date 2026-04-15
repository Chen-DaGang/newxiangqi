package org.example.chess.game;

import org.example.chess.domain.entity.ChessPiece;
import org.example.chess.domain.entity.Chessboard;
import org.example.chess.domain.entity.Position;

public class Move {
    public static boolean isMoveValid(Chessboard chessboard, Position from, Position to){
        ChessPiece piece = chessboard.getPieceAt(from);
        if (piece == null){
            return false;
        }
        if (!piece.isValidMove(to,chessboard)){
            return false;
        }
        return chessboard.movePiece(from,to);
    }

}
