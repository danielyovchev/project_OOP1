package bg.tu_varna.sit.commands;

public class CloseCommand implements Command{
    @Override
    public void execute(Object[] args) {
        System.out.println("Successfully closed");
    }
}
