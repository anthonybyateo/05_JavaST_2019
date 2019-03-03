package test.taskobject.parser;

import by.training.taskobject.parser.ParserData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

public class ParserDataTest {

    private ParserData parser;

    @BeforeClass
    public void setUp() {
        parser = new ParserData();
    }

    @DataProvider(name = "testParseArguments")
    public Object[][] createData1() {
        return new Object[][] {
                {new ArrayList<String>() {{ add("2.0 3.0 4.0 5.0"); }},
                        new ArrayList<Double>(Arrays.asList(2.0, 3.0, 4.0, 5.0)) },
                {new ArrayList<String>() {{ add("2.0 3.z0 4.0 5.0"); }},
                        new ArrayList<Double>(Arrays.asList()) },
                {new ArrayList<String>(),
                        new ArrayList<Double>(Arrays.asList()) },
        };
    }

    @Test(dataProvider = "testParseArguments")
    public void testParseArguments(final List str, final List result) {

        Assert.assertEquals(parser.parseArguments(str), result);

    }
}
