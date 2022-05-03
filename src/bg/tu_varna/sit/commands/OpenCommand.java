package bg.tu_varna.sit.commands;

public class OpenCommand implements Command{
    public static boolean openedFile=false;
    public static String path;
    public static String filename;
    @Override
    public void execute(Object[] args) {

        System.out.println("Successfully opened " + filename);
    }
}
