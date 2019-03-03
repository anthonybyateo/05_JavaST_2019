package by.training.taskobject.specification;

import by.training.taskobject.entity.Ellipse;

public interface FindEllipseSpecification extends EllipseSpecification {

    boolean specified(Ellipse ellipse);
}
