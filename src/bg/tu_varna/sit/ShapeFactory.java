package bg.tu_varna.sit;

import bg.tu_varna.sit.shapes.Circle;
import bg.tu_varna.sit.shapes.Line;
import bg.tu_varna.sit.shapes.Rectangle;
import bg.tu_varna.sit.shapes.Shape;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
@XmlRootElement(name="svg")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShapeFactory {
    @XmlElements({
            @XmlElement(name="circle", type = Circle.class),
            @XmlElement(name="rect", type = Rectangle.class),
            @XmlElement(name="line", type = Line.class)
    })
    @XmlElementWrapper(name="g")
    private static List<Shape> shapeList = new ArrayList<>();
    public ShapeFactory() {
    }

    public static void addToList(Shape shape){
        shapeList.add(shape);
    }
    public static void printAll(){
        for(Shape shape: shapeList){
            int num= shapeList.indexOf(shape)+1;
            System.out.println(num+". "+shape);
        }
    }
    public static void removeFromList(int index){
        shapeList.remove(index);
    }

    public static List<Shape> getShapeList() {
        return shapeList;
    }
}
