package org.example.chess.domain.enums;

public enum ChessColor {
    RED("红方"),
    BLACK("黑方");

    private final String desc;

    ChessColor(String desc){
        this.desc=desc;
    }

    public String getDesc(){
        return desc;
    }
}
