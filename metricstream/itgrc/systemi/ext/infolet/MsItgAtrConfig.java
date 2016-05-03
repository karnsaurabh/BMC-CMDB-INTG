package com.metricstream.itgrc.systemi.ext.infolet;

import javax.inject.Inject;

import com.metricstream.itgrc.atr.constants.PluginInfo;
import com.metricstream.itgrc.atr.service.ConfigAtrPushInfoletImplN;
import com.metricstream.itgrc.core.constants.ServiceTimeLoggerProperty;
import com.metricstream.itgrc.core.exceptions.AppException;
import com.metricstream.itgrc.core.service.IPushform;
import com.metricstream.log.Logger;
import com.metricstream.systemi.ext.infolet.AbstractInfoletService;

/**
 * Module: ITGRC <br>
 * 
 * The class MsItnConfig updates the ITG CONFIG table with the nessus configuration parameters This class process method
 * will be triggered by the nessus config infolet.
 * 
 * @author arjun.tomer
 */
public class MsItgAtrConfig extends AbstractInfoletService implements IPushform {

    /**
     * Public constructor to initialize.
     */
    public MsItgAtrConfig() {
        super(MsItgAtrConfig.class.getName(), MsItgAtrConfig.class.getSimpleName(), PluginInfo.NAME);
    }

    /** The config pushform infolet impl n. */
    @Inject
    private ConfigAtrPushInfoletImplN configAtrPushformInfoletImplN;

    /**
     * gets the bean from application context and Calls the Infolet class.
     * 
     * @param processInstanceId
     *            processInstanceId which holds unique value
     * @return Integer, return the integer value
     * @throws AppException
     *             the application exception {@link ConfigAtrPushInfoletImplN ConfigPushformInfoletImplN} run method
     */
    @Override
    public int process(double processInstanceId) throws AppException {
        autowireThis();
        final Long startTime = System.currentTimeMillis();
        final String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            configAtrPushformInfoletImplN.run(processInstanceId);
        } catch (Exception e) {
            Logger.error(getClassId(), Logger.CRITICAL, new Object[]{EXCEPTION_OCCURED}, e);
            return 1;
        } finally {
            final Long endTime = System.currentTimeMillis();
            setServiceTimeLoggerProperty(ServiceTimeLoggerProperty.PROCESS_INSTANCE_ID, String.valueOf(processInstanceId));
            logServiceTime(startTime, endTime, methodName);
        }

        return 0;
    }
}
