package by.training.taskobject.specification;

import by.training.taskobject.entity.Ellipse;

import java.util.Comparator;

public interface SortEllipseSpecification extends EllipseSpecification {

    Comparator<Ellipse> specifiedComparator();
}
