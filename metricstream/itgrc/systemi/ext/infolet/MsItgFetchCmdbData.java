package com.metricstream.itgrc.systemi.ext.infolet;

import javax.inject.Inject;

import com.metricstream.itgrc.atr.constants.PluginInfo;
import com.metricstream.itgrc.atr.service.CmdbWSFetch;
import com.metricstream.itgrc.core.exceptions.AppException;
import com.metricstream.itgrc.core.service.IScheduledInfolet;
import com.metricstream.log.Logger;
import com.metricstream.systemi.ext.infolet.AbstractInfoletService;

public class MsItgFetchCmdbData extends AbstractInfoletService implements IScheduledInfolet {
    
    @Inject
    private CmdbWSFetch cmdbWSFetch;
    
    public MsItgFetchCmdbData() {
        super(MsItgFetchCmdbData.class.getName(), MsItgFetchCmdbData.class.getSimpleName(), PluginInfo.NAME);
    }

    public int process() throws AppException {
        autowireThis();
        Logger.error("MsItgFetchCmdbData", "inside process method[100]", null);
        
        Long startTime = Long.valueOf(System.currentTimeMillis());
        String methodName = java.lang.Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            Logger.error("MsItgFetchCmdbData", "inside process method try block[99]", null);
            this.cmdbWSFetch.fetchCmdbData();
        } catch (Exception e) {
            Logger.error(getClassId(), 4, new Object[]{"Exception Occured"}, e);
            return 1;
        } finally {
            Long endTime = Long.valueOf(System.currentTimeMillis());

            logServiceTime(startTime, endTime, methodName);
        }
        return 0;
    }
}
