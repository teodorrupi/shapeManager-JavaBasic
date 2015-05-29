package com.shapes.manager;

/**
 * Created by Teodor on 5/28/2015.
 */
public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Empty coordinate constructor
     * Initializing x and y values
     */
    public Coordinate(){
        this.x=0;
        this.y=0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setCoordinates(int x, int y){
        this.x=x;
        this.y=y;
    }

    public void print(){
        System.out.print("x:"+x+"y:"+y+" ");
    }
}
