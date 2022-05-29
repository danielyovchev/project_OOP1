package bg.tu_varna.sit.Exceptions;

public class FileNotOpenedException extends Exception{
    public FileNotOpenedException() {
        super("File is not opened! Invalid path or file");
    }
}
