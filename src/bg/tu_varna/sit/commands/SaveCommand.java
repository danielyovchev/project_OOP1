package bg.tu_varna.sit.commands;

import bg.tu_varna.sit.Exceptions.FileNotOpenedException;
import bg.tu_varna.sit.ShapeFactory;
import bg.tu_varna.sit.parser.ObjectToSVG;

public class SaveCommand implements Command{
    @Override
    public void execute(Object[] args) throws FileNotOpenedException{
        if(!OpenCommand.openedFile){
            throw new FileNotOpenedException();
        }
        ShapeFactory shapeFactory = new ShapeFactory();
        ObjectToSVG.objectToSVG(shapeFactory,OpenCommand.path);
        System.out.println("Successfully saved"+OpenCommand.filename);
    }
}
