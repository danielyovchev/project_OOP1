package bg.tu_varna.sit.commands;

import bg.tu_varna.sit.Exceptions.FileNotOpenedException;
import bg.tu_varna.sit.ShapeFactory;
import bg.tu_varna.sit.shapes.Circle;
import bg.tu_varna.sit.shapes.Line;
import bg.tu_varna.sit.shapes.Rectangle;

import java.util.Scanner;

public class CreateCommand implements Command{

    @Override
    public void execute(Object[] args) throws FileNotOpenedException {
        if(!OpenCommand.openedFile){
            throw new FileNotOpenedException();
        }
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        System.out.println(input);
        if(input.equalsIgnoreCase("circle")){
            ShapeFactory.shapeList.add(new Circle(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.next()));
        }
        else if(input.equalsIgnoreCase("rectangle")){
            ShapeFactory.shapeList.add(new Rectangle(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.next()));
        }
        else if(input.equalsIgnoreCase("line")){
            ShapeFactory.shapeList.add(new Line(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.next()));
        }
    }
}
