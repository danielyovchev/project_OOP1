package bg.tu_varna.sit.commands;

import bg.tu_varna.sit.Exceptions.FileNotOpenedException;
import bg.tu_varna.sit.Exceptions.InvalidArgumentException;
import bg.tu_varna.sit.ShapeFactory;
import bg.tu_varna.sit.parser.SVGToObject;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
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
        /*try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ShapeFactory.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            File file = new File(path);
            if(file.createNewFile()){
                System.out.println("Successfully created" + filename);
            }
            else {
                ShapeFactory shapeFactory = (ShapeFactory) unmarshaller.unmarshal(file);

            }
        }
        catch (JAXBException | IOException e ){
            throw new FileNotOpenedException();
        }*/
        filename=path.substring(path.lastIndexOf("\\"));
        System.out.println("Successfully opened " + filename);
    }
}
