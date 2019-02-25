package by.training.taskobject.creator;

import by.training.taskobject.entity.Point2D;

public class Point2DFactory extends ShapeFactory {

    @Override
    public Point2D createShape() {
        return new Point2D();
    }
}
