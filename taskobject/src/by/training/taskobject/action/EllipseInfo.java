package by.training.taskobject.action;

import by.training.taskobject.entity.Ellipse;
import by.training.taskobject.validation.Validation;

public class EllipseInfo {
    private static final double PI = 3.14;
    private Ellipse ellipse;

    public EllipseInfo() {
        this.ellipse = new Ellipse();
    }

    public EllipseInfo(final Ellipse ellipse) {
        this.ellipse = ellipse;
    }

    public Ellipse getEllipse() {
        return ellipse;
    }

    public void setEllipse(final Ellipse ellipse) {
        this.ellipse = ellipse;
    }

    private double calcSemiaxisA() {

        return Math.abs(ellipse.getPoint2().getX()
                - ellipse.getPoint1().getX()) / 2;
    }

    private double calcSemiaxisB() {

        return Math.abs(ellipse.getPoint2().getY()
                - ellipse.getPoint1().getY()) / 2;
    }

    public double calcSquare() {

        return calcSemiaxisA() * calcSemiaxisB() * PI;
    }

    public double calcPerimeter() {
        double a = calcSemiaxisA();
        double b = calcSemiaxisB();

        return 4 * ((PI * a * b) + ((a - b) * (a - b)) / (a + b));
    }

    public boolean checkExistenceEllipse() {

        Validation validation = new Validation();
        return validation.checkPoints(ellipse);
    }

    public boolean checkIntersectionWithOnlyOneAxis(final double distance) {
        double x1 = ellipse.getPoint1().getX();
        double x2 = ellipse.getPoint2().getX();
        double y1 = ellipse.getPoint1().getY();
        double y2 = ellipse.getPoint2().getY();

        return ((x1 == 0 && y1 == distance) || (x1 == distance && y1 == 0))
                ^ ((x2 == 0 && y2 == distance) || (x2 == distance && y2 == 0));
        }

    public boolean checkCircle() {
        double x1 = ellipse.getPoint1().getX();
        double x2 = ellipse.getPoint2().getX();
        double y1 = ellipse.getPoint1().getY();
        double y2 = ellipse.getPoint2().getY();

        return checkExistenceEllipse() && (x2 - x1 == y2 - y1);
    }
}
