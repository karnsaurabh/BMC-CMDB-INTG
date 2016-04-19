
package com.bmc.atrium._2009._01.common;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Keyword.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Keyword">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="APPLICATION"/>
 *     &lt;enumeration value="BROWSER"/>
 *     &lt;enumeration value="CLIENT_TYPE"/>
 *     &lt;enumeration value="CURRENT_WIN_ID"/>
 *     &lt;enumeration value="DATABASE"/>
 *     &lt;enumeration value="DATE_ONLY"/>
 *     &lt;enumeration value="DEFAULT"/>
 *     &lt;enumeration value="EVENT_SRC_WIN_ID"/>
 *     &lt;enumeration value="EVENT_TYPE"/>
 *     &lt;enumeration value="FIELD_HELP"/>
 *     &lt;enumeration value="GROUPS"/>
 *     &lt;enumeration value="GUIDE"/>
 *     &lt;enumeration value="GUIDE_TEXT"/>
 *     &lt;enumeration value="HARDWARE"/>
 *     &lt;enumeration value="HOME_URL"/>
 *     &lt;enumeration value="LAST_COUNT"/>
 *     &lt;enumeration value="LAST_ID"/>
 *     &lt;enumeration value="LAST_OPENED_WIN_ID"/>
 *     &lt;enumeration value="LOCALE"/>
 *     &lt;enumeration value="OPERATION"/>
 *     &lt;enumeration value="OS"/>
 *     &lt;enumeration value="ROLES"/>
 *     &lt;enumeration value="ROW_CHANGED"/>
 *     &lt;enumeration value="ROW_SELECTED"/>
 *     &lt;enumeration value="SCHEMA"/>
 *     &lt;enumeration value="SCHEMA_ALIAS"/>
 *     &lt;enumeration value="SERVER"/>
 *     &lt;enumeration value="TCP_PORT"/>
 *     &lt;enumeration value="TIME_ONLY"/>
 *     &lt;enumeration value="TIMESTAMP"/>
 *     &lt;enumeration value="USER"/>
 *     &lt;enumeration value="VERSION"/>
 *     &lt;enumeration value="VUI"/>
 *     &lt;enumeration value="VUI_TYPE"/>
 *     &lt;enumeration value="WEEKDAY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Keyword")
@XmlEnum
public enum Keyword {

    APPLICATION,
    BROWSER,
    CLIENT_TYPE,
    CURRENT_WIN_ID,
    DATABASE,
    DATE_ONLY,
    DEFAULT,
    EVENT_SRC_WIN_ID,
    EVENT_TYPE,
    FIELD_HELP,
    GROUPS,
    GUIDE,
    GUIDE_TEXT,
    HARDWARE,
    HOME_URL,
    LAST_COUNT,
    LAST_ID,
    LAST_OPENED_WIN_ID,
    LOCALE,
    OPERATION,
    OS,
    ROLES,
    ROW_CHANGED,
    ROW_SELECTED,
    SCHEMA,
    SCHEMA_ALIAS,
    SERVER,
    TCP_PORT,
    TIME_ONLY,
    TIMESTAMP,
    USER,
    VERSION,
    VUI,
    VUI_TYPE,
    WEEKDAY;

    public String value() {
        return name();
    }

    public static Keyword fromValue(String v) {
        return valueOf(v);
    }

}
