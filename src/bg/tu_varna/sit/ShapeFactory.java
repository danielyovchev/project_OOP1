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
    public List<Shape> shapeList = new ArrayList<>();
    public List<Shape> addToList(){
        shapeList.add(new Circle(20,10,5,"green"));
        shapeList.add(new Line(6,10,16,22,"red"));
        shapeList.add(new Rectangle(15,20,6,10,"blue"));
        return shapeList;
    }
    public void printAll(){
        for(Shape shape: shapeList){
            System.out.println(shape);
        }
    }

    public void setShapeList(List<Shape> shapeList) {
        this.shapeList = shapeList;
    }
    /*public List<Shape> getShapeList() {
        return shapeList;
    }*/
}
