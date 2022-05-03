package bg.tu_varna.sit.shapes;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="rect")
public class Rectangle implements Shape{
    @XmlAttribute
    private int width;
    @XmlAttribute
    private int height;
    @XmlAttribute
    private int x;
    @XmlAttribute
    private int y;
    @XmlAttribute
    private String fill;
    public Rectangle(){

    }
    public Rectangle(int width, int height, int x, int y, String fill) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.fill=fill;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
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
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                ", x=" + x +
                ", y=" + y +
                ", fill='" + fill + '\'' +
                '}';
    }
}
