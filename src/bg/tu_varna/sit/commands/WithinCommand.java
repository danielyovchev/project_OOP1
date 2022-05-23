package bg.tu_varna.sit.commands;

import bg.tu_varna.sit.shapes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static bg.tu_varna.sit.ShapeFactory.shapeList;

public class WithinCommand implements Command{
    @Override
    public void execute(Object[] args) {
        List<Shape> withinShapes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String figure = scanner.next();
        if(figure.equalsIgnoreCase("circle")){
            int radius = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            for(Shape shape: shapeList){
                if(shape instanceof Circle){
                    if(((Circle) shape).getX()<=x && ((Circle) shape).getY()<=y){
                        withinShapes.add(shape);
                    }
                }
                if(shape instanceof Rectangle){

                }
                if(shape instanceof Line){

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

                }
                else if(shape instanceof Rectangle){

                }
                else if(shape instanceof Line){

                }
            }
        }
        if(withinShapes.isEmpty()){
            System.out.println("No figures are located within" + figure);
        }
    }
}
