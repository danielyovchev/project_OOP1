package bg.tu_varna.sit.commands;

import bg.tu_varna.sit.Exceptions.FileNotOpenedException;

public class SaveCommand implements Command{
    @Override
    public void execute(Object[] args) throws FileNotOpenedException {
        if(!OpenCommand.openedFile){
            throw new FileNotOpenedException();
        }
        System.out.println("Successfully saved");
    }
}
