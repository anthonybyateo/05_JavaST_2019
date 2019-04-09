package by.training.taskxml.parser.staxbuilder;

import by.training.taskxml.entity.tariffs.*;
import by.training.taskxml.parser.AbstractTariffBuilder;
import by.training.taskxml.parser.TariffEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TariffStAXBuilder extends AbstractTariffBuilder {

    static final Logger LOGGER = LogManager.getLogger(TariffStAXBuilder.class);
    private XMLInputFactory inputFactory;

    public TariffStAXBuilder() {
        super();
        this.inputFactory = XMLInputFactory.newInstance();
    }

    @Override
    public void buildSetTariffType(String fileName) {
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String name;

        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (TariffEnum.valueOf(name.toUpperCase())
                            == TariffEnum.SMARTPHONE
                            || TariffEnum.valueOf(name.toUpperCase())
                            == TariffEnum.INTERNET
                            || TariffEnum.valueOf(name.toUpperCase())
                            == TariffEnum.ONLY_CALLS) {
                        TariffType tariff = buildTariff(reader);
                        tariffs.add(tariff);
                    }
                }
            }
        } catch (XMLStreamException ex) {
            LOGGER.warn("StAX parsing error!");
        } catch (FileNotFoundException ex) {
            LOGGER.warn("File " + fileName + " not found!");
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                LOGGER.warn("Impossible close file " + fileName);
            }
        }
    }

    private void initTariff(String name, TariffType tariff,
                            XMLStreamReader reader) throws XMLStreamException {
                switch (TariffEnum.valueOf(name.toUpperCase())) {
                    case NAME:
                        tariff.setName(getXMLText(reader));
                        break;
                    case OPERATOR_NAME:
                        tariff.setOperatorName(getXMLText(reader));
                        break;
                    case PAYROLL:
                        name = getXMLText(reader);
                        tariff.setPayroll(Double.parseDouble(name));
                        break;
                    case DATE:
                        tariff.setDateType(getXMLDate(reader));
                        break;
                }
    }

    private TariffType buildTariff(XMLStreamReader reader) throws
            XMLStreamException {
        TariffType tariff = new TariffType();
        if (TariffEnum.INTERNET.getValue().equals(reader.getLocalName())) {
            tariff = new Internet();
            tariff.setIdnumber(reader.getAttributeValue(null,
                    TariffEnum.IDNUMBER.getValue()));
            String name;
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        name = reader.getLocalName();
                        initTariff(name, tariff, reader);
                        switch (TariffEnum.valueOf(name.toUpperCase())) {
                            case INTERNET_PRICE:
                                name = getXMLText(reader);
                                ((Internet) tariff).setInternetPrice(Double
                                        .parseDouble(name));
                                break;
                            case FREE_MGB:
                                name = getXMLText(reader);
                                ((Internet) tariff).setFreeMgb(Double
                                        .parseDouble(name));
                                break;
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        name = reader.getLocalName();
                        if (TariffEnum.valueOf(name.toUpperCase())
                                == TariffEnum.INTERNET) {
                            return tariff;
                        }
                        break;
                }
            }
            return tariff;
        } else if (TariffEnum.ONLY_CALLS.getValue().equals(reader.getLocalName())) {
            tariff = new OnlyCalls();
            tariff.setIdnumber(reader.getAttributeValue(null,
                    TariffEnum.IDNUMBER.getValue()));
            if (reader.getAttributeCount() == 2) {
                ((OnlyCalls) tariff).setTarrifing(reader.
                        getAttributeValue(null,
                                TariffEnum.TARIFFING.getValue()));
            }
            String name;
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        name = reader.getLocalName();
                        initTariff(name, tariff, reader);
                        switch (TariffEnum.valueOf(name.toUpperCase())) {
                            case CALL_PRICES:
                                ((OnlyCalls) tariff)
                                        .setCallPrices(getXMLCallPrices(reader));
                                break;
                            case FREE_MINUTE:
                                name = getXMLText(reader);
                                ((OnlyCalls) tariff).setFreeMinute(Integer
                                        .parseInt(name));
                                break;
                            case PARAMETERS:
                                ((OnlyCalls) tariff)
                                        .setParameters(getXMLParameters(reader));
                                break;
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        name = reader.getLocalName();
                        if (TariffEnum.valueOf(name.toUpperCase())
                                == TariffEnum.ONLY_CALLS) {
                            return tariff;
                        }
                        break;
                }
            }
            return tariff;
        } else if ("smartphone".equals(reader.getLocalName())) {
            tariff = new Smartphone();
            tariff.setIdnumber(reader.getAttributeValue(null,
                    TariffEnum.IDNUMBER.getValue()));
            if (reader.getAttributeCount() == 2) {
                ((Smartphone) tariff).setTarrifing(reader.
                        getAttributeValue(null,
                                TariffEnum.TARIFFING.getValue()));
            }
            String name;
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        name = reader.getLocalName();
                        initTariff(name, tariff, reader);
                        switch (TariffEnum.valueOf(name.toUpperCase())) {
                            case CALL_PRICES:
                                ((Smartphone) tariff)
                                        .setCallPrices(getXMLCallPrices(reader));
                                break;
                            case FREE_MINUTE:
                                name = getXMLText(reader);
                                ((Smartphone) tariff).setFreeMinute(Integer
                                        .parseInt(name));
                                break;
                            case INTERNET_PRICE:
                                name = getXMLText(reader);
                                ((Smartphone) tariff).setInternetPrice(Double
                                        .parseDouble(name));
                                break;
                            case FREE_MGB:
                                name = getXMLText(reader);
                                ((Smartphone) tariff).setFreeMgb(Double
                                        .parseDouble(name));
                                break;
                            case PARAMETERS:
                                ((Smartphone) tariff)
                                        .setParameters(getXMLParameters(reader));
                                break;
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        name = reader.getLocalName();
                        if (TariffEnum.valueOf(name.toUpperCase())
                                == TariffEnum.SMARTPHONE) {
                            return tariff;
                        }
                        break;
                }
            }
        }
        throw new XMLStreamException("Unknown element in tag Student");
    }

    private CallPrices getXMLCallPrices(XMLStreamReader reader)
            throws XMLStreamException {
        CallPrices callPrices = new CallPrices();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (TariffEnum.valueOf(name.toUpperCase())) {
                        case INSIDE:
                            name = getXMLText(reader);
                            callPrices.setInside(Double.parseDouble(name));
                            break;
                        case OUTSIDE:
                            name = getXMLText(reader);
                            callPrices.setOutside(Double.parseDouble(name));
                            break;
                        case LANDLINE:
                            name = getXMLText(reader);
                            callPrices.setLandline(Double.parseDouble(name));
                            break;
                        case SMS:
                            name = getXMLText(reader);
                            callPrices.setSms(Double.parseDouble(name));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (TariffEnum.valueOf(name.toUpperCase()) ==
                            TariffEnum.CALL_PRICES) {
                        return callPrices;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag call_prices");
    }

    private Parameters getXMLParameters(XMLStreamReader reader)
            throws XMLStreamException {
        Parameters parameters = new Parameters();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (TariffEnum.valueOf(name.toUpperCase())) {
                        case FAVORITE_NUMBER:
                            name = getXMLText(reader);
                            parameters.setFavoriteNumber(Integer.parseInt(name));
                            break;
                        case CONNECTION_FEE:
                            name = getXMLText(reader);
                            parameters.setConnectionFee(Double.parseDouble(name));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (TariffEnum.valueOf(name.toUpperCase()) ==
                            TariffEnum.PARAMETERS) {
                        return parameters;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Parameters");
    }

    private DateType getXMLDate(XMLStreamReader reader)
            throws XMLStreamException {
        DateType dateType = new DateType();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (TariffEnum.valueOf(name.toUpperCase())) {
                        case START:
                            name = getXMLText(reader);
                            try {
                                Date startDate =
                                        new SimpleDateFormat("yyyy-MM-dd")
                                                .parse(name);
                                dateType.setStart(startDate);
                            } catch (ParseException e) {
                                LOGGER.warn("failure of parsing date string");
                            }
                            break;
                        case FINISH:
                            name = getXMLText(reader);
                            try {
                                Date finishDate =
                                        new SimpleDateFormat("yyyy-MM-dd")
                                        .parse(name);
                                dateType.setFinish(finishDate);
                            } catch (ParseException e) {
                                LOGGER.warn("failure of parsing date string");
                            }
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (TariffEnum.valueOf(name.toUpperCase()) ==
                            TariffEnum.DATE) {
                        return dateType;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Date");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}