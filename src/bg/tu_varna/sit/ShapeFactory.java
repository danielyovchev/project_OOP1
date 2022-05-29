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
    @XmlElementWrapper
    private static List<Shape> shapeList = new ArrayList<>();

    public ShapeFactory() {
    }

    public static List<Shape> addToList(Shape shape){
        shapeList.add(shape);
        return shapeList;
    }
    public static void printAll(){
        for(Shape shape: shapeList){
            int num= shapeList.indexOf(shape)+1;
            System.out.println(num+". "+shape);
        }
    }
    public static List<Shape> removeFromList(int index){
        shapeList.remove(index);
        return shapeList;
    }
    public void setShapeList(List<Shape> shapeList) {
        this.shapeList = shapeList;
    }
    public static List<Shape> getShapeList() {
        return shapeList;
    }
}
