package bg.tu_varna.sit.commands;

import bg.tu_varna.sit.Exceptions.FileNotOpenedException;
import bg.tu_varna.sit.Exceptions.InvalidArgumentException;
import bg.tu_varna.sit.parser.SVGToObject;
import java.util.Arrays;

public class OpenCommand implements Command{
    public static boolean openedFile=false;
    public static String path;
    public static String filename;
    @Override
    public void execute(Object[] args) throws InvalidArgumentException, FileNotOpenedException {
        if(args.length == 0){
            throw new InvalidArgumentException();
        }
        path=String.join(" ", Arrays.stream(args).toArray(String[]::new));
        SVGToObject.svgToObject(path);
        openedFile=true;
        filename=path.substring(path.lastIndexOf("\\")+1);
        System.out.println("Successfully opened " + filename);

    }
}
