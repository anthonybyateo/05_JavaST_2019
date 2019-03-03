package by.training.taskobject.specification;

import by.training.taskobject.entity.Ellipse;

import java.util.Comparator;

public class SortEllipseSpecificationByName implements
        SortEllipseSpecification {

    @Override
    public Comparator<Ellipse> specifiedComparator() {
        return Comparator.comparing(Ellipse::getName);
    }
}
