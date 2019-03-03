package by.training.taskobject.recorder;

import by.training.taskobject.action.EllipseInfo;
import by.training.taskobject.entity.Ellipse;

public class EllipseData {
    private int id;
    private double square;
    private double perimeter;

    public void updateEllipseData(final Ellipse ellipse) {
        EllipseInfo ellipseInfo = new EllipseInfo();
        square = ellipseInfo.calcSquare(ellipse);
        perimeter = ellipseInfo.calcPerimeter(ellipse);
        id = ellipse.getId();
    }

    public int getId() {
        return id;
    }

    public double getSquare() {
        return square;
    }

    public double getPerimeter() {
        return perimeter;
    }


    @Override
    public boolean equals(final Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        EllipseData ellipseData = (EllipseData) obj;

        if (this.hashCode() != ellipseData.hashCode()) {
            return false;
        }

        return (id == ellipseData.id)
                && (Math.abs(square - ellipseData.square) <= 0.001)
                && (Math.abs(perimeter - ellipseData.perimeter) <= 0.001);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        return (int) (prime * id + square + perimeter);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("EllipseData{id: " + this.getId());
        result.append(" square: " + this.getSquare());
        result.append(" perimeter: " + this.getPerimeter() + "}");

        return result.toString();
    }
}
