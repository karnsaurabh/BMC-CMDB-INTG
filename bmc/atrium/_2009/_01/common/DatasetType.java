
package com.bmc.atrium._2009._01.common;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DatasetType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DatasetType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="REGULAR"/>
 *     &lt;enumeration value="OVERLAY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DatasetType")
@XmlEnum
public enum DatasetType {

    REGULAR,
    OVERLAY;

    public String value() {
        return name();
    }

    public static DatasetType fromValue(String v) {
        return valueOf(v);
    }

}
