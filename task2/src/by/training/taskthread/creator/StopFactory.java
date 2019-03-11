package by.training.taskthread.creator;

import by.training.taskthread.entity.AbstractStop;

public interface AbstractStopFactory {

    public abstract AbstractStop createShape(List<Double> coordinate);

    public abstract List<Shape> createShapeList(List<Double> coordinate);
}
