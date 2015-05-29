package com.shapes.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    private int[][] areaPixels = new int[25][80];
    private int width;
    private int height;

    public Area2D(){
        shapeList = new ArrayList<Shape>();
        width = 25;
        height = 80;

        //initializing drawn area
        for(int x=0; x<25; x++){
            for(int y=0; y<80; y++){
                areaPixels[x][y]=0;
            }
        }
    }

    public List<Shape> getShapeList() {
        return shapeList;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void addShape(Shape shape){
        for(Shape a : shapeList){
            if (shape.shapeName.equalsIgnoreCase(a.shapeName)){
                System.out.print("Please choose another name this one is there already\n");
            }
        }
        shapeList.add(shape);
        if (!drawShape(shape, 1)){
            System.out.print("Shape can not be drawn. Check your coordinates. Max x=24, Max y=79\n");
        }
    }

    public void modifyShapeFill(Shape shape, String value){
        if (!drawShape(shape, Integer.getInteger(value))){
            System.out.print("Shape can not be modified. Check your coordinates. Max x=24, Max y=79\n");
        };
    }

    public void drawArea(){
        if(shapeList.size()==0){
            System.out.print("Area is empty\n");
        }

        for(int x=0; x<25; x++){
            for(int y=0; y<80; y++){
                System.out.print(areaPixels[x][y]);
            }
            System.out.print("\n");
        }
    }

    public void cleanArea(){
        shapeList.clear();
        for(int x=0; x<25; x++){
            for(int y=0; y<80; y++){
                areaPixels[x][y]=0;
            }
        }
    }

    public boolean drawShape(Shape shape, int value){
        List<Coordinate> shapeCordList = shape.coordinateList;
        int maxX = 0, maxY =0, minX =0, minY =0;
        List<Integer> XCords = new ArrayList<Integer>();
        List<Integer> YCords = new ArrayList<Integer>();
        for(Coordinate a : shapeCordList){
            XCords.add(a.getX());
            YCords.add(a.getY());
        }

        Collections.sort(XCords);
        if(XCords.get(XCords.size() -1) > 24){
            return false;
        }
        Collections.sort(YCords);
        if(YCords.get(XCords.size() -1) > 79){
            return false;
        }

        for(int x=YCords.get(0); x<=YCords.get(YCords.size() -1); x++){
            for(int y=XCords.get(0); y<=XCords.get(XCords.size() -1); y++){
                areaPixels[x][y]=value;
            }
        }

        return true;
    }

    public void printShapeList(){
        for(Shape a : shapeList){
            System.out.print(a.shapeName + " " + a.type + "\nCoordinates: \n");
            for(Coordinate x: a.coordinateList){
                x.print();
            }
            System.out.print("\n");
            a.print();
        }
        System.out.print("\n");
    }

    public void modifyShape(String[] commands){
        Shape toModify=null;
        for (Shape a : shapeList){
            if(a.shapeName.equalsIgnoreCase(commands[0])){
                toModify=a;
            }
        }

        if(toModify==null){
            System.out.print("Shape name not found\n");
            return;
        }

        if(toModify.type.equalsIgnoreCase("Line")){
            if(commands.length==5){
                List<Coordinate> clist1 = new ArrayList<Coordinate>();
                clist1.add(new Coordinate(Integer.parseInt(commands[1]), Integer.parseInt(commands[2])));
                clist1.add(new Coordinate(Integer.parseInt(commands[3]), Integer.parseInt(commands[4])));
                if(Integer.parseInt(commands[1])!= Integer.parseInt(commands[3]) && Integer.parseInt(commands[2])!= Integer.parseInt(commands[4])){
                    System.out.print("Cant draw line. Either horizontal or vertical, not diagonal lines. Check your coordinates!\n");
                    return;
                }
                shapeList.remove(toModify);
                shapeList.add(new Line(commands[0], clist1));
            }
            else{
                System.out.print("Input error\n");
                return;
            }
        }

        if(toModify.type.equalsIgnoreCase("Rectangle") || toModify.type.equalsIgnoreCase("Square")){
            if(commands.length>2 && commands.length<10){
                if(commands.length==9){
                    List<Coordinate> clist2 = new ArrayList<Coordinate>();
                    clist2.add(new Coordinate(Integer.parseInt(commands[1]), Integer.parseInt(commands[2])));
                    clist2.add(new Coordinate(Integer.parseInt(commands[3]), Integer.parseInt(commands[4])));
                    clist2.add(new Coordinate(Integer.parseInt(commands[5]), Integer.parseInt(commands[6])));
                    clist2.add(new Coordinate(Integer.parseInt(commands[7]), Integer.parseInt(commands[8])));
                    if(toModify.type.equalsIgnoreCase("Rectangle")){
                        shapeList.remove(toModify);
                        shapeList.add(new Rectangle(commands[0], clist2));
                    }
                    else{
                        shapeList.remove(toModify);
                        shapeList.add(new Square(commands[0], clist2));
                    }
                }
                else{

                    if(commands[1].equalsIgnoreCase("isfill")){
                        if(toModify instanceof Square){
                            Square sq = (Square) toModify;
                            sq.setShapeIsFilled(Boolean.getBoolean(commands[2]));
                        }

                        if(toModify instanceof Rectangle){
                            Rectangle re = (Rectangle) toModify;
                            re.setShapeIsFilled(Boolean.getBoolean(commands[2]));
                        }
                    }

                    else if(commands[1].equalsIgnoreCase("fill")){
                        if(toModify instanceof Square){
                            Square sq = (Square) toModify;
                            sq.setFill(commands[2]);
                            modifyShapeFill(sq, sq.getFill());

                        }

                        if(toModify instanceof Rectangle){
                            Rectangle re = (Rectangle) toModify;
                            re.setFill(commands[2]);
                            modifyShapeFill(re, re.getFill());
                        }
                    }
                    else{
                        System.out.print("\nCommand Error\n");
                    }
                }
            }
            else{
                System.out.print("Input error");
                return;
            }
        }
    }
}
