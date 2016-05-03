
package com.bmc.atrium._2009._01.instances.types;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ComponentType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ComponentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NONE"/>
 *     &lt;enumeration value="ICON"/>
 *     &lt;enumeration value="LINE"/>
 *     &lt;enumeration value="TOOLTIP"/>
 *     &lt;enumeration value="LOCALIZED_LABEL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ComponentType")
@XmlEnum
public enum ComponentType {

    NONE,
    ICON,
    LINE,
    TOOLTIP,
    LOCALIZED_LABEL;

    public String value() {
        return name();
    }

    public static ComponentType fromValue(String v) {
        return valueOf(v);
    }

}
