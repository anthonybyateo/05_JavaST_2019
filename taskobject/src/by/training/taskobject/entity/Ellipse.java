package by.training.taskobject.entity;

public class Ellipse extends Shape {

    private Point2D point1;
    private Point2D point2;

    public Ellipse(final Point2D point1, final Point2D point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public Ellipse(final Point2D point1) {
        this.point1 = point1;
        this.point2 = new Point2D();
    }

    public Ellipse() {
        this.point1 = new Point2D();
        this.point2 = new Point2D();
    }

    public Point2D getPoint1() {
        return point1;
    }

    public void setPoint1(final Point2D point1) {
        this.point1 = point1;
    }

    public Point2D getPoint2() {
        return point2;
    }

    public void setPoint2(final Point2D point2) {
        this.point2 = point2;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        return (int) (prime * ((this.getPoint1() == null) ? 0 : this.getPoint1().hashCode())
                + ((this.getPoint2() == null) ? 0 : this.getPoint2().hashCode()));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Ellipse ellipse = (Ellipse) obj;

        if (this.hashCode() != ellipse.hashCode()) {
            return false;
        }

        return (point1 == ellipse.point1 || (point1 != null && point1.equals(ellipse.getPoint1())))
                && (point2 == ellipse.point2 || (point2 != null && point2.equals(ellipse.getPoint1())));
    }


        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            result.append("point1: " + this.getPoint1());
            result.append(" point2: " + this.getPoint2());
            return result.toString();
        }
    }