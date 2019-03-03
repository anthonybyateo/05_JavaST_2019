package by.training.taskobject.specification;

import by.training.taskobject.entity.Ellipse;

import java.util.Comparator;

public class SortEllipseSpecificationByIdAndName implements
        SortEllipseSpecification {

    @Override
    public Comparator<Ellipse> specifiedComparator() {
        return Comparator.comparing(Ellipse::getId).
                thenComparing(Ellipse::getName);
    }
}
