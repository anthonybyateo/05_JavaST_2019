package by.training.taskobject.specification;

import by.training.taskobject.entity.Ellipse;

import java.util.Comparator;

public class SortEllipseSpecificationByYPoint1 implements
        SortEllipseSpecification {

    @Override
    public Comparator<Ellipse> specifiedComparator() {
        return Comparator.comparing((Ellipse el) -> el.getPoint1().getY());
    }
}
