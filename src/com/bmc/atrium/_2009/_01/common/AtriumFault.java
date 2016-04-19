
package com.bmc.atrium._2009._01.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *       &lt;choice>
 *         &lt;element name="serviceFault" type="{http://atrium.bmc.com/2009/01/common}AtriumServiceFault"/>
 *         &lt;element name="backendFault" type="{http://atrium.bmc.com/2009/01/common}AtriumBackendFault"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "serviceFault",
    "backendFault"
})
@XmlRootElement(name = "AtriumFault")
public class AtriumFault {

    protected AtriumServiceFault serviceFault;
    protected AtriumBackendFault backendFault;

    /**
     * Gets the value of the serviceFault property.
     * 
     * @return
     *     possible object is
     *     {@link AtriumServiceFault }
     *     
     */
    public AtriumServiceFault getServiceFault() {
        return serviceFault;
    }

    /**
     * Sets the value of the serviceFault property.
     * 
     * @param value
     *     allowed object is
     *     {@link AtriumServiceFault }
     *     
     */
    public void setServiceFault(AtriumServiceFault value) {
        this.serviceFault = value;
    }

    /**
     * Gets the value of the backendFault property.
     * 
     * @return
     *     possible object is
     *     {@link AtriumBackendFault }
     *     
     */
    public AtriumBackendFault getBackendFault() {
        return backendFault;
    }

    /**
     * Sets the value of the backendFault property.
     * 
     * @param value
     *     allowed object is
     *     {@link AtriumBackendFault }
     *     
     */
    public void setBackendFault(AtriumBackendFault value) {
        this.backendFault = value;
    }

}
