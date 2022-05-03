package bg.tu_varna.sit.parser;

import bg.tu_varna.sit.shapes.Circle;
import bg.tu_varna.sit.shapes.Shape;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;

public class ObjectToSVG {
    public static void objectToSVG(Shape shape, String filename){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Shape.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            File file= new File(filename);
            marshaller.marshal(shape,file);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
