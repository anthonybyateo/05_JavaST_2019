package by.training.taskobject.specification;

import by.training.taskobject.entity.Ellipse;

public class FindEllipseSpecificationById implements FindEllipseSpecification {

    private int id;

    public FindEllipseSpecificationById(final int idEllipse) {
        id = idEllipse;
    }

    @Override
    public boolean specified(final Ellipse ellipse) {
        return id == ellipse.getId();
    }
}
