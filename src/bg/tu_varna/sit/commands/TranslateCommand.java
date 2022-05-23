package bg.tu_varna.sit.commands;

import bg.tu_varna.sit.shapes.Circle;
import bg.tu_varna.sit.shapes.Line;
import bg.tu_varna.sit.shapes.Rectangle;
import bg.tu_varna.sit.shapes.Shape;

import java.util.Scanner;

import static bg.tu_varna.sit.ShapeFactory.shapeList;

public class TranslateCommand implements Command{
    @Override
    public void execute(Object[] args) {
        Scanner scanner = new Scanner(System.in);
        int vertical = scanner.nextInt();
        int horizontal = scanner.nextInt();
        String num = scanner.nextLine();
        if(!num.isEmpty()){
            int index = Integer.parseInt(num.trim())-1;
            Shape translatedShape = shapeList.get(index);
            if(translatedShape instanceof Circle){
                ((Circle) translatedShape).setY(((Circle) translatedShape).getY()+vertical);
                ((Circle) translatedShape).setX(((Circle) translatedShape).getX()+horizontal);
            }
            if(translatedShape instanceof Rectangle){
                ((Rectangle) translatedShape).setY(((Rectangle) translatedShape).getY()+vertical);
                ((Rectangle) translatedShape).setX(((Rectangle) translatedShape).getX()+horizontal);
            }
            if(translatedShape instanceof Line){
                ((Line) translatedShape).setY(((Line) translatedShape).getY()+vertical);
                ((Line) translatedShape).setX(((Line) translatedShape).getX()+horizontal);
                ((Line) translatedShape).setY2(((Line) translatedShape).getY2()+vertical);
                ((Line) translatedShape).setX2(((Line) translatedShape).getX2()+horizontal);
            }
            System.out.println("Translate");
        }
        else{
            for(Shape shape: shapeList){
                if(shape instanceof Circle){
                    ((Circle) shape).setX(((Circle) shape).getX()+horizontal);
                    ((Circle) shape).setY(((Circle) shape).getY()+vertical);
                }
                if(shape instanceof Rectangle){
                    ((Rectangle) shape).setX(((Rectangle) shape).getX()+horizontal);
                    ((Rectangle) shape).setY(((Rectangle) shape).getY()+vertical);
                }
                if(shape instanceof Line){
                    ((Line) shape).setX(((Line) shape).getX()+horizontal);
                    ((Line) shape).setY(((Line) shape).getY()+vertical);
                    ((Line) shape).setX2(((Line) shape).getX2()+horizontal);
                    ((Line) shape).setY2(((Line) shape).getY2()+vertical);
                }
            }
            System.out.println("Translated all figures");
        }

    }
}
