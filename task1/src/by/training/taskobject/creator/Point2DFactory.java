package by.training.taskobject.creator;

import by.training.taskobject.entity.Point2D;
import by.training.taskobject.entity.Shape;
import by.training.taskobject.exception.IllegalAmountArgumentException;
import by.training.taskobject.parser.ParserData;
import by.training.taskobject.validation.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Point2DFactory extends ShapeFactory {

    static final Logger LOGGER = LogManager.getLogger(ParserData.class);

    @Override
    public Shape createShape(final List<Double> coordinate) {

        Validation validation = new Validation();

        if (validation.checkTwoCoordinate(coordinate)) {
            int i = 0;
            double x1 = coordinate.get(i);
            double y1 = coordinate.get(++i);

            return new Point2D(x1, y1);

        } else {
            try {
                throw new IllegalAmountArgumentException();
            } catch (IllegalAmountArgumentException e) {
                LOGGER.warn("Illegal number arguments");
            }
        }

        return new Point2D();
    }

    @Override
    public List<Shape> createShapeList(final List<Double> coordinate) {

        List<Shape> shapeList = new ArrayList<>();

        Validation validation = new Validation();

        int i = 0;
        int j = 0;
        while (i < coordinate.size()) {
            j += 2;

            if (j > coordinate.size()) {
                double x1 = coordinate.get(i);
                double y1 = coordinate.get(++i);

                shapeList.add(new Point2D(x1, y1));

                i++;
            } else {
                break;
            }
        }

        return shapeList;
    }
}
