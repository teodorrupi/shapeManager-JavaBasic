package com.shapes.manager;

import java.util.List;

/**
 * Class Line extending Shape class
 *
 * Line is a subclass of Shape class, representing the line shapes on the 2DArea.
 * By extending Shape, we provide SuperClass-SubClass hierarchy.
 */
public class Line extends Shape {

    /**
     * constructor to initialize parameters to default
     */
    public Line(String name, List<Coordinate> coordinateList){
        this.coordinateList = coordinateList;
        this.shapeName= name;
        this.type="Line";
    }

}
