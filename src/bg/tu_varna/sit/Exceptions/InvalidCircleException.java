package bg.tu_varna.sit.Exceptions;

public class InvalidCircleException extends Exception{
    public InvalidCircleException() {
        super("Error in creating circle. Radius must be greater than or equal to 0");
    }
}
