
package com.bmc.atrium._2009._01.instances.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SetInstanceInfoIn complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SetInstanceInfoIn">
 *   &lt;complexContent>
 *     &lt;extension base="{http://atrium.bmc.com/2009/01/instances/types}CreateInstanceInfoIn">
 *       &lt;sequence>
 *         &lt;element name="instanceId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SetInstanceInfoIn", propOrder = {
    "instanceId"
})
public class SetInstanceInfoIn
    extends CreateInstanceInfoIn
{

    @XmlElement(required = true)
    protected String instanceId;

    /**
     * Gets the value of the instanceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstanceId() {
        return instanceId;
    }

    /**
     * Sets the value of the instanceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstanceId(String value) {
        this.instanceId = value;
    }

}
