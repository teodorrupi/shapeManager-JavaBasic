package com.shapes.manager;

import java.util.List;

/**
 * Class Rectangle extending Shape class
 *
 * Rectangle is a subclass of Shape class, representing the rectangles shapes on the 2DArea.
 * By extending Shape, we provide SuperClass-SubClass hierarchy.
 */
public class Rectangle extends Shape {

    /**
     * Boolean to set if shape if filled to true or false
     */
    private Boolean shapeIsFilled;

    /**
     * Value of fill for this shape
     */
    private String fill;

    /**
     * Value of A length in AxB rectangle
     */
    private int height;

    /**
     * Value of B length in AxA square
     */
    private int width;


    /**
     * constructor to initialize parameters to default
     */
    public Rectangle(String name, List<Coordinate> coordinateList){
        this.coordinateList = coordinateList;
        this.shapeName= name;
        shapeIsFilled=false;
        fill="none";
        this.type="Rectangle";
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

    public void print(){
        System.out.print("IsFilled: " + shapeIsFilled + "   " + "Fill: " + fill);
    }
}
