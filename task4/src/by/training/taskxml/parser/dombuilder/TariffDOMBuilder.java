package by.training.taskxml.parser.dombuilder;

import by.training.taskxml.entity.tariffs.CallPrices;
import by.training.taskxml.entity.tariffs.Smartphone;
import by.training.taskxml.entity.tariffs.TariffType;
import by.training.taskxml.parser.AbstractTariffBuilder;
import by.training.taskxml.parser.TariffEnum;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class TariffDOMBuilder extends AbstractTariffBuilder {

    private DocumentBuilder docBuilder;

    public TariffDOMBuilder() {
        super();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            //TODO log
            e.printStackTrace();
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

            for (int i = 0; i < tariffList1.getLength(); i++) {
                Element tariffElement = (Element) tariffList1.item(i);
                TariffType tariffType = buildTariff(tariffElement);
                tariffs.add(tariffType);
            }
            for (int i = 0; i < tariffList2.getLength(); i++) {
                Element tariffElement = (Element) tariffList2.item(i);
                TariffType tariffType = buildTariff(tariffElement);
                tariffs.add(tariffType);
            }
            for (int i = 0; i < tariffList3.getLength(); i++) {
                Element tariffElement = (Element) tariffList3.item(i);
                TariffType tariffType = buildTariff(tariffElement);
                tariffs.add(tariffType);
            }

        } catch (SAXException e) {
            //TODO log
            e.printStackTrace();
        } catch (IOException e) {
            //TODO log
            e.printStackTrace();
        }
    }

    private TariffType buildTariff(Element tariffElement) {
        TariffType tariff = new TariffType();

        if ("smartphone".equals(tariffElement.getTagName())) {
            tariff = new Smartphone();
            tariff.setIdnumber(tariffElement.getAttribute("idnumber"));
            ( (Smartphone) tariff).setTarrifing(tariffElement.getAttribute("tarrifing"));
            tariff.setName(getElementTextContent(tariffElement,
                    "name"));
            tariff.setName(getElementTextContent(tariffElement,
                    "operator_name"));
            Double payroll = Double.parseDouble(getElementTextContent(
                    tariffElement, "payroll"));
            tariff.setPayroll(payroll);
            //Smartphone.DateType dateType = tariff.getDateType();
            CallPrices callPrices = ( (Smartphone) tariff).getCallPrices();
            Element callPricesElement = (Element) tariffElement.
                    getElementsByTagName("call_prices").item(0);
            Double inside = Double.parseDouble(getElementTextContent(
                    callPricesElement, "inside"));
            callPrices.setInside(inside);
            Double outside = Double.parseDouble(getElementTextContent(
                    callPricesElement, "outside"));
            callPrices.setOutside(outside);
            Double landline = Double.parseDouble(getElementTextContent(
                    callPricesElement, TariffEnum.LANDLINE.getValue()));
            callPrices.setLandline(landline);
            Double sms = Double.parseDouble(getElementTextContent(
                    callPricesElement, "sms"));
            callPrices.setSms(sms);
        }

        return tariff;
    }

    private static String getElementTextContent(Element element,
                                                String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
