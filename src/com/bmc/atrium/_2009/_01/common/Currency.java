
package com.bmc.atrium._2009._01.common;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Currency complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Currency">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="conversionDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="funcCurrencyList" type="{http://atrium.bmc.com/2009/01/common}FunctionalCurrencyList"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Currency", propOrder = {
    "value",
    "code",
    "conversionDate",
    "funcCurrencyList"
})
public class Currency {

    @XmlElement(required = true)
    protected BigDecimal value;
    @XmlElement(required = true)
    protected String code;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar conversionDate;
    @XmlElement(required = true)
    protected FunctionalCurrencyList funcCurrencyList;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the conversionDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getConversionDate() {
        return conversionDate;
    }

    /**
     * Sets the value of the conversionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setConversionDate(XMLGregorianCalendar value) {
        this.conversionDate = value;
    }

    /**
     * Gets the value of the funcCurrencyList property.
     * 
     * @return
     *     possible object is
     *     {@link FunctionalCurrencyList }
     *     
     */
    public FunctionalCurrencyList getFuncCurrencyList() {
        return funcCurrencyList;
    }

    /**
     * Sets the value of the funcCurrencyList property.
     * 
     * @param value
     *     allowed object is
     *     {@link FunctionalCurrencyList }
     *     
     */
    public void setFuncCurrencyList(FunctionalCurrencyList value) {
        this.funcCurrencyList = value;
    }

}
