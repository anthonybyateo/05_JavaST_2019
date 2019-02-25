package by.training.taskobject.creator;

import by.training.taskobject.entity.Ellipse;

public class EllipseFactory extends ShapeFactory {

    @Override
    public Ellipse createShape() {
        return new Ellipse();
    }
}
