package com.metricstream.itgrc.atr.constants;

/**
 * Module: ITGRC <br>
 * 
 * The class ConfigKey contains Atrium related key values. Atrium configuration data can be fetched based on these key
 * values.
 * 
 * @author arjun.tomer
 * 
 */
public class ConfigKey {

    /**
     * Instantiates a new config key.
     */
    private ConfigKey() {
        super();
    }

    /** The base api ATRIUM_SERVER_URL. */
    public static final String ATRIUM_SERVER_URL = "atr.server.url";

    /** The rest api user ATRIUM_USER_NAME. */
    public static final String ATRIUM_USER_NAME = "atr.server.user.name";

    /** The rest api ATRIUM_PASSWORD. */
    public static final String ATRIUM_PASSWORD = "atr.server.user.password";
}
