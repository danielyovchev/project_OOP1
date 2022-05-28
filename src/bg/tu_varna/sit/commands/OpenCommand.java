package bg.tu_varna.sit.commands;

import bg.tu_varna.sit.Exceptions.InvalidArgumentException;
import bg.tu_varna.sit.ShapeFactory;


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
    public void execute(Object[] args) throws InvalidArgumentException {
        if(args.length == 0){
            throw new InvalidArgumentException();
        }
        path=String.join(" ", Arrays.stream(args).toArray(String[]::new));
        filename=path.substring(path.lastIndexOf("\\"));
        openedFile=true;

        try {
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
            e.printStackTrace();
        }
        System.out.println("Successfully opened " + filename);
    }
}
