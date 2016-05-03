
package com.bmc.atrium._2009._01.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ExpirationOut complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExpirationOut">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="expirationDuration" type="{http://www.w3.org/2001/XMLSchema}duration"/>
 *         &lt;element name="expirationDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="isExpired" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExpirationOut", propOrder = {
    "expirationDuration",
    "expirationDateTime",
    "isExpired"
})
public class ExpirationOut {

    @XmlElement(required = true)
    protected Duration expirationDuration;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expirationDateTime;
    protected boolean isExpired;

    /**
     * Gets the value of the expirationDuration property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getExpirationDuration() {
        return expirationDuration;
    }

    /**
     * Sets the value of the expirationDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setExpirationDuration(Duration value) {
        this.expirationDuration = value;
    }

    /**
     * Gets the value of the expirationDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpirationDateTime() {
        return expirationDateTime;
    }

    /**
     * Sets the value of the expirationDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpirationDateTime(XMLGregorianCalendar value) {
        this.expirationDateTime = value;
    }

    /**
     * Gets the value of the isExpired property.
     * 
     */
    public boolean isIsExpired() {
        return isExpired;
    }

    /**
     * Sets the value of the isExpired property.
     * 
     */
    public void setIsExpired(boolean value) {
        this.isExpired = value;
    }

}
