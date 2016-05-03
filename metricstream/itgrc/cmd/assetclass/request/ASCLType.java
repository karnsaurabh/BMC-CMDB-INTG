//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.20 at 02:46:29 PM IST 
//


package com.metricstream.itgrc.cmd.assetclass.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ASCLType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ASCLType">
 *   &lt;complexContent>
 *     &lt;extension base="{}CommonFieldsType">
 *       &lt;sequence>
 *         &lt;element name="object_level" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="asset_class_type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cpe_equivalent_definition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ASCLType", propOrder = {
    "objectLevel",
    "parent",
    "assetClassType",
    "cpeEquivalentDefinition"
})
public class ASCLType
    extends CommonFieldsType
{

    @XmlElement(name = "object_level")
    protected String objectLevel;
    protected String parent;
    @XmlElement(name = "asset_class_type")
    protected String assetClassType;
    @XmlElement(name = "cpe_equivalent_definition")
    protected String cpeEquivalentDefinition;

    /**
     * Gets the value of the objectLevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjectLevel() {
        return objectLevel;
    }

    /**
     * Sets the value of the objectLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjectLevel(String value) {
        this.objectLevel = value;
    }

    /**
     * Gets the value of the parent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParent() {
        return parent;
    }

    /**
     * Sets the value of the parent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParent(String value) {
        this.parent = value;
    }

    /**
     * Gets the value of the assetClassType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssetClassType() {
        return assetClassType;
    }

    /**
     * Sets the value of the assetClassType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssetClassType(String value) {
        this.assetClassType = value;
    }

    /**
     * Gets the value of the cpeEquivalentDefinition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCpeEquivalentDefinition() {
        return cpeEquivalentDefinition;
    }

    /**
     * Sets the value of the cpeEquivalentDefinition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCpeEquivalentDefinition(String value) {
        this.cpeEquivalentDefinition = value;
    }

}
