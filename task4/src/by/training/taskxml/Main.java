package by.training.taskxml;

import by.training.taskxml.entity.tariffs.Smartphone;
import by.training.taskxml.parser.AbstractTariffBuilder;
import by.training.taskxml.parser.TariffBuilderFaactory;
import by.training.taskxml.parser.dombuilder.TariffDOMBuilder;
import by.training.taskxml.parser.saxbuilder.TariffSAXBuilder;
import by.training.taskxml.parser.staxbuilder.TariffStAXBuilder;

public class Main {

    public static void main(String[] args) {
        String path = "data/tariffs.xml";

        TariffBuilderFaactory factory = new TariffBuilderFaactory();

        AbstractTariffBuilder saxBuilder = factory.createTariffBuilder("sax");
        AbstractTariffBuilder domBuilder = factory.createTariffBuilder("dom");
        AbstractTariffBuilder staxBuilder = factory.createTariffBuilder("stax");

        saxBuilder.buildSetTariffType(path);
        domBuilder.buildSetTariffType(path);
        staxBuilder.buildSetTariffType(path);


        System.out.println(saxBuilder.getTariffs());
        System.out.println(domBuilder.getTariffs());
        System.out.println(staxBuilder.getTariffs());
    }
}
