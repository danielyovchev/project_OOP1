package bg.tu_varna.sit.commands;

import bg.tu_varna.sit.Exceptions.FileNotOpenedException;
import bg.tu_varna.sit.shapes.Circle;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;

public class SaveCommand implements Command{
    @Override
    public void execute(Object[] args) throws FileNotOpenedException{
        /*if(!OpenCommand.openedFile){
            throw new FileNotOpenedException();
        }*/
        //test only
        Circle circle = new Circle();
        circle.setRadius(10);
        circle.setX(2);
        circle.setY(5);
        try {
            JAXBContext jc = JAXBContext.newInstance(Circle.class);
            Marshaller mar = jc.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            File file=new File("test.svg");
            mar.marshal(circle, file);
            if(file.createNewFile()){
                System.out.println("GOOD");
            }
            else {
                System.out.println("Shit");
            }
        } catch (JAXBException | IOException e){
            e.printStackTrace();
        }
        System.out.println("Successfully saved");
    }
}
