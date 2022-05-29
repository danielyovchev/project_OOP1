package bg.tu_varna.sit.Exceptions;

public class InvalidRectangleException extends Exception{
    public InvalidRectangleException() {
        super("Error in creating rectangle. Width and height must be positive numbers");
    }
}
