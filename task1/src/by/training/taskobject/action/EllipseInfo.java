package by.training.taskobject.action;

import by.training.taskobject.entity.Ellipse;
import by.training.taskobject.validation.Validation;

public class EllipseInfo {
    private static final double PI = 3.14;

    private double calcSemiaxisA(final Ellipse ellipse) {

        return Math.abs(ellipse.getPoint2().getX()
                - ellipse.getPoint1().getX()) / 2;
    }

    private double calcSemiaxisB(final Ellipse ellipse) {

        return Math.abs(ellipse.getPoint2().getY()
                - ellipse.getPoint1().getY()) / 2;
    }

    public double calcSquare(final Ellipse ellipse) {

        return calcSemiaxisA(ellipse) * calcSemiaxisB(ellipse) * PI;
    }

    public double calcPerimeter(final Ellipse ellipse) {
        double a = calcSemiaxisA(ellipse);
        double b = calcSemiaxisB(ellipse);

        return 4 * ((PI * a * b) + ((a - b) * (a - b)) / (a + b));
    }

    public boolean checkExistenceEllipse(final Ellipse ellipse) {

        Validation validation = new Validation();
        return validation.checkPoints(ellipse);
    }

    public boolean checkIntersectionWithOnlyOneAxis(final Ellipse ellipse,
                                                    final double distance) {
        double x1 = ellipse.getPoint1().getX();
        double x2 = ellipse.getPoint2().getX();
        double y1 = ellipse.getPoint1().getY();
        double y2 = ellipse.getPoint2().getY();

        return ((x1 == 0 && y1 == distance) || (x1 == distance && y1 == 0))
                ^ ((x2 == 0 && y2 == distance) || (x2 == distance && y2 == 0));
    }

    public boolean checkCircle(final Ellipse ellipse) {
        double x1 = ellipse.getPoint1().getX();
        double x2 = ellipse.getPoint2().getX();
        double y1 = ellipse.getPoint1().getY();
        double y2 = ellipse.getPoint2().getY();

        return checkExistenceEllipse(ellipse)
                && (Math.abs((x2 - x1) - (y2 - y1))) <= 0.001;
    }
}
