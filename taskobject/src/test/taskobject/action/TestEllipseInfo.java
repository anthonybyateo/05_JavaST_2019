package test.taskobject.action;

import by.training.taskobject.action.EllipseInfo;
import by.training.taskobject.entity.Ellipse;
import by.training.taskobject.entity.Point2D;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestEllipseInfo {
    private EllipseInfo ellipseInfo = new EllipseInfo();


    @DataProvider(name = "testcalcSquare")
    public Object[][] createData1() {
        return new Object[][] {
                                { new Ellipse(new Point2D(1, 2), new Point2D(2, 4)), 1.57 },
                                { new Ellipse(new Point2D(1.5, 2.5), new Point2D(4.5, 6.5)), 9.42 },
                                { new Ellipse(new Point2D(2, 4), new Point2D(4, 8)), 6.28 }
                              };
    }

    @Test(dataProvider = "testcalcSquare")
    public void testcalcSquare(final Ellipse ellipse, final double result) {

        ellipseInfo.setEllipse(ellipse);
        assertEquals(ellipseInfo.calcSquare(), result, 0.01);

    }

    @DataProvider(name = "testcalcPerimeter")
    public Object[][] createData2() {
        return new Object[][] {
                { new Ellipse(new Point2D(1, 2), new Point2D(2, 4)), 6.947 },
                { new Ellipse(new Point2D(1.5, 2.5), new Point2D(4.5, 6.5)), 9.42 },
                { new Ellipse(new Point2D(2, 4), new Point2D(4, 8)), 6.28 }
        };
    }


    @Test(dataProvider = "testcalcPerimeter")
    public void testcalcPerimeter(final Ellipse ellipse, final double result) {

        ellipseInfo.setEllipse(ellipse);
        assertEquals(ellipseInfo.calcPerimeter(), result, 0.01);

    }
}
