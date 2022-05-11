package bg.tu_varna.sit.commands;

import bg.tu_varna.sit.Exceptions.FileNotOpenedException;

public class CloseCommand implements Command{
    @Override
    public void execute(Object[] args) throws FileNotOpenedException{
        if(!OpenCommand.openedFile){
            throw new FileNotOpenedException();
        }
        OpenCommand.openedFile=false;
        System.out.println("Successfully closed");
    }
}
