package bg.tu_varna.sit.parser;

import bg.tu_varna.sit.ShapeFactory;
import bg.tu_varna.sit.shapes.Circle;
import bg.tu_varna.sit.shapes.Shape;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;

public class ObjectToSVG {
    public static void objectToSVG(ShapeFactory shapeFactory, String filename){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ShapeFactory.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            File file= new File(filename);
            marshaller.marshal(shapeFactory,file);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
