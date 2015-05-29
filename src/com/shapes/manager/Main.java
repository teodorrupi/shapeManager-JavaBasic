package com.shapes.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        //inicializimi i nje hapsire 2d me sip. 25x80
	    Area2D area2D = new Area2D();

        String welcome = "" +
                "2D Area Manager\n" +
                "Space(default): " + area2D.getWidth() + "x" + area2D.getHeight() + "\n" +
                "Elements available: Line, Rectangle, Square\n";
        String elements_in_area = "" +
                "Elements in area: " + area2D.getShapeList().size() + "\n";
        String initial_command = "" +
                "Command list:\n" +
                "Press 1 -> Draw area()\n" +
                "Press 2 -> Add Line\n" +
                "Press 3 -> Add Rectangle\n" +
                "Press 4 -> Add Square\n" +
                "Press 5 -> Clean area()\n" +
                "Press 6 -> Modify shape\n" +
                "Press 7 -> exit()\n" +
                "Press 8 -> reportNumberOfElements\n" +
                ">>";
        String modify_command = "" +
                "\nModify line:\n" +
                "*Modify coordinates like: existingLineName,x1,y1,x2,y2\n" +
                "\nModify rectangle:\n" +
                "*Modify coordinates like: existingRectangleName,x1,y1,x2,y2,x3,y3,x4,y4\n" +
                "*Modify if filled like: existingRectangleName,isfill,true or existingRectangleName,isfill,false\n" +
                "*Modify fill like: existingRectangleName,fill,1 or existingRectangleName,fill,2 or existingRectangleName,fill,3 ...\n" +
                "\nModify square:\n" +
                "*Modify coordinates like: existingSquareName,x1,y1,x2,y2,x3,y3,x4,y4\n" +
                "*Modify if filled like: existingSquareName,isfill,true or existingSquareName,isfill,false\n" +
                "*Modify fill like: existingSquareName,fill,1 or existingSquareName,fill,2 or existingSquareName,fill,3 ...\n";
        System.out.print(welcome);
        System.out.print(elements_in_area);

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.print(initial_command);
            String x = scanner.nextLine();

            switch(x){
                case "1":
                    System.out.print("Drawing area ...\n");
                    area2D.drawArea();
                    break;
                case "2":
                    System.out.print("Adding line: Please enter coordinate like: name,x1,y1,x2,y2\n");
                    String line = scanner.nextLine();
                    String[] comp = line.split(",");
                    if (comp.length > 5){
                        System.out.print("Input Error, please try again!");
                        break;
                    }
                    List<Coordinate> clist1 = new ArrayList<Coordinate>();
                    clist1.add(new Coordinate(Integer.parseInt(comp[1]), Integer.parseInt(comp[2])));
                    clist1.add(new Coordinate(Integer.parseInt(comp[3]), Integer.parseInt(comp[4])));
                    if(Integer.parseInt(comp[1])!= Integer.parseInt(comp[3]) && Integer.parseInt(comp[2])!= Integer.parseInt(comp[4])){
                        System.out.print("Cant draw line. Either horizontal or vertical, not diagonal lines. Check your coordinates!\n");
                        break;
                    }
                    area2D.addShape(new Line(comp[0], clist1));
                    break;
                case "3":
                    System.out.print("Adding Rectangle: Please enter coordinates like: name,x1,y1,x2,y2,x3,y3,x4,y4\n");
                    String rectangle = scanner.nextLine();
                    String[] rcomp = rectangle.split(",");
                    if (rcomp.length > 9){
                        System.out.print("Input Error, please try again!");
                        break;
                    }
                    List<Coordinate> clist2 = new ArrayList<Coordinate>();
                    clist2.add(new Coordinate(Integer.parseInt(rcomp[1]), Integer.parseInt(rcomp[2])));
                    clist2.add(new Coordinate(Integer.parseInt(rcomp[3]), Integer.parseInt(rcomp[4])));
                    clist2.add(new Coordinate(Integer.parseInt(rcomp[5]), Integer.parseInt(rcomp[6])));
                    clist2.add(new Coordinate(Integer.parseInt(rcomp[7]), Integer.parseInt(rcomp[8])));
                    area2D.addShape(new Rectangle(rcomp[0], clist2));
                    break;
                case "4":
                    System.out.print("Adding Square: Please enter coordinates like: name,x1,y1,x2,y2,x3,y3,x4,y4\n");
                    String square = scanner.nextLine();
                    String[] scomp = square.split(",");
                    if (scomp.length > 9){
                        System.out.print("Input Error, please try again!");
                        break;
                    }
                    List<Coordinate> clist3 = new ArrayList<Coordinate>();
                    clist3.add(new Coordinate(Integer.parseInt(scomp[1]), Integer.parseInt(scomp[2])));
                    clist3.add(new Coordinate(Integer.parseInt(scomp[3]), Integer.parseInt(scomp[4])));
                    clist3.add(new Coordinate(Integer.parseInt(scomp[5]), Integer.parseInt(scomp[6])));
                    clist3.add(new Coordinate(Integer.parseInt(scomp[7]), Integer.parseInt(scomp[8])));
                    area2D.addShape(new Square(scomp[0], clist3));
                    break;
                case "5":
                    System.out.print("Area cleaned ...\n");
                    area2D.cleanArea();
                    break;
                case "6":
                    System.out.print("Available Shapes: ...\n");
                    area2D.printShapeList();
                    System.out.print(modify_command);
                    String command_modify = scanner.nextLine();
                    String[] comm_modify = command_modify.split(",");
                    area2D.modifyShape(comm_modify);
                    break;
                case "7":
                    System.out.print("System closing \n");
                    return;
                case "8":
                    System.out.print("\nName  |  type\n");
                    for(Shape a : area2D.getShapeList()){
                        if(a instanceof Square){
                            Square sq = (Square) a;
                            System.out.print(sq.shapeName + "  |   " + sq.type + "\n");
                        }

                        if(a instanceof Rectangle){
                            Rectangle re = (Rectangle) a;
                            System.out.print(re.shapeName + "  |   " + re.type + "\n");
                        }

                        if(a instanceof Line){
                            Line l = (Line) a;
                            System.out.print(l.shapeName + "  |   " + l.type + "\n");
                        }

                    }
                    System.out.print("\n");
                    break;
                default:
                    System.out.print("Command not recognised, try again.\n");
                    break;
            }
        }


    }
}
