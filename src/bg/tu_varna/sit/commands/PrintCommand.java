package bg.tu_varna.sit.commands;

import bg.tu_varna.sit.Exceptions.FileNotOpenedException;
import bg.tu_varna.sit.ShapeFactory;

public class PrintCommand implements Command{
    @Override
    public void execute(Object[] args) throws FileNotOpenedException {
        if(!OpenCommand.openedFile){
            throw new FileNotOpenedException();
        }
        ShapeFactory shapeFactory = new ShapeFactory();
        shapeFactory.printAll();
    }
}
