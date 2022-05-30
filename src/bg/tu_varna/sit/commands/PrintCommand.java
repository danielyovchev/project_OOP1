package bg.tu_varna.sit.commands;

import bg.tu_varna.sit.Exceptions.EmptyCollectionException;
import bg.tu_varna.sit.Exceptions.FileNotOpenedException;
import bg.tu_varna.sit.ShapeFactory;

public class PrintCommand implements Command{
    @Override
    public void execute(Object[] args) throws FileNotOpenedException, EmptyCollectionException {
        if(!OpenCommand.openedFile){
            throw new FileNotOpenedException();
        }
        if(ShapeFactory.getShapeList().isEmpty()){
            throw new EmptyCollectionException();
        }
        ShapeFactory.printAll();
    }
}
