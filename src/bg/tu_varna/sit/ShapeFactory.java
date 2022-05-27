package bg.tu_varna.sit;

import bg.tu_varna.sit.shapes.Circle;
import bg.tu_varna.sit.shapes.Line;
import bg.tu_varna.sit.shapes.Rectangle;
import bg.tu_varna.sit.shapes.Shape;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
@XmlRootElement(name="svg")
public class ShapeFactory {
    @XmlElements({
            @XmlElement(name="circle", type = Circle.class),
            @XmlElement(name="rect", type = Rectangle.class),
            @XmlElement(name="line", type = Line.class)
    })
    @XmlElementWrapper
    public static List<Shape> shapeList = new ArrayList<>();
    public List<Shape> addToList(Shape shape){
        shapeList.add(shape);
        return shapeList;
    }
    public void printAll(){
        for(Shape shape: shapeList){
            int num= shapeList.indexOf(shape)+1;
            System.out.println(num+". "+shape);
        }
    }
    /*public List<Shape> shapeList(int num){
        shapeList.remove(num);
        return shapeList;
    }*/
    public void setShapeList(List<Shape> shapeList) {
        this.shapeList = shapeList;
    }
    /*public List<Shape> getShapeList() {
        return shapeList;
    }*/
}
