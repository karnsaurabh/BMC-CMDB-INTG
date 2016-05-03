
package com.bmc.atrium._2009._01.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DiaryValue complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DiaryValue">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="diaryValueIn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="diaryValueOut" type="{http://atrium.bmc.com/2009/01/common}DiaryItemList"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DiaryValue", propOrder = {
    "diaryValueIn",
    "diaryValueOut"
})
public class DiaryValue {

    protected String diaryValueIn;
    protected DiaryItemList diaryValueOut;

    /**
     * Gets the value of the diaryValueIn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiaryValueIn() {
        return diaryValueIn;
    }

    /**
     * Sets the value of the diaryValueIn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiaryValueIn(String value) {
        this.diaryValueIn = value;
    }

    /**
     * Gets the value of the diaryValueOut property.
     * 
     * @return
     *     possible object is
     *     {@link DiaryItemList }
     *     
     */
    public DiaryItemList getDiaryValueOut() {
        return diaryValueOut;
    }

    /**
     * Sets the value of the diaryValueOut property.
     * 
     * @param value
     *     allowed object is
     *     {@link DiaryItemList }
     *     
     */
    public void setDiaryValueOut(DiaryItemList value) {
        this.diaryValueOut = value;
    }

}
