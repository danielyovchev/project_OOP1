package bg.tu_varna.sit.Exceptions;

public class InvalidCommandException extends Exception{
    public InvalidCommandException(){
        super("Invalid command. See help or try again");
    }
}
