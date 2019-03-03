package by.training.taskobject.creator;

import by.training.taskobject.entity.Shape;

import java.util.List;

public class Creator {

    public Shape createShape(final ShapeFactory factory,
                             final List<Double> coordinate) {

        return factory.createShape(coordinate);
    }

    public List<Shape> createShapeList(final ShapeFactory factory,
                                       final List<Double> coordinate) {

        return factory.createShapeList(coordinate);
    }
}
