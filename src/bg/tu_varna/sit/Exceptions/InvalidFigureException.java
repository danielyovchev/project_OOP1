package bg.tu_varna.sit.Exceptions;

public class InvalidFigureException extends Exception{
    public InvalidFigureException() {
        super("Wrong input. Supported figures are circle, line, rectangle");
    }
}
