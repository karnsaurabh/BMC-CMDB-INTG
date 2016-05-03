
package com.bmc.atrium._2009._01.instances.types;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SortOrderType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SortOrderType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ASCENDING"/>
 *     &lt;enumeration value="DESCENDING"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SortOrderType")
@XmlEnum
public enum SortOrderType {

    ASCENDING,
    DESCENDING;

    public String value() {
        return name();
    }

    public static SortOrderType fromValue(String v) {
        return valueOf(v);
    }

}
