package by.training.taskxml.parser.saxbuilder;

import by.training.taskxml.entity.tariffs.Internet;
import by.training.taskxml.entity.tariffs.OnlyCalls;
import by.training.taskxml.entity.tariffs.Smartphone;
import by.training.taskxml.entity.tariffs.TariffType;
import by.training.taskxml.parser.TariffEnum;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class TariffHandler extends DefaultHandler {

    static final Logger LOGGER = LogManager.getLogger(TariffHandler.class);
    private Set<TariffType> tariffs;
    private TariffType current = null;
    private TariffEnum currentEnum = null;
    private EnumSet<TariffEnum> withText;

    public TariffHandler() {
        tariffs = new HashSet<>();
        withText = EnumSet.range(TariffEnum.IDNUMBER,
                TariffEnum.CONNECTION_FEE);
    }

    public Set<TariffType> getTariffs() {
        return tariffs;
    }

    @Override
    public void startElement(final String url, final String localName,
                             final String qName, final Attributes attrs) {
        if (TariffEnum.SMARTPHONE.getValue().equals(localName)) {
            current = new Smartphone();
            tariffs.add(current);
            current.setIdnumber(attrs.getValue(0));
            if (attrs.getLength() == 2) {
                ((Smartphone) current).setTarrifing(attrs.getValue(1));
            }
        } else if (TariffEnum.INTERNET.getValue().equals(localName)) {
            current = new Internet();
            tariffs.add(current);
            current.setIdnumber(attrs.getValue(0));
        } else if (TariffEnum.ONLY_CALLS.getValue().equals(localName)) {
            current = new OnlyCalls();
            tariffs.add(current);
            current.setIdnumber(attrs.getValue(0));
            if (attrs.getLength() == 2) {
                ((OnlyCalls) current).setTarrifing(attrs.getValue(1));
            }
        } else {
            TariffEnum temp = TariffEnum.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }

    @Override
    public void endElement(final String url, final String localName,
                           final String qName) {
        if (TariffEnum.SMARTPHONE.getValue().equals(localName)
                || TariffEnum.INTERNET.getValue().equals(localName)
                || TariffEnum.ONLY_CALLS.getValue().equals(localName)) {
            tariffs.add(current);
        }
    }

    @Override
    public void characters(final char[] ch, final int start, final int length) {
        String str = new String(ch, start, length).trim();

        if (currentEnum != null) {
            switch (currentEnum) {
                case NAME:
                    current.setName(str);
                    break;
                case OPERATOR_NAME:
                    current.setOperatorName(str);
                    break;
                case PAYROLL:
                    current.setPayroll(Double.parseDouble(str));
                    break;
                case START:
                    try {
                        Date startDate = new SimpleDateFormat("yyyy-MM-dd")
                                .parse(str);
                        current.getDateType().setStart(startDate);
                    } catch (ParseException e) {
                        LOGGER.warn("failure of parsing date string");
                    }
                    break;
                case FINISH:
                    try {
                        Date finishDate = new SimpleDateFormat("yyyy-MM-dd")
                                .parse(str);
                        current.getDateType().setFinish(finishDate);
                    } catch (ParseException e) {
                        LOGGER.warn("failure of parsing date string");
                    }
                    break;
                    default:
            }
        }

        if (current instanceof Smartphone) {
            if (currentEnum != null) {
                switch (currentEnum) {
                    case INSIDE:
                        ((Smartphone) current).getCallPrices()
                                .setInside(Double.parseDouble(str));
                        break;
                    case OUTSIDE:
                        ((Smartphone) current).getCallPrices()
                                .setOutside(Double.parseDouble(str));
                        break;
                    case LANDLINE:
                        ((Smartphone) current).getCallPrices()
                                .setLandline(Double.parseDouble(str));
                        break;
                    case SMS:
                        ((Smartphone) current).getCallPrices()
                                .setSms(Double.parseDouble(str));
                        break;
                    case FREE_MINUTE:
                        ((Smartphone) current)
                                .setFreeMinute(Integer.parseInt(str));
                        break;
                    case INTERNET_PRICE:
                        ((Smartphone) current)
                                .setInternetPrice(Double.parseDouble(str));
                        break;
                    case FREE_MGB:
                        ((Smartphone) current)
                                .setFreeMgb(Double.parseDouble(str));
                        break;
                    case FAVORITE_NUMBER:
                        ((Smartphone) current).getParameters()
                                .setFavoriteNumber(Integer.parseInt(str));
                        break;
                    case CONNECTION_FEE:
                        ((Smartphone) current).getParameters()
                                .setConnectionFee(Double.parseDouble(str));
                        break;
                    default:
                }
            }
        }

        if (current instanceof Internet) {
            if (currentEnum != null) {
                switch (currentEnum) {
                    case INTERNET_PRICE:
                        ((Internet) current)
                                .setInternetPrice(Double.parseDouble(str));
                        break;
                    case FREE_MGB:
                        ((Internet) current)
                                .setFreeMgb(Double.parseDouble(str));
                        break;
                    default:
                }
            }
        }
        if (current instanceof OnlyCalls) {
            if (currentEnum != null) {
                switch (currentEnum) {
                    case INSIDE:
                        ((OnlyCalls) current).getCallPrices()
                                .setInside(Double.parseDouble(str));
                        break;
                    case OUTSIDE:
                        ((OnlyCalls) current).getCallPrices()
                                .setOutside(Double.parseDouble(str));
                        break;
                    case LANDLINE:
                        ((OnlyCalls) current).getCallPrices()
                                .setLandline(Double.parseDouble(str));
                        break;
                    case SMS:
                        ((OnlyCalls) current).getCallPrices()
                                .setSms(Double.parseDouble(str));
                        break;
                    case FREE_MINUTE:
                        ((OnlyCalls) current)
                                .setFreeMinute(Integer.parseInt(str));
                        break;
                    case FAVORITE_NUMBER:
                        ((OnlyCalls) current).getParameters()
                                .setFavoriteNumber(Integer.parseInt(str));
                        break;
                    case CONNECTION_FEE:
                        ((OnlyCalls) current).getParameters()
                                .setConnectionFee(Double.parseDouble(str));
                        break;
                    default:
                }
            }
        }
        currentEnum = null;
    }
}
