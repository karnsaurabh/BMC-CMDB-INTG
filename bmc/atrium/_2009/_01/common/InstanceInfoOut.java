
package com.bmc.atrium._2009._01.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InstanceInfoOut complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InstanceInfoOut">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="classNameId" type="{http://atrium.bmc.com/2009/01/common}ClassNameId"/>
 *         &lt;element name="instanceId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="instanceAttributes" type="{http://atrium.bmc.com/2009/01/common}AttributeValueList"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InstanceInfoOut", propOrder = {
    "classNameId",
    "instanceId",
    "instanceAttributes"
})
public class InstanceInfoOut {

    @XmlElement(required = true)
    protected ClassNameId classNameId;
    @XmlElement(required = true)
    protected String instanceId;
    @XmlElement(required = true)
    protected AttributeValueList instanceAttributes;

    /**
     * Gets the value of the classNameId property.
     * 
     * @return
     *     possible object is
     *     {@link ClassNameId }
     *     
     */
    public ClassNameId getClassNameId() {
        return classNameId;
    }

    /**
     * Sets the value of the classNameId property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClassNameId }
     *     
     */
    public void setClassNameId(ClassNameId value) {
        this.classNameId = value;
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

    /**
     * Gets the value of the instanceAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link AttributeValueList }
     *     
     */
    public AttributeValueList getInstanceAttributes() {
        return instanceAttributes;
    }

    /**
     * Sets the value of the instanceAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link AttributeValueList }
     *     
     */
    public void setInstanceAttributes(AttributeValueList value) {
        this.instanceAttributes = value;
    }

}
