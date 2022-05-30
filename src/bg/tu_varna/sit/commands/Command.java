package bg.tu_varna.sit.commands;

import bg.tu_varna.sit.Exceptions.*;

public interface Command {
    void execute(Object[] args) throws FileNotOpenedException, InvalidNumberException, InvalidFigureException, InvalidArgumentException, InvalidRectangleException, InvalidCircleException, EmptyCollectionException;
}
