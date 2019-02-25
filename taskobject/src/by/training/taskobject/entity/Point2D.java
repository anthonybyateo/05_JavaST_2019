/*
 * @(#)Blah.java 1.82 99/03/18
 *
 * Copyright (c) 1994-1999 Sun Microsystems, Inc.
 * 901 San Antonio Road, Palo Alto, California, 94303, U.S.A.
 * All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Sun
 * Microsystems, Inc. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */

package by.training.taskobject.entity;

public class Point2D {
    private double x;
    private double y;

    public Point2D(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public Point2D(final double x) {
        this.x = x;
        this.y = 0;
    }

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
        return (int) (31 * getX() + getY());
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        Point2D point = (Point2D) obj;

        if (this.hashCode() != point.hashCode()) {
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
        result.append(getClass().getName() + "@");
        result.append("x: " + this.getX());
        result.append("y " + this.getY());
        return result.toString();
    }
}
