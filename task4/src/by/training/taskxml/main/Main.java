package by.training.taskxml.main;

import by.training.taskxml.parser.AbstractTariffBuilder;
import by.training.taskxml.parser.TariffBuilderFaactory;

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

        System.out.println(saxBuilder.getTariffs().toString());
        System.out.println(domBuilder.getTariffs().toString());
        System.out.println(staxBuilder.getTariffs().toString());
    }
}

