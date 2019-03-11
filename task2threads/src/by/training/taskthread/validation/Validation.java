package by.training.taskthread.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static final String INTEGER = "[0-9]+";

    public boolean checkDataType(final String str) {
        Pattern p = Pattern.compile(INTEGER);
        Matcher m = p.matcher(str);
        return m.matches();
    }
}
