
package com.bmc.atrium._2009._01.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AtriumBackendFault complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AtriumBackendFault">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="status" type="{http://atrium.bmc.com/2009/01/common}StatusList"/>
 *         &lt;element name="extensions" type="{http://atrium.bmc.com/2009/01/common}ExtensionList"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AtriumBackendFault", propOrder = {
    "status",
    "extensions"
})
public class AtriumBackendFault {

    @XmlElement(required = true)
    protected StatusList status;
    @XmlElement(required = true, nillable = true)
    protected ExtensionList extensions;

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link StatusList }
     *     
     */
    public StatusList getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusList }
     *     
     */
    public void setStatus(StatusList value) {
        this.status = value;
    }

    /**
     * Gets the value of the extensions property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionList }
     *     
     */
    public ExtensionList getExtensions() {
        return extensions;
    }

    /**
     * Sets the value of the extensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionList }
     *     
     */
    public void setExtensions(ExtensionList value) {
        this.extensions = value;
    }

}
