package by.training.taskobject.runner;

import by.training.taskobject.action.EllipseInfo;
import by.training.taskobject.creator.Factory;
import by.training.taskobject.entity.Ellipse;
import by.training.taskobject.entity.Point2D;
import by.training.taskobject.entity.Shape;
import by.training.taskobject.parser.Parse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    static final Logger LOGGER = LogManager.getLogger(Runner.class);

    public static void main(final String... args) {
        //Shape el = new Ellipse(new Point2D(1, 2), new Point2D(2, 4));
        //System.out.println(el.toString());
        //EllipseInfo ellipseInfo = new EllipseInfo();
        //System.out.println(ellipseInfo.calcPerimeter());

        //Ellipse ellipse = new Ellipse();
        List<Shape> ellipseList = new ArrayList<>();



        //Validation validation = new Validation();
        List<Double> coordinateList = new ArrayList<>();
        coordinateList.add(1.1);
        coordinateList.add(2.2);
        coordinateList.add(3.3);
        coordinateList.add(4.4);

        coordinateList.add(5.5);
        coordinateList.add(6.6);
        coordinateList.add(7.7);
        coordinateList.add(8.8);
        LOGGER.warn("Illegal arguments");
        int i = 0;
        while (i < coordinateList.size()) {

            Point2D point1 = new Point2D(coordinateList.get(i),
                    coordinateList.get(++i));
            Point2D point2 = new Point2D(coordinateList.get(++i),
                    coordinateList.get(++i));
            ellipseList.add(new Ellipse(point1, point2));

            i++;
        }
        System.out.println(ellipseList);
    }
}
