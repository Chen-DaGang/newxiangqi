package org.example.chess.domain.entity;

import org.example.chess.domain.ChessPieceLocation;
import org.example.chess.domain.enums.ChessColor;

import java.util.HashMap;
import java.util.Map;

public class Chessboard {

    public static final int COLUMNS = 9;
    public  static final int ROWS = 10;

    private final ChessPiece[][] board;

    public Chessboard(){
        board = new ChessPiece[COLUMNS][ROWS];
        initDefaultChessPieces();
    }

    public void initDefaultChessPieces(){
        clearBoard();

        board[0][0] = new ChariotPiece(ChessColor.BLACK, Position.of(0,0));
        board[8][0] = new ChariotPiece(ChessColor.BLACK, Position.of(8,0));

        board[1][0] = new HorsePiece(ChessColor.BLACK, Position.of(1,0));
        board[7][0] = new HorsePiece(ChessColor.BLACK, Position.of(7,0));

        board[2][0] = new ElephantPiece(ChessColor.BLACK, Position.of(2,0));
        board[6][0] = new ElephantPiece(ChessColor.BLACK, Position.of(6,0));

        board[3][0] = new AdvisorPiece(ChessColor.BLACK, Position.of(3,0));
        board[5][0] = new AdvisorPiece(ChessColor.BLACK, Position.of(5,0));

        board[4][0] = new GeneralPiece(ChessColor.BLACK, Position.of(4,0));

        board[1][2] = new CannonPiece(ChessColor.BLACK, Position.of(1,2));
        board[7][2] = new CannonPiece(ChessColor.BLACK, Position.of(7,2));

        board[0][3] = new SoldierPiece(ChessColor.BLACK, Position.of(0,3));
        board[2][3] = new SoldierPiece(ChessColor.BLACK, Position.of(2,3));
        board[4][3] = new SoldierPiece(ChessColor.BLACK, Position.of(4,3));
        board[6][3] = new SoldierPiece(ChessColor.BLACK, Position.of(6,3));
        board[8][3] = new SoldierPiece(ChessColor.BLACK, Position.of(8,3));


        board[0][9] = new ChariotPiece(ChessColor.RED, Position.of(0,9));
        board[8][9] = new ChariotPiece(ChessColor.RED, Position.of(8,9));

        board[1][9] = new HorsePiece(ChessColor.RED, Position.of(1,9));
        board[7][9] = new HorsePiece(ChessColor.RED, Position.of(7,9));


        board[2][9] = new ElephantPiece(ChessColor.RED, Position.of(2,9));
        board[6][9] = new ElephantPiece(ChessColor.RED, Position.of(6,9));

        board[3][9] = new AdvisorPiece(ChessColor.RED, Position.of(3,9));
        board[5][9] = new AdvisorPiece(ChessColor.RED, Position.of(5,9));

        board[4][9] = new GeneralPiece(ChessColor.RED, Position.of(3,9));

        board[1][7] = new CannonPiece(ChessColor.RED, Position.of(1,7));
        board[7][7] = new CannonPiece(ChessColor.RED, Position.of(7,7));

        board[0][6] = new SoldierPiece(ChessColor.RED, Position.of(0,6));
        board[2][6] = new SoldierPiece(ChessColor.RED, Position.of(2,6));
        board[4][6] = new SoldierPiece(ChessColor.RED, Position.of(4,6));
        board[6][6] = new SoldierPiece(ChessColor.RED, Position.of(6,6));
        board[8][6] = new SoldierPiece(ChessColor.RED, Position.of(8,6));
    }

    public ChessPiece getPieceAt(Position position){
        if (!isInsideBoard(position)) return null;
        return board[position.getX()][position.getY()];
    }

    public boolean isEmpty(Position position){
        return getPieceAt(position)==null;
    }

    public void setPieceAt(Position position,ChessPiece piece){
        if (isInsideBoard(position)){
            board[position.getX()][position.getY()] = piece;
        }
    }

    public void removePieceAt(Position position){
        if (isInsideBoard(position)){
            board[position.getX()][position.getY()] = null;
        }
    }

    //这里是判断加行动了
    public boolean movePiece(Position from, Position to){
        ChessPiece movingPiece = getPieceAt(from);
        if (movingPiece == null) return false;

        ChessPiece targrtPiece = getPieceAt(to);
        if (targrtPiece != null){
            if (targrtPiece.getColor() == movingPiece.getColor()){
                return false;
            }
            targrtPiece.setAlive(false);
        }
        removePieceAt(from);
        setPieceAt(to,movingPiece);
        movingPiece.moveTo(to);

        return true;
    }

    public boolean isInsideBoard(Position position){
        int x = position.getX();
        int y = position.getY();
        return x >= 0 && x < COLUMNS && y >=0 && y < ROWS;
    }
    public void clearBoard(){
        for (int x = 0; x < COLUMNS; x++) {
            for (int y = 0; y < ROWS; y++) {
                board[x][y] = null;
            }
        }
    }

    public void paintConsoleBoard(){
        System.out.println("=================中国象棋==================");
        for (int y = 0; y < ROWS; y++) {
            for (int x = 0; x < COLUMNS; x++) {
                ChessPiece piece = board[x][y];
                if (piece == null){
                    System.out.print(" .\t");
                }else {
                    System.out.print(piece.getSymbol() + "\t");
                }
            }
            System.out.println();
        }
        System.out.println("===========================================");
    }
    public ChessPiece[][] getBoardArray(){
        return board;
    }

    public java.util.List<ChessPieceLocation> getAllPieceLocations(){
        java.util.List<ChessPieceLocation> list = new java.util.ArrayList<>();

        for (int x = 0; x < COLUMNS; x++) {
            for (int y = 0; y < ROWS; y++) {
                ChessPiece piece = board[x][y];
                if (piece != null && piece.isAlive()){
                    list.add(new ChessPieceLocation(piece.getSymbol(),piece.getPosition()));
                }
            }
        }
        return list;
    }
}