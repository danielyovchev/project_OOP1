package bg.tu_varna.sit.commands;

import bg.tu_varna.sit.Exceptions.EmptyCollectionException;
import bg.tu_varna.sit.Exceptions.FileNotOpenedException;
import bg.tu_varna.sit.Exceptions.InvalidNumberException;
import bg.tu_varna.sit.ShapeFactory;

public class EraseCommand implements Command{
    @Override
    public void execute(Object[] args) throws FileNotOpenedException, InvalidNumberException, EmptyCollectionException {
        if (!OpenCommand.openedFile){
            throw new FileNotOpenedException();
        }
        if(ShapeFactory.getShapeList().isEmpty()){
            throw new EmptyCollectionException();
        }
        int index=Integer.parseInt(args[0].toString());
        if(index>ShapeFactory.getShapeList().size() || index < 0){
            System.out.println("Number of figures is "+ ShapeFactory.getShapeList().size());
            throw new InvalidNumberException();
        }
        ShapeFactory.removeFromList(index-1);
    }
}
