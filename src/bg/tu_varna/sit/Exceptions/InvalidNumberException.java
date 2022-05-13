package bg.tu_varna.sit.Exceptions;

public class InvalidNumberException extends Exception{
    public InvalidNumberException() {
        super("Enter a number equal or smaller than the number of all figures!");
    }
}
