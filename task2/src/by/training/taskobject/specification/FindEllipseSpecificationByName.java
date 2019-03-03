package by.training.taskobject.specification;

import by.training.taskobject.entity.Ellipse;

public class FindEllipseSpecificationByName implements
        FindEllipseSpecification {
    private String name;

    public FindEllipseSpecificationByName(final String nameEllipse) {
        this.name = nameEllipse;
    }

    @Override
    public boolean specified(final Ellipse ellipse) {
        return name.equals(ellipse.getName());
    }
}
