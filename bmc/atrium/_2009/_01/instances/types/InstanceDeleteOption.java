
package com.bmc.atrium._2009._01.instances.types;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InstanceDeleteOption.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="InstanceDeleteOption">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DERIVED_INSTANCE_FOUND"/>
 *     &lt;enumeration value="UNCONDITIONALLY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "InstanceDeleteOption")
@XmlEnum
public enum InstanceDeleteOption {

    DERIVED_INSTANCE_FOUND,
    UNCONDITIONALLY;

    public String value() {
        return name();
    }

    public static InstanceDeleteOption fromValue(String v) {
        return valueOf(v);
    }

}
