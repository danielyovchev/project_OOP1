package bg.tu_varna.sit.commands;

import bg.tu_varna.sit.Exceptions.FileNotOpenedException;

public interface Command {
    void execute(Object[] args) throws FileNotOpenedException;
}
