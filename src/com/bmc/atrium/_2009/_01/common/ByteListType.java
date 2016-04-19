
package com.bmc.atrium._2009._01.common;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ByteListType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ByteListType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="USER_DEFINED"/>
 *     &lt;enumeration value="WIN_BMP"/>
 *     &lt;enumeration value="JPEG"/>
 *     &lt;enumeration value="TIFF"/>
 *     &lt;enumeration value="TARGA"/>
 *     &lt;enumeration value="PCX"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ByteListType")
@XmlEnum
public enum ByteListType {

    USER_DEFINED,
    WIN_BMP,
    JPEG,
    TIFF,
    TARGA,
    PCX;

    public String value() {
        return name();
    }

    public static ByteListType fromValue(String v) {
        return valueOf(v);
    }

}
