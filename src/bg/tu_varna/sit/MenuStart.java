package bg.tu_varna.sit;

import bg.tu_varna.sit.Exceptions.InvalidCommandException;
import bg.tu_varna.sit.commands.Command;
import bg.tu_varna.sit.commands.CommandFactory;

import java.util.Scanner;

public class MenuStart {
    public static void startMenu(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                System.out.print(">");
                String input=scanner.nextLine();
                String[] splittedInput=input.split("[ ]+");
                String commandName=splittedInput[0];
                Object[] commandArgs=new String[splittedInput.length-1];
                System.arraycopy(splittedInput,1,commandArgs,0,commandArgs.length);
                Command command= CommandFactory.getCommand(commandName);
                if(command!=null){
                    command.execute(commandArgs);
                }
                else{
                    throw new InvalidCommandException();
                }
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
