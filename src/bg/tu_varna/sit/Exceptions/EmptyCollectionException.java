package bg.tu_varna.sit.Exceptions;

public class EmptyCollectionException extends Exception{
    public EmptyCollectionException() {
        super("No created figures. Create at least one and then proceed.");
    }
}
