package by.training.taskobject.creator;

import by.training.taskobject.entity.Ellipse;
import by.training.taskobject.entity.Point2D;
import by.training.taskobject.entity.Shape;
import by.training.taskobject.validation.Validation;

import java.util.ArrayList;
import java.util.List;

public class Factory {

    public List<Shape> factoryMethod(final String shapeType,
                                   final List<Double> coordinateList) {

        List<Shape> shapeList = new ArrayList<>();

        if (shapeType.equalsIgnoreCase("Ellipse")) {

            Validation validation = new Validation();

            int i = 0;
            while (i < coordinateList.size()) {
                double x1 = coordinateList.get(i);
                double y1 = coordinateList.get(++i);
                double x2 = coordinateList.get(++i);
                double y2 = coordinateList.get(++i);

                if (validation.checkPoints(x1, y1, x2, y2)) {
                    Point2D point1 = new Point2D(x1, y1);
                    Point2D point2 = new Point2D(x2, y2);
                    shapeList.add(new Ellipse(point1, point2));
                }
                i++;
            }
            return shapeList;
        } else {

            return shapeList;
        }
    }
}
