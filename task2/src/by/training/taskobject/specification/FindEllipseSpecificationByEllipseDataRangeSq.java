package by.training.taskobject.specification;

import by.training.taskobject.action.EllipseInfo;
import by.training.taskobject.entity.Ellipse;
import by.training.taskobject.recorder.EllipseData;

public class FindEllipseSpecificationByEllipseDataRangeSq implements
        FindEllipseSpecificationByEllipseData {
    private double squareFrom;
    private double squareTo;

    public FindEllipseSpecificationByEllipseDataRangeSq(final double square1,
                                                        final double square2) {
        if (checkSquare(square1, square2) >= 0) {
            this.squareFrom = square1;
            this.squareTo = square2;
        } else {
            this.squareFrom = square2;
            this.squareTo = square1;
        }

    }

    @Override
    public boolean specified(final EllipseData ellipseData) {
        double square = ellipseData.getSquare();
        return square >= squareFrom && square <= squareTo;
    }

    private double checkSquare(final double square1, final double square2) {
        return square2 - square1;
    }
}
