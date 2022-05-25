package bg.tu_varna.sit.commands;

import bg.tu_varna.sit.shapes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static bg.tu_varna.sit.ShapeFactory.shapeList;

public class WithinCommand implements Command{
    @Override
    public void execute(Object[] args) {
        String search;
        List<Shape> withinShapes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String figure = scanner.next();
        if(figure.equalsIgnoreCase("circle")){
            int radius = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            for(Shape shape: shapeList){
                if(shape instanceof Circle){
                    if(){
                        withinShapes.add(shape);
                    }
                }
                else if(shape instanceof Rectangle){
                    if(){
                        withinShapes.add(shape);
                    }
                }
                else if(shape instanceof Line){
                    if(){
                        withinShapes.add(shape);
                    }
                }
                else {
                    search="circle "+ x + " "+y;
                }
            }
        }
        else if(figure.equalsIgnoreCase("rectangle")){
            int width = scanner.nextInt();
            int height = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            for(Shape shape: shapeList){
                if(shape instanceof Circle){
                    if(((Circle) shape).getX()>x && ((Circle) shape).getY()>y && (((Circle) shape).getX()+((Circle) shape).getRadius()*2<=x+width) && (((Circle) shape).getY()+((Circle) shape).getRadius()*2<=y+height)){
                        withinShapes.add(shape);
                    }
                }
                else if(shape instanceof Rectangle){
                    if(((Rectangle) shape).getX()>x && ((Rectangle) shape).getY()>y && (((Rectangle) shape).getX()+((Rectangle) shape).getWidth()<=x+width) && (((Rectangle) shape).getY()+((Rectangle) shape).getHeight()<=y+height)){
                        withinShapes.add(shape);
                    }
                }
                else if(shape instanceof Line){
                    if((((Line) shape).getX()>x && ((Line) shape).getY()>y) && (((Line) shape).getX2()<x+width) && (((Line) shape).getY2()<y+height)){
                        withinShapes.add(shape);
                    }
                }
                else {
                    search="rectangle "+width+" "+height+" "+x+" "+y;
                }
            }
        }
        if(withinShapes.isEmpty()){
            System.out.println("No figures are located within" + search);
        }
    }
}
