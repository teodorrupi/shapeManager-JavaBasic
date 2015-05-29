package com.shapes.manager;

import java.util.List;

/**
 * Abstract Class Shape
 *
 * Shape is the superclass for all the shapes to be designed such as Rectangle, Line, Square.
 * Shape is abstract so that Java does not allows us to create a Shape object, since its not a real object
 * to be place on the Area2D class.
 */
public abstract class Shape {

    public List<Coordinate> coordinateList;
    public String shapeName;
    public String type;

    public void print(){
        System.out.print("This is a shape");
    }
}
