package com.shapes.manager;

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
     * Empty constructor to initialize parameters to default
     */
    public Rectangle(){
        shapeIsFilled=false;
        fill="none";
    }

    /**
     * Constructor to initialize parameters to inserted values
     */
    public Rectangle(Boolean shapeIsFilled, String fill){
        this.shapeIsFilled=shapeIsFilled;
        this.fill=fill;
    }

}
