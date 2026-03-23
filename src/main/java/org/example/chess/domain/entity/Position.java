package org.example.chess.domain.entity;

public class Position {
    public static final int MIN_X = 0;
    public static final int MAX_X = 8;
    public static final int MIN_Y = 0;
    public static final int MAX_Y = 9;

    private final int x;
    private final int y;

    private Position(int x, int y){
        if (!isValidX(x) || !isValidY(y)){
            throw new IllegalArgumentException("非法坐标！当前：(" + x + "," + y + ")");
        }
        this.x = x;
        this.y = y;
    }
    public static Position of(int x, int y){//of?
        return new Position(x,y);
    }
    public static boolean isValidX(int x){
        return x >=MIN_X && x <= MAX_X;
    }
    public static boolean isValidY(int y){
        return y >=MIN_Y && y<= MAX_Y;
    }
    public boolean isInRedPalace(){
        return x >= 3 && x<= 5 && y>=7 && y<= 9;
    }
    public boolean isInBlackPalace(){
        return x >= 3 && x<= 5 && y>=0 && y<=2;
    }
    public boolean isInRedRiverArea(){
        return y<=4;
    }
    public boolean isInBlackRiverArea(){
        return y>=5;
    }


    @Override
    public boolean equals(Object o){
        if (this==o) return true;
        if (o==null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode(){
        return java.util.Objects.hash(x,y);  //?
    }

    @Override
    public String toString(){
        return "("+ x + ","+ y +")";
    }

    public int getY(){
        return y;
    }

    public String test(){
        return "I am NPC.";
    }
}
