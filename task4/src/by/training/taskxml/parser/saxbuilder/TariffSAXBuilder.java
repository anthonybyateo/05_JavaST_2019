package by.training.taskxml.parser.saxbuilder;

import by.training.taskxml.parser.AbstractTariffBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class TariffSAXBuilder extends AbstractTariffBuilder {

    static final Logger LOGGER = LogManager.getLogger(TariffSAXBuilder.class);
    private TariffHandler handler;
    private XMLReader reader;

    public TariffSAXBuilder() {
        super();
        handler = new TariffHandler();

        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
        } catch (SAXException e) {
            LOGGER.warn("failure of parsing doc");
        }
    }

    @Override
    public void buildSetTariffType(final String fileName) {
        try {
            reader.parse(fileName);
        } catch (SAXException e) {
            LOGGER.warn("failure of parsing doc");
        } catch (IOException e) {
            LOGGER.error("error i/o");
        }
        tariffs = handler.getTariffs();
    }
}
