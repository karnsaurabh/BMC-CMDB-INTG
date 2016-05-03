
package com.bmc.atrium._2009._01.common;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetMask.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GetMask">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DATASET_MODE_CURRENT"/>
 *     &lt;enumeration value="GET_MASK_NONE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "GetMask")
@XmlEnum
public enum GetMask {

    DATASET_MODE_CURRENT,
    GET_MASK_NONE;

    public String value() {
        return name();
    }

    public static GetMask fromValue(String v) {
        return valueOf(v);
    }

}
