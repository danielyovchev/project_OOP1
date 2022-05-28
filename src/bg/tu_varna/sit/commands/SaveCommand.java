package bg.tu_varna.sit.commands;

import bg.tu_varna.sit.Exceptions.FileNotOpenedException;
import bg.tu_varna.sit.ShapeFactory;
import bg.tu_varna.sit.parser.ObjectToSVG;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;

public class SaveCommand implements Command{
    @Override
    public void execute(Object[] args) throws FileNotOpenedException{
        if(!OpenCommand.openedFile){
            throw new FileNotOpenedException();
        }
        ShapeFactory shapeFactory = new ShapeFactory();
        /*try {
            JAXBContext jc = JAXBContext.newInstance(ShapeFactory.class);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            File file = new File(OpenCommand.path);
            marshaller.marshal(shapeFactory, file);
        } catch (JAXBException e){
            e.printStackTrace();
        }*/
        ObjectToSVG.objectToSVG(shapeFactory,OpenCommand.path);
        System.out.println("Successfully saved"+OpenCommand.filename);
    }
}
