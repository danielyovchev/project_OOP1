package bg.tu_varna.sit.commands;

import bg.tu_varna.sit.Exceptions.FileNotOpenedException;
import bg.tu_varna.sit.Exceptions.InvalidArgumentException;
import bg.tu_varna.sit.Exceptions.InvalidFigureException;
import bg.tu_varna.sit.ShapeFactory;
import bg.tu_varna.sit.shapes.Circle;
import bg.tu_varna.sit.shapes.Line;
import bg.tu_varna.sit.shapes.Rectangle;

import java.util.Scanner;

public class CreateCommand implements Command{

    @Override
    public void execute(Object[] args) throws FileNotOpenedException, InvalidFigureException, InvalidArgumentException {
        if(!OpenCommand.openedFile){
            throw new FileNotOpenedException();
        }
        Scanner scanner = new Scanner(System.in);
        //String input = scanner.next();
        String input = args[0].toString();
        if(input.equalsIgnoreCase("circle")){
            if(args.length<5){
                throw new InvalidArgumentException();
            }
            int radius = Integer.parseInt(args[1].toString());
            int x = Integer.parseInt(args[2].toString());
            int y = Integer.parseInt(args[3].toString());
            String fill = args[4].toString();

            ShapeFactory.shapeList.add(new Circle(radius,x,y,fill));
            //ShapeFactory.shapeList.add(new Circle(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.next()));
        }
        else if(input.equalsIgnoreCase("rectangle")){
            if(args.length<6){
                throw new InvalidArgumentException();
            }
            int width = Integer.parseInt(args[1].toString());
            int height = Integer.parseInt(args[2].toString());
            int x = Integer.parseInt(args[3].toString());
            int y = Integer.parseInt(args[4].toString());
            String fill = args[5].toString();
            ShapeFactory.shapeList.add(new Rectangle(x,y,width,height,fill));
            //ShapeFactory.shapeList.add(new Rectangle(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.next()));
        }
        else if(input.equalsIgnoreCase("line")){
            if(args.length<5){
                throw new InvalidArgumentException();
            }
            int x = Integer.parseInt(args[1].toString());
            int y = Integer.parseInt(args[2].toString());
            int x2 = Integer.parseInt(args[3].toString());
            int y2 = Integer.parseInt(args[4].toString());
            String fill = args[5].toString();
            ShapeFactory.shapeList.add(new Line(x,y,x2,y2));
            //ShapeFactory.shapeList.add(new Line(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.next()));
        }
        else{
            throw new InvalidFigureException();
        }
    }
}
