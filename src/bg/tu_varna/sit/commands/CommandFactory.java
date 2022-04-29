package bg.tu_varna.sit.commands;

public abstract class CommandFactory {
    public static Command getCommand(String commandName){
        if(commandName.equalsIgnoreCase("open")){
            return new OpenCommand();
        }
        else if(commandName.equalsIgnoreCase("exit")){
            return new ExitCommand();
        }
        else if(commandName.equalsIgnoreCase("close")){
            return new CloseCommand();
        }
        else if(commandName.equalsIgnoreCase("save")){
            return new SaveCommand();
        }
        else if(commandName.equalsIgnoreCase("saveas")){
            return new SaveAsCommand();
        }
        else if(commandName.equalsIgnoreCase("help")){
            return new HelpCommand();
        }
        else if(commandName.equalsIgnoreCase("print")){
            return new PrintCommand();
        }
        else if(commandName.equalsIgnoreCase("create")){
            return new CreateCommand();
        }
        else if(commandName.equalsIgnoreCase("erase")){
            return new EraseCommand();
        }
        else if(commandName.equalsIgnoreCase("translate")){
            return new TranslateCommand();
        }
        else if(commandName.equalsIgnoreCase("within")){
            return new WithinCommand();
        }
        else{
            return null;
        }
    }
}
