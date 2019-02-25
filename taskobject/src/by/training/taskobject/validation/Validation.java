package by.training.taskobject.validation;

import by.training.taskobject.entity.Ellipse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static final String DOUBLE = "[+]?[0-9]+[.]?[0-9]*?";

    public boolean checkDataType(final String str) {
        Pattern p = Pattern.compile(DOUBLE);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public boolean checkPoints(final Ellipse ellipse) {
        double x1 = ellipse.getPoint1().getX();
        double x2 = ellipse.getPoint2().getX();
        double y1 = ellipse.getPoint1().getY();
        double y2 = ellipse.getPoint2().getY();

        return !((Math.abs(x2 - x1)) <= 0.001 || (Math.abs(y2 - y1)) <= 0.001);
    }

    public boolean checkPoints(final double x1, final double y1,
                               final double x2, final double y2) {

        return !((Math.abs(x2 - x1)) <= 0.001 || (Math.abs(y2 - y1)) <= 0.001);
    }
}
