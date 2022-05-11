package bg.tu_varna.sit.commands;

import bg.tu_varna.sit.Exceptions.FileNotOpenedException;
import bg.tu_varna.sit.ShapeFactory;
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

        ShapeFactory shapeFactory = new ShapeFactory();
        shapeFactory.addToList();
        try {
            JAXBContext jc = JAXBContext.newInstance(ShapeFactory.class);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            FileWriter fileWriter = new FileWriter("test.svg");
            //JAXBElement<ShapeFactory> jaxbElement = new JAXBElement<>(new QName("","shapeFactory"),ShapeFactory.class,shapeFactory);
            //File file=new File("test.svg");
            marshaller.marshal(shapeFactory, fileWriter);
            fileWriter.close();
            /*if(file.createNewFile()){
                System.out.println("GOOD");
            }
            else {
                System.out.println("Shit");
            }*/
        } catch (JAXBException | IOException e){
            e.printStackTrace();
        }
        System.out.println("Successfully saved");
    }
}
