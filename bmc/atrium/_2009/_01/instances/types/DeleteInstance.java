
package com.bmc.atrium._2009._01.instances.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.bmc.atrium._2009._01.common.ExtensionList;
import com.bmc.atrium._2009._01.common.LoginInfo;


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
 *         &lt;element name="datasetId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="instanceInfo" type="{http://atrium.bmc.com/2009/01/instances/types}DeleteInstanceInfoIn"/>
 *         &lt;element name="deleteOption" type="{http://atrium.bmc.com/2009/01/instances/types}InstanceDeleteOption"/>
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
    "datasetId",
    "instanceInfo",
    "deleteOption",
    "extensions"
})
@XmlRootElement(name = "DeleteInstance")
public class DeleteInstance {

    @XmlElement(required = true, nillable = true)
    protected LoginInfo loginInfo;
    @XmlElement(required = true)
    protected String datasetId;
    @XmlElement(required = true)
    protected DeleteInstanceInfoIn instanceInfo;
    @XmlElement(required = true)
    protected InstanceDeleteOption deleteOption;
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
     * Gets the value of the instanceInfo property.
     * 
     * @return
     *     possible object is
     *     {@link DeleteInstanceInfoIn }
     *     
     */
    public DeleteInstanceInfoIn getInstanceInfo() {
        return instanceInfo;
    }

    /**
     * Sets the value of the instanceInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeleteInstanceInfoIn }
     *     
     */
    public void setInstanceInfo(DeleteInstanceInfoIn value) {
        this.instanceInfo = value;
    }

    /**
     * Gets the value of the deleteOption property.
     * 
     * @return
     *     possible object is
     *     {@link InstanceDeleteOption }
     *     
     */
    public InstanceDeleteOption getDeleteOption() {
        return deleteOption;
    }

    /**
     * Sets the value of the deleteOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link InstanceDeleteOption }
     *     
     */
    public void setDeleteOption(InstanceDeleteOption value) {
        this.deleteOption = value;
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