
package com.bmc.atrium._2009._01.instances.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UIComponentInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UIComponentInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="classId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="componentType" type="{http://atrium.bmc.com/2009/01/instances/types}ComponentType"/>
 *         &lt;element name="encodedQual" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="locale" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tag1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tag2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tag3" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tag4" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tag5" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UIComponentInfo", propOrder = {
    "classId",
    "componentType",
    "encodedQual",
    "locale",
    "tag1",
    "tag2",
    "tag3",
    "tag4",
    "tag5"
})
public class UIComponentInfo {

    @XmlElement(required = true)
    protected String classId;
    @XmlElement(required = true)
    protected ComponentType componentType;
    @XmlElement(required = true)
    protected String encodedQual;
    @XmlElement(required = true)
    protected String locale;
    @XmlElement(required = true)
    protected String tag1;
    @XmlElement(required = true)
    protected String tag2;
    @XmlElement(required = true)
    protected String tag3;
    @XmlElement(required = true)
    protected String tag4;
    @XmlElement(required = true)
    protected String tag5;

    /**
     * Gets the value of the classId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassId() {
        return classId;
    }

    /**
     * Sets the value of the classId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassId(String value) {
        this.classId = value;
    }

    /**
     * Gets the value of the componentType property.
     * 
     * @return
     *     possible object is
     *     {@link ComponentType }
     *     
     */
    public ComponentType getComponentType() {
        return componentType;
    }

    /**
     * Sets the value of the componentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ComponentType }
     *     
     */
    public void setComponentType(ComponentType value) {
        this.componentType = value;
    }

    /**
     * Gets the value of the encodedQual property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEncodedQual() {
        return encodedQual;
    }

    /**
     * Sets the value of the encodedQual property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEncodedQual(String value) {
        this.encodedQual = value;
    }

    /**
     * Gets the value of the locale property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocale() {
        return locale;
    }

    /**
     * Sets the value of the locale property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocale(String value) {
        this.locale = value;
    }

    /**
     * Gets the value of the tag1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTag1() {
        return tag1;
    }

    /**
     * Sets the value of the tag1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTag1(String value) {
        this.tag1 = value;
    }

    /**
     * Gets the value of the tag2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTag2() {
        return tag2;
    }

    /**
     * Sets the value of the tag2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTag2(String value) {
        this.tag2 = value;
    }

    /**
     * Gets the value of the tag3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTag3() {
        return tag3;
    }

    /**
     * Sets the value of the tag3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTag3(String value) {
        this.tag3 = value;
    }

    /**
     * Gets the value of the tag4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTag4() {
        return tag4;
    }

    /**
     * Sets the value of the tag4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTag4(String value) {
        this.tag4 = value;
    }

    /**
     * Gets the value of the tag5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTag5() {
        return tag5;
    }

    /**
     * Sets the value of the tag5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTag5(String value) {
        this.tag5 = value;
    }

}
