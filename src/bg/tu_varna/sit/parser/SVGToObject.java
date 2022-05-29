package bg.tu_varna.sit.parser;

import bg.tu_varna.sit.Exceptions.FileNotOpenedException;
import bg.tu_varna.sit.ShapeFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;

public class SVGToObject {
    public static void svgToObject(String filename) throws FileNotOpenedException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ShapeFactory.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            File file = new File(filename);
            if(file.createNewFile()){
                System.out.println("Successfully created" + filename);
            }
            else {
                ShapeFactory shapeFactory = (ShapeFactory) unmarshaller.unmarshal(file);
            }
        }
        catch (JAXBException | IOException e ){
            throw new FileNotOpenedException();
        }
    }
}
