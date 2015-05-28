package com.shapes.manager;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Area2D
 *
 * Initializes a 2D area with already-set wxh to 25x80.
 * Saves the shapes in a List of shapes
 * Manages initializations of the Shape Class Hierarchy with its subclasses.
 */
public class Area2D {
    private List<Shape> shapeList;
    private int width;
    private int height;

    public Area2D(){
        shapeList = new ArrayList<Shape>();
        width = 25;
        height = 80;
    }

    public List<Shape> getShapeList() {
        return shapeList;
    }

    public void setShapeList(List<Shape> shapeList) {
        this.shapeList = shapeList;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void addShape(Shape shape){

    }
}
