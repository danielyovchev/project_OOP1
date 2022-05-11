package bg.tu_varna.sit.commands;

import bg.tu_varna.sit.ShapeFactory;
import bg.tu_varna.sit.shapes.Shape;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class OpenCommand implements Command{
    public static boolean openedFile=false;
    public static String path;
    public static String filename;
    @Override
    public void execute(Object[] args) {
        path=String.join(" ", Arrays.stream(args).toArray(String[]::new));
        //filename=path.substring(path.lastIndexOf("\\"));
        openedFile=true;
        ShapeFactory shapeFactory = new ShapeFactory();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ShapeFactory.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            File file = new File("test.svg");
            shapeFactory = (ShapeFactory)unmarshaller.unmarshal(file);
            for(Shape shape: shapeFactory.shapeList){
                System.out.println(shape);
            }
        }catch (JAXBException e){
            e.printStackTrace();
        }
        System.out.println("Successfully opened " + path);
    }
}
