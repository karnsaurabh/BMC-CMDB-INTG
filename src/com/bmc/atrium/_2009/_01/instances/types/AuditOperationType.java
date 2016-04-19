
package com.bmc.atrium._2009._01.instances.types;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuditOperationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AuditOperationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NONE"/>
 *     &lt;enumeration value="SET"/>
 *     &lt;enumeration value="CREATE"/>
 *     &lt;enumeration value="DELETE"/>
 *     &lt;enumeration value="MERGE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AuditOperationType")
@XmlEnum
public enum AuditOperationType {

    NONE,
    SET,
    CREATE,
    DELETE,
    MERGE;

    public String value() {
        return name();
    }

    public static AuditOperationType fromValue(String v) {
        return valueOf(v);
    }

}
