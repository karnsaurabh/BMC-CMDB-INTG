
package com.bmc.atrium._2009._01.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Status complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Status">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="statusType" type="{http://atrium.bmc.com/2009/01/common}StatusType"/>
 *         &lt;element name="messageNum" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="messageText" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="appendedText" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Status", propOrder = {
    "statusType",
    "messageNum",
    "messageText",
    "appendedText"
})
public class Status {

    @XmlElement(required = true)
    protected StatusType statusType;
    protected long messageNum;
    @XmlElement(required = true)
    protected String messageText;
    @XmlElement(required = true)
    protected String appendedText;

    /**
     * Gets the value of the statusType property.
     * 
     * @return
     *     possible object is
     *     {@link StatusType }
     *     
     */
    public StatusType getStatusType() {
        return statusType;
    }

    /**
     * Sets the value of the statusType property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusType }
     *     
     */
    public void setStatusType(StatusType value) {
        this.statusType = value;
    }

    /**
     * Gets the value of the messageNum property.
     * 
     */
    public long getMessageNum() {
        return messageNum;
    }

    /**
     * Sets the value of the messageNum property.
     * 
     */
    public void setMessageNum(long value) {
        this.messageNum = value;
    }

    /**
     * Gets the value of the messageText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageText() {
        return messageText;
    }

    /**
     * Sets the value of the messageText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageText(String value) {
        this.messageText = value;
    }

    /**
     * Gets the value of the appendedText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppendedText() {
        return appendedText;
    }

    /**
     * Sets the value of the appendedText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppendedText(String value) {
        this.appendedText = value;
    }

}
