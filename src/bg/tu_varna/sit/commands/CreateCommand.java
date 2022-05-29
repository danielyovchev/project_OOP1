package bg.tu_varna.sit.commands;

import bg.tu_varna.sit.Exceptions.*;
import bg.tu_varna.sit.ShapeFactory;
import bg.tu_varna.sit.shapes.Circle;
import bg.tu_varna.sit.shapes.Line;
import bg.tu_varna.sit.shapes.Rectangle;

public class CreateCommand implements Command{

    @Override
    public void execute(Object[] args) throws FileNotOpenedException, InvalidFigureException, InvalidArgumentException, InvalidRectangleException, InvalidCircleException {
        if(!OpenCommand.openedFile){
            throw new FileNotOpenedException();
        }
        String input = args[0].toString();
        if(input.equalsIgnoreCase("circle")){
            if(args.length<5){
                throw new InvalidArgumentException();
            }
            int x = Integer.parseInt(args[1].toString());
            int y = Integer.parseInt(args[2].toString());
            int radius = Integer.parseInt(args[3].toString());
            String fill = args[4].toString();
            if(radius<0){
                throw new InvalidCircleException();
            }
            ShapeFactory.addToList(new Circle(x,y,radius,fill));
        }
        else if(input.equalsIgnoreCase("rectangle")){
            if(args.length<6){
                throw new InvalidArgumentException();
            }
            int x = Integer.parseInt(args[1].toString());
            int y = Integer.parseInt(args[2].toString());
            int width = Integer.parseInt(args[3].toString());
            int height = Integer.parseInt(args[4].toString());
            String fill = args[5].toString();
            if(width<=0 || height <=0){
                throw new InvalidRectangleException();
            }
            ShapeFactory.addToList(new Rectangle(x,y,width,height,fill));
        }
        else if(input.equalsIgnoreCase("line")){
            if(args.length<5){
                throw new InvalidArgumentException();
            }
            int x = Integer.parseInt(args[1].toString());
            int y = Integer.parseInt(args[2].toString());
            int x2 = Integer.parseInt(args[3].toString());
            int y2 = Integer.parseInt(args[4].toString());
            ShapeFactory.addToList(new Line(x,y,x2,y2));
        }
        else{
            throw new InvalidFigureException();
        }
    }
}
