
package com.bmc.atrium._2009._01.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Attachment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Attachment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="location" type="{http://atrium.bmc.com/2009/01/common}Location"/>
 *         &lt;element name="originalSize" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="compressedSize" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Attachment", propOrder = {
    "name",
    "location",
    "originalSize",
    "compressedSize"
})
public class Attachment {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected Location location;
    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long originalSize;
    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long compressedSize;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link Location }
     *     
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link Location }
     *     
     */
    public void setLocation(Location value) {
        this.location = value;
    }

    /**
     * Gets the value of the originalSize property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOriginalSize() {
        return originalSize;
    }

    /**
     * Sets the value of the originalSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOriginalSize(Long value) {
        this.originalSize = value;
    }

    /**
     * Gets the value of the compressedSize property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCompressedSize() {
        return compressedSize;
    }

    /**
     * Sets the value of the compressedSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCompressedSize(Long value) {
        this.compressedSize = value;
    }

}
