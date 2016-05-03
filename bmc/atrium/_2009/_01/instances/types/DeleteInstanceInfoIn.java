
package com.bmc.atrium._2009._01.instances.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.bmc.atrium._2009._01.common.ClassNameId;


/**
 * <p>Java class for DeleteInstanceInfoIn complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeleteInstanceInfoIn">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="classNameId" type="{http://atrium.bmc.com/2009/01/common}ClassNameId"/>
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
@XmlType(name = "DeleteInstanceInfoIn", propOrder = {
    "classNameId",
    "instanceId"
})
public class DeleteInstanceInfoIn {

    @XmlElement(required = true)
    protected ClassNameId classNameId;
    @XmlElement(required = true)
    protected String instanceId;

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

}
