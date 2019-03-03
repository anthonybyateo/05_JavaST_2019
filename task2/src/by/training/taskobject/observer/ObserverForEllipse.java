package by.training.taskobject.observer;

import by.training.taskobject.entity.Ellipse;
import by.training.taskobject.repository.EllipseRepository;
import by.training.taskobject.specification.FindEllipseSpecification;
import by.training.taskobject.specification.FindEllipseSpecificationById;

public class ObserverForEllipse implements Observer {

    @Override
    public void update(final Object ob) {

        Ellipse ellipse = (Ellipse) ob;
        FindEllipseSpecification specification
                = new FindEllipseSpecificationById(ellipse.getId());

        EllipseRepository.getInstance().updateEllipse(specification);
    }
}
