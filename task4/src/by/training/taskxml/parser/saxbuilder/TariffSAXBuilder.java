package by.training.taskxml.parser.saxbuilder;

import by.training.taskxml.parser.AbstractTariffBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class TariffSAXBuilder extends AbstractTariffBuilder {

    private TariffHandler handler;
    private XMLReader reader;

    public TariffSAXBuilder() {
        super();
        handler = new TariffHandler();

        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
        } catch (SAXException e) {
            // TODO log
            e.printStackTrace();
        }
    }

    @Override
    public void buildSetTariffType(final String fileName) {
        try {
            reader.parse(fileName);
        } catch (SAXException e) {
            //TODO log
            e.printStackTrace();
        } catch (IOException e) {
            //TODO log
            e.printStackTrace();
        }
        tariffs = handler.getTariffs();
    }
}
