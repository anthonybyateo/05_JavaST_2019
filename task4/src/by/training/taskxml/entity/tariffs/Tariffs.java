//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.03.29 at 02:15:37 AM MSK 
//


package by.training.taskxml.entity.tariffs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.training.by/tariffs}tariff" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "tariff"
})
@XmlRootElement(name = "tariffs")
public class Tariffs {

    @XmlElementRef(name = "tariff", namespace = "http://www.training.by/tariffs", type = JAXBElement.class)
    protected List<TariffType> tariff;

    /**
     * Gets the value of the tariff property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tariff property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTariff().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link OnlyCalls }{@code >}
     * {@link JAXBElement }{@code <}{@link Internet }{@code >}
     * {@link JAXBElement }{@code <}{@link Smartphone }{@code >}
     * {@link JAXBElement }{@code <}{@link TariffType }{@code >}
     * 
     * 
     */
    public TariffType getTariff(int index) {
        return tariff.get(index);
    }

    public void setTariff(TariffType tariff) {
        this.tariff.add(tariff);
    }
}
