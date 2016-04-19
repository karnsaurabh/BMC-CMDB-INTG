
package com.bmc.atrium._2009._01.instances.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.bmc.atrium._2009._01.common.Attachment;


/**
 * <p>Java class for UIComponentResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UIComponentResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="attachVal" type="{http://atrium.bmc.com/2009/01/common}Attachment"/>
 *         &lt;element name="componentInfo" type="{http://atrium.bmc.com/2009/01/instances/types}UIComponentInfo"/>
 *         &lt;element name="dataString" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="instanceId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UIComponentResult", propOrder = {
    "attachVal",
    "componentInfo",
    "dataString",
    "instanceId"
})
public class UIComponentResult {

    @XmlElement(required = true)
    protected Attachment attachVal;
    @XmlElement(required = true)
    protected UIComponentInfo componentInfo;
    @XmlElement(required = true)
    protected String dataString;
    @XmlElement(required = true)
    protected String instanceId;

    /**
     * Gets the value of the attachVal property.
     * 
     * @return
     *     possible object is
     *     {@link Attachment }
     *     
     */
    public Attachment getAttachVal() {
        return attachVal;
    }

    /**
     * Sets the value of the attachVal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Attachment }
     *     
     */
    public void setAttachVal(Attachment value) {
        this.attachVal = value;
    }

    /**
     * Gets the value of the componentInfo property.
     * 
     * @return
     *     possible object is
     *     {@link UIComponentInfo }
     *     
     */
    public UIComponentInfo getComponentInfo() {
        return componentInfo;
    }

    /**
     * Sets the value of the componentInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link UIComponentInfo }
     *     
     */
    public void setComponentInfo(UIComponentInfo value) {
        this.componentInfo = value;
    }

    /**
     * Gets the value of the dataString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataString() {
        return dataString;
    }

    /**
     * Sets the value of the dataString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataString(String value) {
        this.dataString = value;
    }

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
