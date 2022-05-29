package bg.tu_varna.sit.shapes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name= "circle")
@XmlAccessorType(XmlAccessType.FIELD)
public class Circle implements Shape{
    @XmlAttribute(name="cx")
    private int x;
    @XmlAttribute(name = "cy")
    private int y;
    @XmlAttribute(name="r")
    private int radius;
    @XmlAttribute
    private String fill;
    public Circle(){

    }
    public Circle(int x, int y, int radius, String fill) {
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.fill=fill;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getFill() {
        return fill;
    }

    public void setFill(String fill) {
        this.fill = fill;
    }

    @Override
    public String toString() {
        return "circle " + x +
                " " + y +
                " " + radius +
                " " + fill;
    }
}
