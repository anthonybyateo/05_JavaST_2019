package by.training.taskobject.specification;

import by.training.taskobject.entity.Ellipse;
import by.training.taskobject.entity.Point2D;

import java.util.Comparator;

public class SortEllipseSpecificationByXPoint1 implements
        SortEllipseSpecification {

    @Override
    public Comparator<Ellipse> specifiedComparator() {
        return Comparator.comparing((Ellipse el) -> el.getPoint1().getX());
    }
}
