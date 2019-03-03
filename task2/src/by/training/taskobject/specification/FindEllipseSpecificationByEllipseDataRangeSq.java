package by.training.taskobject.specification;

import by.training.taskobject.action.EllipseInfo;
import by.training.taskobject.entity.Ellipse;

public class FindEllipseSpecificationByEllipseDataRangeSquare implements
        FindEllipseSpecificationByEllipseData {
    private double squareFrom;
    private double squareTo;

    public FindEllipseSpecificationByEllipseDataRangeSquare(final double square1,
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
    public boolean specified(final Ellipse ellipse) {
        EllipseInfo ellipseInfo = new EllipseInfo();
        double square = ellipseInfo.calcSquare(ellipse);
        return square >= squareFrom && square <= squareTo;
    }

    private double checkSquare(final double square1, final double square2) {
        return square2 - square1;
    }
}
