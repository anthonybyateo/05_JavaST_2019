package test.taskxml.parser;

import by.training.taskxml.entity.tariffs.DateType;
import by.training.taskxml.entity.tariffs.Internet;
import by.training.taskxml.parser.staxbuilder.TariffStAXBuilder;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TariffStAXBuilderTest {

    TariffStAXBuilder builder;
    Internet internet;

    @BeforeClass
    public void setUp() throws ParseException {
        builder = new TariffStAXBuilder();
        internet = new Internet();
        internet.setIdnumber("bit");
        internet.setName("Бит");
        internet.setOperatorName("МТС");
        internet.setPayroll(15.5);
        DateType dateType = new DateType();
        Date start = new SimpleDateFormat("yyyy-MM-dd")
                .parse("2019-04-25");
        dateType.setStart(start);
        Date finish = new SimpleDateFormat("yyyy-MM-dd")
                .parse("2019-07-25");
        dateType.setFinish(finish);
        internet.setDateType(dateType);
        internet.setInternetPrice(0.01);
        internet.setFreeMgb(200);


    }

    @Test
    public void testParseArguments() {
        builder.buildSetTariffType("data/tariffs.xml");
        Assert.assertEquals(builder.getTariffs().contains(internet),true);

    }
}
