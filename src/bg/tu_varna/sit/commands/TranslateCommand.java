package bg.tu_varna.sit.commands;

import bg.tu_varna.sit.Exceptions.InvalidArgumentException;
import bg.tu_varna.sit.ShapeFactory;
import bg.tu_varna.sit.shapes.Circle;
import bg.tu_varna.sit.shapes.Line;
import bg.tu_varna.sit.shapes.Rectangle;
import bg.tu_varna.sit.shapes.Shape;

public class TranslateCommand implements Command{
    @Override
    public void execute(Object[] args) throws InvalidArgumentException {
        ShapeFactory shapeFactory=new ShapeFactory();
        //Scanner scanner = new Scanner(System.in);
        //System.out.print("vertical");
        //int vertical = scanner.nextInt();
        int vertical = Integer.parseInt(args[0].toString());
        //System.out.print("horizontal");
        //int horizontal = scanner.nextInt();
        int horizontal = Integer.parseInt(args[1].toString());
        if(args.length == 2){
            for(Shape shape: shapeFactory.getShapeList()){
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
            Shape translatedShape = shapeFactory.getShapeList().get(index);
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
            System.out.println("Translated figure number "+ index+1);
        }
        else{
            throw new InvalidArgumentException();
        }

    }
}
