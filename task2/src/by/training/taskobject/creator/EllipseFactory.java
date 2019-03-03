package by.training.taskobject.creator;

import by.training.taskobject.entity.Ellipse;
import by.training.taskobject.entity.Point2D;
import by.training.taskobject.entity.Shape;
import by.training.taskobject.exception.IllegalAmountArgumentException;
import by.training.taskobject.parser.ParserData;
import by.training.taskobject.validation.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class EllipseFactory extends ShapeFactory {

    static final Logger LOGGER = LogManager.getLogger(ParserData.class);
    private static final int FOUR_COORNINATE = 4;

    @Override
    public Shape createShape(final List<Double> coordinate) {

        Validation validation = new Validation();

        if (validation.checkFourCoordinate(coordinate)) {
            int i = 0;
            double x1 = coordinate.get(i);
            double y1 = coordinate.get(++i);
            double x2 = coordinate.get(++i);
            double y2 = coordinate.get(++i);

            if (validation.checkPoints(x1, y1, x2, y2)) {

                Point2D point1 = new Point2D(x1, y1);
                Point2D point2 = new Point2D(x2, y2);
                return new Ellipse(0, "Ellipsr",
                        point1, point2);
            } else {
                LOGGER.warn("Illegal arguments");
            }

        } else {
            try {
                throw new IllegalAmountArgumentException();
            } catch (IllegalAmountArgumentException e) {
                LOGGER.warn("Illegal number arguments");
            }
        }

        return null;
    }

    @Override
    public List<Shape> createShapeList(final List<Double> coordinate) {

        List<Shape> shapeList = new ArrayList<>();

        Validation validation = new Validation();

        int i = 0;
        int j = 0;
        int id = 0;
        String name = "Ellipse";
        while (i < coordinate.size()) {

            j += FOUR_COORNINATE;
            if (j > coordinate.size()) {

                double x1 = coordinate.get(i);
                double y1 = coordinate.get(++i);
                double x2 = coordinate.get(++i);
                double y2 = coordinate.get(++i);

                if (validation.checkPoints(x1, y1, x2, y2)) {
                    Point2D point1 = new Point2D(x1, y1);
                    Point2D point2 = new Point2D(x2, y2);
                    name += id;
                    shapeList.add(new Ellipse(id, name, point1, point2));
                }
                i++;
                id++;
            } else {
                break;
            }
        }

        return shapeList;
    }
}
