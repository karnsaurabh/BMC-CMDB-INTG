
package com.bmc.atrium._2009._01.instances.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SortOrder complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SortOrder">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="attributeName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sortOrder" type="{http://atrium.bmc.com/2009/01/instances/types}SortOrderType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SortOrder", propOrder = {
    "attributeName",
    "sortOrder"
})
public class SortOrder {

    @XmlElement(required = true)
    protected String attributeName;
    @XmlElement(required = true)
    protected SortOrderType sortOrder;

    /**
     * Gets the value of the attributeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttributeName() {
        return attributeName;
    }

    /**
     * Sets the value of the attributeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttributeName(String value) {
        this.attributeName = value;
    }

    /**
     * Gets the value of the sortOrder property.
     * 
     * @return
     *     possible object is
     *     {@link SortOrderType }
     *     
     */
    public SortOrderType getSortOrder() {
        return sortOrder;
    }

    /**
     * Sets the value of the sortOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link SortOrderType }
     *     
     */
    public void setSortOrder(SortOrderType value) {
        this.sortOrder = value;
    }

}
