
package com.bmc.atrium._2009._01.common;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AtriumServiceFaultType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AtriumServiceFaultType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="INVALID_ARGUMENT"/>
 *     &lt;enumeration value="UNSUPPORTED_OPERATION"/>
 *     &lt;enumeration value="UNEXPECTED_FAILURE"/>
 *     &lt;enumeration value="SECURITY_FAILURE"/>
 *     &lt;enumeration value="OTHER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AtriumServiceFaultType")
@XmlEnum
public enum AtriumServiceFaultType {

    INVALID_ARGUMENT,
    UNSUPPORTED_OPERATION,
    UNEXPECTED_FAILURE,
    SECURITY_FAILURE,
    OTHER;

    public String value() {
        return name();
    }

    public static AtriumServiceFaultType fromValue(String v) {
        return valueOf(v);
    }

}
