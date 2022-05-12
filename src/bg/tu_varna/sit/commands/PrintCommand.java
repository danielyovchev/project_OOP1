package bg.tu_varna.sit.commands;

import bg.tu_varna.sit.ShapeFactory;

public class PrintCommand implements Command{
    @Override
    public void execute(Object[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        shapeFactory.printAll();
    }
}
