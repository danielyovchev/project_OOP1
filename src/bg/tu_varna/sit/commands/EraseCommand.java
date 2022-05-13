package bg.tu_varna.sit.commands;

import bg.tu_varna.sit.Exceptions.FileNotOpenedException;
import bg.tu_varna.sit.Exceptions.InvalidNumberException;
import bg.tu_varna.sit.ShapeFactory;

import java.util.Scanner;

public class EraseCommand implements Command{
    @Override
    public void execute(Object[] args) throws FileNotOpenedException, InvalidNumberException {
        if (!OpenCommand.openedFile){
            throw new FileNotOpenedException();
        }
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt()-1;
        if(index>ShapeFactory.shapeList.size()-1){
            System.out.println("Number of figures is "+ShapeFactory.shapeList.size());
            throw new InvalidNumberException();
        }
        ShapeFactory.shapeList.remove(index);
    }
}
