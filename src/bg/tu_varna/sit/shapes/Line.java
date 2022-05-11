package bg.tu_varna.sit.shapes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="line")
@XmlAccessorType(XmlAccessType.FIELD)
public class Line implements Shape{
    @XmlAttribute
    private int x;
    @XmlAttribute
    private int y;
    @XmlAttribute
    private int x2;
    @XmlAttribute
    private int y2;
    @XmlAttribute
    private String fill;
    public Line(){

    }
    public Line(int x, int y, int x2, int y2, String fill) {
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
        this.fill=fill;
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

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public String getFill() {
        return fill;
    }

    public void setFill(String fill) {
        this.fill = fill;
    }

    @Override
    public String toString() {
        return "Line{" +
                "x=" + x +
                ", y=" + y +
                ", x2=" + x2 +
                ", y2=" + y2 +
                ", fill='" + fill + '\'' +
                '}';
    }
}
