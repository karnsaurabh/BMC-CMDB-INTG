//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.20 at 02:46:03 PM IST 
//


package com.metricstream.itgrc.cmd.asset.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="message_header" type="{}MessageHeaderType"/>
 *         &lt;element name="data_lines" type="{}DataLinesType"/>
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
    "messageHeader",
    "dataLines"
})
@XmlRootElement(name = "Datapacket")
public class Datapacket {

    @XmlElement(name = "message_header", required = true)
    protected MessageHeaderType messageHeader;
    @XmlElement(name = "data_lines", required = true)
    protected DataLinesType dataLines;

    /**
     * Gets the value of the messageHeader property.
     * 
     * @return
     *     possible object is
     *     {@link MessageHeaderType }
     *     
     */
    public MessageHeaderType getMessageHeader() {
        return messageHeader;
    }

    /**
     * Sets the value of the messageHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageHeaderType }
     *     
     */
    public void setMessageHeader(MessageHeaderType value) {
        this.messageHeader = value;
    }

    /**
     * Gets the value of the dataLines property.
     * 
     * @return
     *     possible object is
     *     {@link DataLinesType }
     *     
     */
    public DataLinesType getDataLines() {
        return dataLines;
    }

    /**
     * Sets the value of the dataLines property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataLinesType }
     *     
     */
    public void setDataLines(DataLinesType value) {
        this.dataLines = value;
    }

}