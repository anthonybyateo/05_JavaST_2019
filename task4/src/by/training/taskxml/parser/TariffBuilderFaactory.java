package by.training.taskxml.parser;

import by.training.taskxml.parser.dombuilder.TariffDOMBuilder;
import by.training.taskxml.parser.saxbuilder.TariffSAXBuilder;
import by.training.taskxml.parser.staxbuilder.TariffStAXBuilder;

public class TariffBuilderFaactory {
    private enum TypeParser {
        SAX, STAX, DOM
    }
    public AbstractTariffBuilder createTariffBuilder(final String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM:
                return new TariffDOMBuilder();
            case SAX:
                return new TariffSAXBuilder();
            case STAX:
                return new TariffStAXBuilder();
            default:
                throw new EnumConstantNotPresentException
                        (type.getDeclaringClass(), type.name());
        }
    }
}
