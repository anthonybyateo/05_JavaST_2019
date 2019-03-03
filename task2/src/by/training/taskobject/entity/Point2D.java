/*
 * @(#)Point2D.java 1.00 19/02/15
 */

package by.training.taskobject.entity;

/**
 * It is the description of entity of Point2D.
 *
 * @version 1.00 15 Feb 2019
 * @author Anton Radchanka
 * @since 1.00
 */
public class Point2D extends Shape {

    /** id is an identifier of point.*/
    private int id;

    /** x is a coordinate of point.*/
    private double x;

    /** y is a coordinate of point.*/
    private double y;

    /**
     * Constructs a point with two double parameter.
     *
     * @param x is a coordinate of point.
     * @param y is a coordinate of point.
     */
    public Point2D(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructs a point with a double parameter.
     *
     * @param x is a coordinate of point.
     */
    public Point2D(final double x) {
        this.x = x;
        this.y = 0;
    }

    /**
     * Constructs a point without parameters.
     */
    public Point2D() {
        this.x = 0;
        this.y = 0;
    }

    public double getX() {
        return x;
    }

    public void setX(final double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(final double y) {
        this.y = y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        return (int) (prime * getX() + getY());
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Point2D point = (Point2D) obj;

        if (hashCode() != point.hashCode()) {
            return false;
        }

        if (x != point.x) {
            return false;
        }

        if (y != point.y) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("(" + this.getX());
        result.append(", " + this.getY() + ")");
        return result.toString();
    }
}
