package by.training.taskxml.parser.saxbuilder;

import by.training.taskxml.entity.tariffs.TariffType;
import by.training.taskxml.parser.BaseBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.Set;

public class TariffSAXBuilder implements BaseBuilder {

    private Set<TariffType> tariffs;
    private TariffHandler handler;
    private XMLReader reader;

    public TariffSAXBuilder() {
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
    public Set<TariffType> getTariffType() {
        return tariffs;
    }

    @Override
    public void buildTariffType(final String fileName) {
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
