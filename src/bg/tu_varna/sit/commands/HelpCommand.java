package bg.tu_varna.sit.commands;

public class HelpCommand implements Command{
    @Override
    public void execute(Object[] args) {
        System.out.println("The following commands are supported:\n"+"open <file> opens <file>\n"+"close    closes currently opened file \n"+
                "save   saves the currently open file\n"+"saveas<file>  saves the currently open file in <file>\n"+
                "help   prints this information\n"+"exit    exits the program");
    }
}
