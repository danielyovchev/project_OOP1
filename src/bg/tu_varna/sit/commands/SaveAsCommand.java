package bg.tu_varna.sit.commands;

import bg.tu_varna.sit.Exceptions.FileNotOpenedException;
import bg.tu_varna.sit.Exceptions.InvalidArgumentException;
import bg.tu_varna.sit.ShapeFactory;
import bg.tu_varna.sit.parser.ObjectToSVG;

import java.util.Arrays;

public class SaveAsCommand implements Command{
    @Override
    public void execute(Object[] args) throws FileNotOpenedException, InvalidArgumentException {
        ShapeFactory shapeFactory = new ShapeFactory();
        if(args.length==0){
            throw new InvalidArgumentException();
        }
        if(!OpenCommand.openedFile){
            throw new FileNotOpenedException();
        }
        String filepath=String.join(" ", Arrays.stream(args).toArray(String[]::new));
        ObjectToSVG.objectToSVG(shapeFactory,filepath);
        String fileName = filepath.substring(filepath.lastIndexOf("\\")+1);
        System.out.println("Successfully saved "+ fileName);
    }
}
