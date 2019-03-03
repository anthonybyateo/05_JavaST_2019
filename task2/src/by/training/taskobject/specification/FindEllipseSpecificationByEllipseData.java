package by.training.taskobject.specification;

import by.training.taskobject.recorder.EllipseData;

public interface FindEllipseSpecificationByEllipseData extends
        EllipseSpecification {

    boolean specified(EllipseData ellipseData);
}
