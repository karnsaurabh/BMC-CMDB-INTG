
package com.bmc.atrium._2009._01.instances.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.bmc.atrium._2009._01.common.ClassNameId;
import com.bmc.atrium._2009._01.common.ExtensionList;
import com.bmc.atrium._2009._01.common.GetMask;
import com.bmc.atrium._2009._01.common.LoginInfo;
import com.bmc.atrium._2009._01.common.StringArray;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="loginInfo" type="{http://atrium.bmc.com/2009/01/common}LoginInfo"/>
 *         &lt;element name="classNameId" type="{http://atrium.bmc.com/2009/01/common}ClassNameId"/>
 *         &lt;element name="query" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="attributes" type="{http://atrium.bmc.com/2009/01/common}StringArray"/>
 *         &lt;element name="firstRetrieve" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="maxRetrieve" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sortOrder" type="{http://atrium.bmc.com/2009/01/instances/types}SortOrderList"/>
 *         &lt;element name="datasetId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="getMask" type="{http://atrium.bmc.com/2009/01/common}GetMask"/>
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
@XmlType(name = "", propOrder = {
    "loginInfo",
    "classNameId",
    "query",
    "attributes",
    "firstRetrieve",
    "maxRetrieve",
    "sortOrder",
    "datasetId",
    "getMask",
    "extensions"
})
@XmlRootElement(name = "GetInstances")
public class GetInstances {

    @XmlElement(required = true, nillable = true)
    protected LoginInfo loginInfo;
    @XmlElement(required = true)
    protected ClassNameId classNameId;
    @XmlElement(required = true)
    protected String query;
    @XmlElement(required = true)
    protected StringArray attributes;
    protected int firstRetrieve;
    protected int maxRetrieve;
    @XmlElement(required = true)
    protected SortOrderList sortOrder;
    @XmlElement(required = true)
    protected String datasetId;
    @XmlElement(required = true)
    protected GetMask getMask;
    @XmlElement(required = true, nillable = true)
    protected ExtensionList extensions;

    /**
     * Gets the value of the loginInfo property.
     * 
     * @return
     *     possible object is
     *     {@link LoginInfo }
     *     
     */
    public LoginInfo getLoginInfo() {
        return loginInfo;
    }

    /**
     * Sets the value of the loginInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoginInfo }
     *     
     */
    public void setLoginInfo(LoginInfo value) {
        this.loginInfo = value;
    }

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
     * Gets the value of the query property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuery() {
        return query;
    }

    /**
     * Sets the value of the query property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuery(String value) {
        this.query = value;
    }

    /**
     * Gets the value of the attributes property.
     * 
     * @return
     *     possible object is
     *     {@link StringArray }
     *     
     */
    public StringArray getAttributes() {
        return attributes;
    }

    /**
     * Sets the value of the attributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link StringArray }
     *     
     */
    public void setAttributes(StringArray value) {
        this.attributes = value;
    }

    /**
     * Gets the value of the firstRetrieve property.
     * 
     */
    public int getFirstRetrieve() {
        return firstRetrieve;
    }

    /**
     * Sets the value of the firstRetrieve property.
     * 
     */
    public void setFirstRetrieve(int value) {
        this.firstRetrieve = value;
    }

    /**
     * Gets the value of the maxRetrieve property.
     * 
     */
    public int getMaxRetrieve() {
        return maxRetrieve;
    }

    /**
     * Sets the value of the maxRetrieve property.
     * 
     */
    public void setMaxRetrieve(int value) {
        this.maxRetrieve = value;
    }

    /**
     * Gets the value of the sortOrder property.
     * 
     * @return
     *     possible object is
     *     {@link SortOrderList }
     *     
     */
    public SortOrderList getSortOrder() {
        return sortOrder;
    }

    /**
     * Sets the value of the sortOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link SortOrderList }
     *     
     */
    public void setSortOrder(SortOrderList value) {
        this.sortOrder = value;
    }

    /**
     * Gets the value of the datasetId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatasetId() {
        return datasetId;
    }

    /**
     * Sets the value of the datasetId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatasetId(String value) {
        this.datasetId = value;
    }

    /**
     * Gets the value of the getMask property.
     * 
     * @return
     *     possible object is
     *     {@link GetMask }
     *     
     */
    public GetMask getGetMask() {
        return getMask;
    }

    /**
     * Sets the value of the getMask property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetMask }
     *     
     */
    public void setGetMask(GetMask value) {
        this.getMask = value;
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
