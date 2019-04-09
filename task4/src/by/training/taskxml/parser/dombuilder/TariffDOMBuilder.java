package by.training.taskxml.parser.dombuilder;

import by.training.taskxml.entity.tariffs.*;
import by.training.taskxml.parser.AbstractTariffBuilder;
import by.training.taskxml.parser.TariffEnum;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TariffDOMBuilder extends AbstractTariffBuilder {

    static final Logger LOGGER = LogManager.getLogger(TariffDOMBuilder.class);
    private DocumentBuilder docBuilder;

    public TariffDOMBuilder() {
        super();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOGGER.error("failure of creation DocumentBuilderFactory");
        }
    }

    private void addTariff(final NodeList tariffList) {
        for (int i = 0; i < tariffList.getLength(); i++) {
            Element tariffElement = (Element) tariffList.item(i);
            TariffType tariffType = buildTariff(tariffElement);
            tariffs.add(tariffType);
        }
    }

    @Override
    public void buildSetTariffType(String fileName) {
        Document doc = null;
        try {
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            NodeList tariffList1 = root.getElementsByTagName("smartphone");
            NodeList tariffList2 = root.getElementsByTagName("internet");
            NodeList tariffList3 = root.getElementsByTagName("only_calls");

            addTariff(tariffList1);
            addTariff(tariffList2);
            addTariff(tariffList3);

        } catch (SAXException e) {
            LOGGER.warn("failure of parsing doc");
        } catch (IOException e) {
            LOGGER.error("error i/o");
        }
    }

    private void initTariff(final Element tariffElement,
                       final TariffType tariff) {

        tariff.setIdnumber(tariffElement
                .getAttribute(TariffEnum.IDNUMBER.getValue()));

        tariff.setName(getElementTextContent(tariffElement,
                TariffEnum.NAME.getValue()));

        tariff.setOperatorName(getElementTextContent(tariffElement,
                TariffEnum.OPERATOR_NAME.getValue()));

        Double payroll = Double.parseDouble(getElementTextContent(
                tariffElement, TariffEnum.PAYROLL.getValue()));
        tariff.setPayroll(payroll);

        DateType dateType = tariff.getDateType();
        Element dateTypeElement = (Element) tariffElement.
                getElementsByTagName(TariffEnum.DATE.getValue())
                .item(0);
        try {
            Date startDate = new SimpleDateFormat("yyyy-MM-dd")
                    .parse(getElementTextContent(dateTypeElement,
                            TariffEnum.START.getValue()));
            dateType.setStart(startDate);
        } catch (ParseException e) {
            LOGGER.warn("failure of parsing date string");
        }
        try {
            Date finishDate = new SimpleDateFormat("yyyy-MM-dd")
                    .parse(getElementTextContent(dateTypeElement,
                            TariffEnum.FINISH.getValue()));
            dateType.setFinish(finishDate);
        } catch (ParseException e) {
            LOGGER.warn("failure of parsing date string");
        }
    }

    private void initSmartphone(final Element tariffElement,
                                final TariffType tariff) {
        initTariff(tariffElement, tariff);

        ( (Smartphone) tariff).setTarrifing(tariffElement
                .getAttribute(TariffEnum.TARIFFING.getValue()));

        CallPrices callPrices = ( (Smartphone) tariff).getCallPrices();
        Element callPricesElement = (Element) tariffElement.
                getElementsByTagName(TariffEnum.CALL_PRICES.getValue())
                .item(0);
        Double inside = Double.parseDouble(getElementTextContent(
                callPricesElement, TariffEnum.INSIDE.getValue()));
        callPrices.setInside(inside);
        Double outside = Double.parseDouble(getElementTextContent(
                callPricesElement, TariffEnum.OUTSIDE.getValue()));
        callPrices.setOutside(outside);
        Double landline = Double.parseDouble(getElementTextContent(
                callPricesElement, TariffEnum.LANDLINE.getValue()));
        callPrices.setLandline(landline);
        Double sms = Double.parseDouble(getElementTextContent(
                callPricesElement, TariffEnum.SMS.getValue()));
        callPrices.setSms(sms);

        Parameters parameters = ( (Smartphone) tariff).getParameters();
        Element parametersElement = (Element) tariffElement.
                getElementsByTagName(TariffEnum.PARAMETERS.getValue())
                .item(0);
        Integer favoriteNumber = Integer.parseInt(getElementTextContent(
                parametersElement, TariffEnum.FAVORITE_NUMBER.getValue()));
        parameters.setFavoriteNumber(favoriteNumber);
        Double connectionFee = Double.parseDouble(getElementTextContent(
                parametersElement, TariffEnum.CONNECTION_FEE.getValue()));
        parameters.setConnectionFee(connectionFee);

        Integer freeMinute = Integer.parseInt(getElementTextContent(
                tariffElement, TariffEnum.FREE_MINUTE.getValue()));
        ((Smartphone) tariff).setFreeMinute(freeMinute);

        Double internetPrice = Double.parseDouble(getElementTextContent(
                tariffElement, TariffEnum.INTERNET_PRICE.getValue()));
        ((Smartphone) tariff).setInternetPrice(internetPrice);

        Double freeMgb = Double.parseDouble(getElementTextContent(
                tariffElement, TariffEnum.FREE_MGB.getValue()));
        ((Smartphone) tariff).setFreeMgb(freeMgb);
    }

    private void initInternet(final Element tariffElement,
                                final TariffType tariff) {
        initTariff(tariffElement, tariff);

        Double internetPrice = Double.parseDouble(getElementTextContent(
                tariffElement, TariffEnum.INTERNET_PRICE.getValue()));
        ((Internet) tariff).setInternetPrice(internetPrice);

        Double freeMgb = Double.parseDouble(getElementTextContent(
                tariffElement, TariffEnum.FREE_MGB.getValue()));
        ((Internet) tariff).setFreeMgb(freeMgb);
    }

    private void initOnlyCalls(final Element tariffElement,
                                final TariffType tariff) {
        initTariff(tariffElement, tariff);

        ( (OnlyCalls) tariff).setTarrifing(tariffElement
                .getAttribute(TariffEnum.TARIFFING.getValue()));

        CallPrices callPrices = ( (OnlyCalls) tariff).getCallPrices();
        Element callPricesElement = (Element) tariffElement.
                getElementsByTagName(TariffEnum.CALL_PRICES.getValue())
                .item(0);
        Double inside = Double.parseDouble(getElementTextContent(
                callPricesElement, TariffEnum.INSIDE.getValue()));
        callPrices.setInside(inside);
        Double outside = Double.parseDouble(getElementTextContent(
                callPricesElement, TariffEnum.OUTSIDE.getValue()));
        callPrices.setOutside(outside);
        Double landline = Double.parseDouble(getElementTextContent(
                callPricesElement, TariffEnum.LANDLINE.getValue()));
        callPrices.setLandline(landline);
        Double sms = Double.parseDouble(getElementTextContent(
                callPricesElement, TariffEnum.SMS.getValue()));
        callPrices.setSms(sms);

        Parameters parameters = ( (OnlyCalls) tariff).getParameters();
        Element parametersElement = (Element) tariffElement.
                getElementsByTagName(TariffEnum.PARAMETERS.getValue())
                .item(0);
        Integer favoriteNumber = Integer.parseInt(getElementTextContent(
                parametersElement, TariffEnum.FAVORITE_NUMBER.getValue()));
        parameters.setFavoriteNumber(favoriteNumber);
        Double connectionFee = Double.parseDouble(getElementTextContent(
                parametersElement, TariffEnum.CONNECTION_FEE.getValue()));
        parameters.setConnectionFee(connectionFee);

        Integer freeMinute = Integer.parseInt(getElementTextContent(
                tariffElement, TariffEnum.FREE_MINUTE.getValue()));
        ((OnlyCalls) tariff).setFreeMinute(freeMinute);

    }

    private TariffType buildTariff(Element tariffElement) {
        TariffType tariff = new TariffType();

        if (TariffEnum.SMARTPHONE.getValue().equals(tariffElement.getTagName())) {
            tariff = new Smartphone();
            initSmartphone(tariffElement, tariff);

        }
        if (TariffEnum.INTERNET.getValue().equals(tariffElement.getTagName())) {
            tariff = new Internet();
            initInternet(tariffElement, tariff);

        }
        if (TariffEnum.ONLY_CALLS.getValue().equals(tariffElement.getTagName())) {
            tariff = new OnlyCalls();
            initOnlyCalls(tariffElement, tariff);

        }

        return tariff;
    }

    private static String getElementTextContent(Element element,
                                                String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }
}
