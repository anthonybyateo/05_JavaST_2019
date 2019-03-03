package by.training.taskobject.recorder;

import by.training.taskobject.action.EllipseInfo;
import by.training.taskobject.entity.Ellipse;
import by.training.taskobject.observer.Observer;

public class ObserverForEllipse implements Observer {

    @Override
    public void update(final Ellipse ellipse) {

        EllipseInfo ellipseInfo = new EllipseInfo();
        EllipseData ellipseData = new EllipseData();

        double square = ellipseInfo.calcSquare(ellipse);
        double perimeter = ellipseInfo.calcPerimeter(ellipse);

        ellipseData.setSquare(square);
        ellipseData.setPerimeter(perimeter);

    }
}
