package bg.tu_varna.sit.commands;

import bg.tu_varna.sit.Exceptions.FileNotOpenedException;
import bg.tu_varna.sit.Exceptions.InvalidArgumentException;
import bg.tu_varna.sit.ShapeFactory;
import bg.tu_varna.sit.shapes.Circle;
import bg.tu_varna.sit.shapes.Line;
import bg.tu_varna.sit.shapes.Rectangle;
import bg.tu_varna.sit.shapes.Shape;

public class TranslateCommand implements Command{
    @Override
    public void execute(Object[] args) throws InvalidArgumentException, FileNotOpenedException {
        if(!OpenCommand.openedFile){
            throw new FileNotOpenedException();
        }
        int vertical = Integer.parseInt(args[0].toString());
        int horizontal = Integer.parseInt(args[1].toString());
        if(args.length == 2){
            for(Shape shape: ShapeFactory.getShapeList()){
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

        else if(args.length == 3){
            String num = args[2].toString();
            int index = Integer.parseInt(num.trim())-1;
            Shape translatedShape = ShapeFactory.getShapeList().get(index);
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
            index++;
            System.out.println("Translated figure number "+ index);
        }
        else{
            throw new InvalidArgumentException();
        }

    }
}
