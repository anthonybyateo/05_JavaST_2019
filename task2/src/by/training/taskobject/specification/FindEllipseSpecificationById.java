package by.training.taskobject.specification;

import by.training.taskobject.entity.Ellipse;

public class EllipseSpecificationById implements FindEllipseSpecification {

    private int id;

    public EllipseSpecificationById(final int idEllipse) {
        id = idEllipse;
    }

    @Override
    public boolean specified(final Ellipse ellipse) {
        return id == ellipse.getId();
    }
}
