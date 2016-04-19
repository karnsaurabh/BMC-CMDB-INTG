
package com.bmc.atrium._2009._01.common;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Value complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Value">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="nullValue" type="{http://atrium.bmc.com/2009/01/common}NullType"/>
 *         &lt;element name="intValue" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="keywordValue" type="{http://atrium.bmc.com/2009/01/common}Keyword"/>
 *         &lt;element name="bitMaskValue" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ulongValue" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="doubleValue" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="stringValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="diaryValue" type="{http://atrium.bmc.com/2009/01/common}DiaryValue"/>
 *         &lt;element name="enumValue" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="byteListValue" type="{http://atrium.bmc.com/2009/01/common}ByteList"/>
 *         &lt;element name="decimalValue" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="attachValue" type="{http://atrium.bmc.com/2009/01/common}Attachment"/>
 *         &lt;element name="coordListValue" type="{http://atrium.bmc.com/2009/01/common}CoordinateList"/>
 *         &lt;element name="currencyValue" type="{http://atrium.bmc.com/2009/01/common}Currency"/>
 *         &lt;element name="dateValue" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="timeOfDayValue" type="{http://www.w3.org/2001/XMLSchema}time"/>
 *         &lt;element name="timeValue" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Value", propOrder = {
    "nullValue",
    "intValue",
    "keywordValue",
    "bitMaskValue",
    "ulongValue",
    "doubleValue",
    "stringValue",
    "diaryValue",
    "enumValue",
    "byteListValue",
    "decimalValue",
    "attachValue",
    "coordListValue",
    "currencyValue",
    "dateValue",
    "timeOfDayValue",
    "timeValue"
})
public class Value {

    protected NullType nullValue;
    protected Integer intValue;
    protected Keyword keywordValue;
    protected Long bitMaskValue;
    protected Long ulongValue;
    protected Double doubleValue;
    protected String stringValue;
    protected DiaryValue diaryValue;
    protected Integer enumValue;
    protected ByteList byteListValue;
    protected BigDecimal decimalValue;
    protected Attachment attachValue;
    protected CoordinateList coordListValue;
    protected Currency currencyValue;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateValue;
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar timeOfDayValue;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timeValue;

    /**
     * Gets the value of the nullValue property.
     * 
     * @return
     *     possible object is
     *     {@link NullType }
     *     
     */
    public NullType getNullValue() {
        return nullValue;
    }

    /**
     * Sets the value of the nullValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link NullType }
     *     
     */
    public void setNullValue(NullType value) {
        this.nullValue = value;
    }

    /**
     * Gets the value of the intValue property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIntValue() {
        return intValue;
    }

    /**
     * Sets the value of the intValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIntValue(Integer value) {
        this.intValue = value;
    }

    /**
     * Gets the value of the keywordValue property.
     * 
     * @return
     *     possible object is
     *     {@link Keyword }
     *     
     */
    public Keyword getKeywordValue() {
        return keywordValue;
    }

    /**
     * Sets the value of the keywordValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Keyword }
     *     
     */
    public void setKeywordValue(Keyword value) {
        this.keywordValue = value;
    }

    /**
     * Gets the value of the bitMaskValue property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBitMaskValue() {
        return bitMaskValue;
    }

    /**
     * Sets the value of the bitMaskValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBitMaskValue(Long value) {
        this.bitMaskValue = value;
    }

    /**
     * Gets the value of the ulongValue property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUlongValue() {
        return ulongValue;
    }

    /**
     * Sets the value of the ulongValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUlongValue(Long value) {
        this.ulongValue = value;
    }

    /**
     * Gets the value of the doubleValue property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDoubleValue() {
        return doubleValue;
    }

    /**
     * Sets the value of the doubleValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDoubleValue(Double value) {
        this.doubleValue = value;
    }

    /**
     * Gets the value of the stringValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStringValue() {
        return stringValue;
    }

    /**
     * Sets the value of the stringValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStringValue(String value) {
        this.stringValue = value;
    }

    /**
     * Gets the value of the diaryValue property.
     * 
     * @return
     *     possible object is
     *     {@link DiaryValue }
     *     
     */
    public DiaryValue getDiaryValue() {
        return diaryValue;
    }

    /**
     * Sets the value of the diaryValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link DiaryValue }
     *     
     */
    public void setDiaryValue(DiaryValue value) {
        this.diaryValue = value;
    }

    /**
     * Gets the value of the enumValue property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEnumValue() {
        return enumValue;
    }

    /**
     * Sets the value of the enumValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEnumValue(Integer value) {
        this.enumValue = value;
    }

    /**
     * Gets the value of the byteListValue property.
     * 
     * @return
     *     possible object is
     *     {@link ByteList }
     *     
     */
    public ByteList getByteListValue() {
        return byteListValue;
    }

    /**
     * Sets the value of the byteListValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link ByteList }
     *     
     */
    public void setByteListValue(ByteList value) {
        this.byteListValue = value;
    }

    /**
     * Gets the value of the decimalValue property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDecimalValue() {
        return decimalValue;
    }

    /**
     * Sets the value of the decimalValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDecimalValue(BigDecimal value) {
        this.decimalValue = value;
    }

    /**
     * Gets the value of the attachValue property.
     * 
     * @return
     *     possible object is
     *     {@link Attachment }
     *     
     */
    public Attachment getAttachValue() {
        return attachValue;
    }

    /**
     * Sets the value of the attachValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Attachment }
     *     
     */
    public void setAttachValue(Attachment value) {
        this.attachValue = value;
    }

    /**
     * Gets the value of the coordListValue property.
     * 
     * @return
     *     possible object is
     *     {@link CoordinateList }
     *     
     */
    public CoordinateList getCoordListValue() {
        return coordListValue;
    }

    /**
     * Sets the value of the coordListValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link CoordinateList }
     *     
     */
    public void setCoordListValue(CoordinateList value) {
        this.coordListValue = value;
    }

    /**
     * Gets the value of the currencyValue property.
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    public Currency getCurrencyValue() {
        return currencyValue;
    }

    /**
     * Sets the value of the currencyValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setCurrencyValue(Currency value) {
        this.currencyValue = value;
    }

    /**
     * Gets the value of the dateValue property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateValue() {
        return dateValue;
    }

    /**
     * Sets the value of the dateValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateValue(XMLGregorianCalendar value) {
        this.dateValue = value;
    }

    /**
     * Gets the value of the timeOfDayValue property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimeOfDayValue() {
        return timeOfDayValue;
    }

    /**
     * Sets the value of the timeOfDayValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimeOfDayValue(XMLGregorianCalendar value) {
        this.timeOfDayValue = value;
    }

    /**
     * Gets the value of the timeValue property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimeValue() {
        return timeValue;
    }

    /**
     * Sets the value of the timeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimeValue(XMLGregorianCalendar value) {
        this.timeValue = value;
    }

}
