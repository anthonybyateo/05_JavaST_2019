package by.training.taskxml.parser.staxbuilder;

import by.training.taskxml.entity.tariffs.*;
import by.training.taskxml.parser.AbstractTariffBuilder;
import by.training.taskxml.parser.TariffEnum;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TariffStAXBuilder extends AbstractTariffBuilder {

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
            //TODO log
            System.err.println("StAX parsing error! " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            //TODO log
            System.err.println("File " + fileName + " not found! " + ex);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                //TODO log
                System.err.println("Impossible close file " + fileName + " : " + e);
            }
        }
    }

    private TariffType buildTariff(XMLStreamReader reader) throws
            XMLStreamException {
        TariffType tariff = new TariffType();
        if ("internet".equals(reader.getLocalName())) {
            return tariff;
        } else if ("only_calls".equals(reader.getLocalName())) {
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
                                ((Smartphone) tariff)
                                        .setDateType(getXMLDate(reader));
                                break;
                            case CALL_PRICES:
                                ((Smartphone) tariff)
                                        .setCallPrices(getXMLCallPrices(reader));
                                break;
                            case FREE_MINUTE:
                                name = getXMLText(reader);
                                ((Smartphone) tariff).setFreeMgb(Integer
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
        //TODO log
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
        //TODO log
        throw new XMLStreamException("Unknown element in tag Address");
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
        //TODO log
        throw new XMLStreamException("Unknown element in tag Address");
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
                            //parameters.setFavoriteNumber(Integer.parseInt(name));
                            break;
                        case FINISH:
                            name = getXMLText(reader);
                            //parameters.setConnectionFee(Double.parseDouble(name));
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
        //TODO log
        throw new XMLStreamException("Unknown element in tag Address");
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