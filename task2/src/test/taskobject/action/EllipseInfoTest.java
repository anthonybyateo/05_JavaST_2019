package test.taskobject.action;

import by.training.taskobject.action.EllipseInfo;
import by.training.taskobject.entity.Ellipse;
import by.training.taskobject.entity.Point2D;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EllipseInfoTest {

    private EllipseInfo ellipseInfo;

    @BeforeClass
    public void setUp() {
        ellipseInfo = new EllipseInfo();
    }

    @DataProvider(name = "testCalcSquare")
    public Object[][] createData1() {
        return new Object[][] {
                                {new Ellipse(new Point2D(1, 2), new Point2D(2, 4)), 1.57 },
                                {new Ellipse(new Point2D(1.5, 2.5), new Point2D(4.5, 6.5)), 9.42 },
                                {new Ellipse(new Point2D(2, 4), new Point2D(4, 8)), 6.28 }
                              };
    }

    @Test(dataProvider = "testCalcSquare")
    public void testCalcSquare(final Ellipse ellipse, final double result) {

        Assert.assertEquals(ellipseInfo.calcSquare(ellipse), result, 0.01);

    }

    @DataProvider(name = "testCalcPerimeter")
    public Object[][] createData2() {
        return new Object[][] {
                {new Ellipse(new Point2D(1, 2), new Point2D(2, 4)), 6.947 },
                {new Ellipse(new Point2D(1.5, 2.5), new Point2D(4.5, 6.5)), 37.967 },
                {new Ellipse(new Point2D(2, 4), new Point2D(4, 8)), 26.453 }
        };
    }


    @Test(dataProvider = "testCalcPerimeter")
    public void testCalcPerimeter(final Ellipse ellipse, final double result) {

        Assert.assertEquals(ellipseInfo
                .calcPerimeter(ellipse), result, 0.01);

    }

    @DataProvider(name = "testCheckExistenceEllipse")
    public Object[][] createDat3() {
        return new Object[][] {
                {new Ellipse(new Point2D(1, 2), new Point2D(1, 4)), false },
                {new Ellipse(new Point2D(1.5, 2.5), new Point2D(4.5, 6.5)), true },
                {new Ellipse(new Point2D(2, 4), new Point2D(3, 4)), false }
        };
    }

    @Test(dataProvider = "testCheckExistenceEllipse")
    public void testCheckExistenceEllipse(final Ellipse ellipse, final boolean result) {

        Assert.assertEquals(ellipseInfo.checkExistenceEllipse(ellipse), result);
    }

    @DataProvider(name = "testCheckIntersectionWithOnlyOneAxis")
    public Object[][] createDat4() {
        return new Object[][] {
                {new Ellipse(new Point2D(0, 2), new Point2D(1, 4)), 2, true },
                {new Ellipse(new Point2D(1.5, 2.5), new Point2D(1, 0)), 1, true },
                {new Ellipse(new Point2D(2, 4), new Point2D(1, 2)), 2, false }
        };
    }

    @Test(dataProvider = "testCheckIntersectionWithOnlyOneAxis")
    public void testCheckIntersectionWithOnlyOneAxis(final Ellipse ellipse,
                                                     final double distance,
                                                     final boolean result) {

        Assert.assertEquals(ellipseInfo
                .checkIntersectionWithOnlyOneAxis(ellipse, distance), result);
    }

    @DataProvider(name = "testCheckCircle")
    public Object[][] createData5() {
        return new Object[][] {
                {new Ellipse(new Point2D(1, 2), new Point2D(1, 4)), false },
                {new Ellipse(new Point2D(1.5, 2.5), new Point2D(2.5, 3.5)), true },
                {new Ellipse(new Point2D(2, 4), new Point2D(3, 4)), false }
        };
    }

    @Test(dataProvider = "testCheckCircle")
    public void testCheckCircle(final Ellipse ellipse, final boolean result) {

        Assert.assertEquals(ellipseInfo.checkExistenceEllipse(ellipse), result);
    }
}
