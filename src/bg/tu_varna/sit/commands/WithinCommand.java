package bg.tu_varna.sit.commands;

import bg.tu_varna.sit.shapes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static bg.tu_varna.sit.ShapeFactory.shapeList;
import static sun.swing.MenuItemLayoutHelper.max;

public class WithinCommand implements Command{
    @Override
    public void execute(Object[] args) {
        String search="";
        List<Shape> withinShapes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String figure = scanner.next();
        if(figure.equalsIgnoreCase("circle")){
            int radius = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            for(Shape shape: shapeList){
                if(shape instanceof Circle){
                    int distance=(int)Math.sqrt(((x-((Circle) shape).getX())*(x-((Circle) shape).getX()))+((y-((Circle) shape).getY())*(y-((Circle) shape).getY())));
                    if(distance+((Circle) shape).getRadius()<=radius){
                        withinShapes.add(shape);
                    }
                }
                else if(shape instanceof Rectangle){
                    int dx=max(x-((Rectangle) shape).getX(),(((Rectangle) shape).getX()+((Rectangle) shape).getWidth())-x);
                    int dy=max(y-((Rectangle) shape).getY(),(((Rectangle) shape).getY()+((Rectangle) shape).getHeight())-y);
                    int result=dx*dx+dy*dy;
                    if(result<=radius*radius){
                        withinShapes.add(shape);
                    }
                }
                else if(shape instanceof Line){
                    int x1= (int) Math.pow((((Line) shape).getX()-x),2);
                    int y1= (int) Math.pow((((Line) shape).getY()-y),2);
                    int res1=x1+y1;
                    int x2= (int) Math.pow((((Line) shape).getX2()-x),2);
                    int y2= (int) Math.pow((((Line) shape).getY2()-y),2);
                    int res2=x2+y2;
                    if(res1<=radius*radius && res2<=radius*radius){
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
        else{
            for(Shape shape: withinShapes){
                System.out.println(shape);
            }
        }
    }
}
