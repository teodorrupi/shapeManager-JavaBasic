package com.shapes.manager;

import java.util.List;

/**
 * Class Square extending Shape class
 *
 * Square is a subclass of Shape class, representing the square shapes on the 2DArea.
 * By extending Shape, we provide SuperClass-SubClass hierarchy.
 */
public class Square extends Shape {

    /**
     * Boolean to set if shape if filled to true or false
     */
    private Boolean shapeIsFilled;

    /**
     * Value of fill for this shape
     */
    private String fill;

    /**
     * Value of A length in AxA square
     */
    private int length;

    /**
     * constructor to initialize parameters to default
     */
    public Square(String name, List<Coordinate> coordinateList){
        this.coordinateList = coordinateList;
        this.shapeName= name;
        shapeIsFilled=false;
        fill="none";
        this.type="Square";
    }


    /**
     * Empty constructor to initialize parameters to default
     */
    public Square(){
        shapeIsFilled=false;
        fill="none";
    }

    /**
     * Constructor to initialize parameters to inserted values
     */
    public Square(Boolean shapeIsFilled, String fill){
        this.shapeIsFilled=shapeIsFilled;
        this.fill=fill;
    }

    public void print(){
        System.out.print("IsFilled: " + shapeIsFilled + "   " + "Fill: " + fill);
    }

    public Boolean getShapeIsFilled() {
        return shapeIsFilled;
    }

    public void setShapeIsFilled(Boolean shapeIsFilled) {
        this.shapeIsFilled = shapeIsFilled;
    }

    public String getFill() {
        return fill;
    }

    public void setFill(String fill) {
        this.fill = fill;
    }
}
