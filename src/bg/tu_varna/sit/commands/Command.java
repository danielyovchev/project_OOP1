package bg.tu_varna.sit.commands;

import bg.tu_varna.sit.Exceptions.FileNotOpenedException;
import bg.tu_varna.sit.Exceptions.InvalidArgumentException;
import bg.tu_varna.sit.Exceptions.InvalidFigureException;
import bg.tu_varna.sit.Exceptions.InvalidNumberException;

public interface Command {
    void execute(Object[] args) throws FileNotOpenedException, InvalidNumberException, InvalidFigureException, InvalidArgumentException;
}
