package org.example.chess.domain.enums;

public enum ChessPieceType {
    GENERAL("将/帅"),
    CHARIOT("车"),
    HORSE("马"),
    CANNON("炮"),
    ELEPHANT("象/相"),
    ADVISOR("士/仕"),
    SOLDIER("兵/卒");

    private final String desc;

    ChessPieceType(String desc){
        this.desc=desc;
    }

    public String getDesc(){
        return desc;
    }
}
