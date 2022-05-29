package bg.tu_varna.sit.commands;

import bg.tu_varna.sit.Exceptions.FileNotOpenedException;
import bg.tu_varna.sit.Exceptions.InvalidNumberException;
import bg.tu_varna.sit.ShapeFactory;

public class EraseCommand implements Command{
    @Override
    public void execute(Object[] args) throws FileNotOpenedException, InvalidNumberException {
        if (!OpenCommand.openedFile){
            throw new FileNotOpenedException();
        }
        ShapeFactory shapeFactory=new ShapeFactory();
        int index=Integer.parseInt(args[0].toString());
        if(index>shapeFactory.getShapeList().size()){
            System.out.println("Number of figures is "+shapeFactory.getShapeList().size());
            throw new InvalidNumberException();
        }
        shapeFactory.removeFromList(index-1);
    }
}
