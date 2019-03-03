package by.training.taskobject.creator;

import by.training.taskobject.entity.Shape;

import java.util.List;

public abstract class ShapeFactory {

    public abstract Shape createShape(List<Double> coordinate);

    public abstract List<Shape> createShapeList(List<Double> coordinate);
}
