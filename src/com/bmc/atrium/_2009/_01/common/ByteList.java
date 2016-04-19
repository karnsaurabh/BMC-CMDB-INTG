
package com.bmc.atrium._2009._01.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ByteList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ByteList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://atrium.bmc.com/2009/01/common}ByteListType"/>
 *         &lt;element name="data" type="{http://atrium.bmc.com/2009/01/common}ByteArray"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ByteList", propOrder = {
    "type",
    "data"
})
public class ByteList {

    @XmlElement(required = true)
    protected ByteListType type;
    @XmlElement(required = true)
    protected ByteArray data;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link ByteListType }
     *     
     */
    public ByteListType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link ByteListType }
     *     
     */
    public void setType(ByteListType value) {
        this.type = value;
    }

    /**
     * Gets the value of the data property.
     * 
     * @return
     *     possible object is
     *     {@link ByteArray }
     *     
     */
    public ByteArray getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *     allowed object is
     *     {@link ByteArray }
     *     
     */
    public void setData(ByteArray value) {
        this.data = value;
    }

}
