package bg.tu_varna.sit.commands;

public class ExitCommand implements Command{
    @Override
    public void execute(Object[] args) {
        System.out.println("Exiting the program...");
        System.exit(0);
    }
}
