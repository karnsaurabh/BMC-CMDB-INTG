
package com.bmc.atrium._2009._01.instances.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import com.bmc.atrium._2009._01.common.AttributeValueList;
import com.bmc.atrium._2009._01.common.ClassNameId;


/**
 * <p>Java class for CreateInstanceInfoIn complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateInstanceInfoIn">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="classNameId" type="{http://atrium.bmc.com/2009/01/common}ClassNameId"/>
 *         &lt;element name="attributes" type="{http://atrium.bmc.com/2009/01/common}AttributeValueList"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateInstanceInfoIn", propOrder = {
    "classNameId",
    "attributes"
})
@XmlSeeAlso({
    SetInstanceInfoIn.class
})
public class CreateInstanceInfoIn {

    @XmlElement(required = true)
    protected ClassNameId classNameId;
    @XmlElement(required = true)
    protected AttributeValueList attributes;

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
     * Gets the value of the attributes property.
     * 
     * @return
     *     possible object is
     *     {@link AttributeValueList }
     *     
     */
    public AttributeValueList getAttributes() {
        return attributes;
    }

    /**
     * Sets the value of the attributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link AttributeValueList }
     *     
     */
    public void setAttributes(AttributeValueList value) {
        this.attributes = value;
    }

}
