package by.training.taskobject.specification;

import by.training.taskobject.entity.Ellipse;

import java.util.Comparator;

public class SortEllipseSpecificationById implements SortEllipseSpecification {

    @Override
    public Comparator<Ellipse> specifiedComparator() {
        return Comparator.comparing(Ellipse::getId);
    }
}
