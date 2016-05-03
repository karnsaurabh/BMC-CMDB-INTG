package com.metricstream.itgrc.systemi.ext.infolet;

import javax.inject.Inject;

import com.metricstream.itgrc.atr.constants.PluginInfo;
import com.metricstream.itgrc.atr.service.ConfigAtrDetailsPushInfoletImplN;
import com.metricstream.itgrc.core.exceptions.AppException;
import com.metricstream.log.Logger;
import com.metricstream.systemi.ext.infolet.AbstractInfoletService;

/**
 * Module: ITGRC <br>
 * 
 * This class MsItnConfigDetails is called by Infolet MS_ITN_NESSUS_CONFIG_DETAILS and it is a wrapper around
 * <code>ConfigDetailsPushformInfoletImplN</code> class.
 * 
 * @author paras.mathur
 */
public class MsItgAtrConfigDetails extends AbstractInfoletService {

    /**
     * Public constructor to initialize.
     */
    public MsItgAtrConfigDetails() {
        super(MsItgAtrConfigDetails.class.getName(), MsItgAtrConfigDetails.class.getSimpleName(), PluginInfo.NAME);
    }

    /** The config details pushform infolet impl n. */
    @Inject
    private ConfigAtrDetailsPushInfoletImplN configAtrDetailsPushformInfoletImplN;
    /**
     * gets the bean from WebApplicationContext and Calls the Infolet by fetchConfigurationInfo method.
     * 
     * @return String [][], return the configuration data
     * @throws AppException
     *             the application exception
     */
    public String[][] fetchAtrConfigurationInfo() throws AppException {
        autowireThis();
        final Long startTime = System.currentTimeMillis();
        final String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            return configAtrDetailsPushformInfoletImplN.fetchConfigurationInfo();
        } catch (Exception e) {
            Logger.error(getClassId(), Logger.CRITICAL, new Object[]{EXCEPTION_OCCURED}, e);
            return new String[0][0];
        } finally {
            final Long endTime = System.currentTimeMillis();

            logServiceTime(startTime, endTime, methodName);
        }
    }
}