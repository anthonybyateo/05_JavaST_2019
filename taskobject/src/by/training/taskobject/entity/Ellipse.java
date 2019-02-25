package by.training.taskobject.entity;

public class Oval {

    private Point2D point1;
    private Point2D point2;

    public Oval(final Point2D point1, final Point2D point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public Oval(final Point2D point1) {
        this.point1 = point1;
        this.point2 = new Point2D();
    }

    public Oval() {
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
        return (int) (31 * ((this.getPoint1() == null) ? 0 : this.getPoint1().hashCode())
                + ((this.getPoint2() == null) ? 0 : this.getPoint2().hashCode()));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        Oval oval = (Oval) obj;

        if (this.hashCode() != oval.hashCode()) {
            return false;
        }

        if (point1 == null) {
            if (oval.point1 != null) {
                return false;
            }
        }else {
                if (!point1.equals(oval.point1)) {
                    return false;
                }
        }

            if (point2 == null) {
                if (oval.point2 != null) {
                    return false;
                }
            }else {
                    if (!point2.equals(oval.point2)) {
                        return false;
                    }
                }
        return true;
    }


        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            result.append(getClass().getName() + "@");
            result.append("point1: " + this.getPoint1());
            result.append("point2: " + this.getPoint2());
            return result.toString();
        }
    }