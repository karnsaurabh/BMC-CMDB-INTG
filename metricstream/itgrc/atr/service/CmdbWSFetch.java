package com.metricstream.itgrc.atr.service;

import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.ws.Holder;

import com.bmc.atrium._2009._01.common.AttributeValue;
import com.bmc.atrium._2009._01.common.AttributeValueList;
import com.bmc.atrium._2009._01.common.ExtensionList;
import com.bmc.atrium._2009._01.common.InstanceInfoOut;
import com.bmc.atrium._2009._01.common.InstanceInfoOutList;
import com.bmc.atrium._2009._01.common.StatusList;
import com.bmc.atrium._2009._01.common.Value;
import com.column.model.CMDB;
import com.metricstream.appstudio.cif.exceptions.CifException;
import com.metricstream.itgrc.bmc.utils.DateUtility;
import com.metricstream.itgrc.core.exceptions.AppException;
import com.metricstream.itgrc.core.service.ConfigRepository;
import com.metricstream.log.Logger;

@Named
public class CmdbWSFetch {
    //private static Logger logger = Logger.getLogger(CmdbWSFetch.class);

    //private static final String XMLFILEPATH_INPUT="xml_resources\\input.xml";
    //private static final String XMLFILEPATH_OUTPUT="xml_resources\\outputfiles\\";

    @Inject
    private WebServiceData webServiceData;

    @Inject
    private PersistWebServiceClasses persistWebServiceClasses;

    @Inject
    private FetchAtriumClassesWebService fetchAtriumClassesWebService;

    @Inject
    private BMCCreateAssetConsumer bmcreateAssetConsumer;

    @Inject
    private ConfigRepository configRepository;

    public void fetchCmdbData() throws AppException, CifException, UnknownHostException {

        String pattern = "MM/dd/yyyy HH:mm:ss";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        String curDate = format.format(new Date());
        String lastRun = configRepository.getConfigValue("ms.atr.last.run");
        Logger.error("FetchAtriumClassesWebService", "inside fetchCmdbWSData method before webservice call[91]" + lastRun, null);
        long curTime = DateUtility.getCurrentTimeLong(curDate);
        long lastRunTime = 0l;

        if (lastRun != null && lastRun.length() > 0) {
            Logger.error("FetchAtriumClassesWebService", "inside fetchCmdbWSData method before webservice call[90]" + lastRun, null);
            lastRunTime = DateUtility.getCurrentTimeLong(lastRun);
            Logger.error("FetchAtriumClassesWebService", "inside fetchCmdbWSData method before webservice call[89]" + lastRunTime, null);
        }
        Logger.error("CmdbWSFetch", "inside fetchCmdbData method starting[98]", null);
        computerSystemWSCall(curTime, lastRunTime);
        ipEndPointSubnetWSCall(curTime, lastRunTime);
        lanEndpointWSCall(curTime, lastRunTime);
        hostedAccessPointWSCall(curTime, lastRunTime);
        configRepository.setConfig("ms.atr.last.run", curDate);
        bmcreateAssetConsumer.call();
    }

    public void computerSystemWSCall(long curTime, long lastRunTime) throws AppException, CifException {
        Logger.error("CmdbWSFetch", "inside computerSystemWSCall method[97]", null);
        final Holder<ExtensionList> extensions = new Holder<ExtensionList>();
        final Holder<InstanceInfoOutList> instanceInfo = new Holder<InstanceInfoOutList>();
        final Holder<StatusList> status = new Holder<StatusList>();
        CMDB cmdb = webServiceData.getBMCComputerSystemAttribues();
        Logger.error("CmdbWSFetch", "inside computerSystemWSCall method before webservice call[94]", null);
        fetchAtriumClassesWebService.fetchCmdbWSData(cmdb, extensions, instanceInfo, status, curTime, lastRunTime);
        Logger.error("CmdbWSFetch", "inside computerSystemWSCall method after webservice call[74]", null);
        Map<String, Value> attributeMap = new HashMap<String, Value>();
        InstanceInfoOutList instanceInfoOutList = instanceInfo.value;
        List<InstanceInfoOut> instanceInfoOuts = instanceInfoOutList.getList();
        for (InstanceInfoOut instanceInfoOut : instanceInfoOuts) {
            Logger.error("CmdbWSFetch", "inside computerSystemWSCall method[73]" + instanceInfoOut.getInstanceId(), null);
            AttributeValueList attributeValueList = instanceInfoOut.getInstanceAttributes();
            List<AttributeValue> attributeValues = attributeValueList.getList();
            for (AttributeValue attributeValue : attributeValues) {
                Logger.error("CmdbWSFetch", "inside computerSystemWSCall method[72]" +"Key" + attributeValue.getName()+ "Value" +attributeValue.getValue().getStringValue(), null);
                attributeMap.put(attributeValue.getName(), attributeValue.getValue());
            }

            persistWebServiceClasses.persistComputerSystemClass(instanceInfoOut, attributeMap);
        }

    }

    public void ipEndPointSubnetWSCall(long curTime, long lastRunTime) throws AppException, CifException {

        final Holder<ExtensionList> extensions = new Holder<ExtensionList>();
        final Holder<InstanceInfoOutList> instanceInfo = new Holder<InstanceInfoOutList>();
        final Holder<StatusList> status = new Holder<StatusList>();
        CMDB cmdb = webServiceData.getBMCIPEndpointAttribues();
        Logger.error("CmdbWSFetch", "inside ipEndPointSubnetWSCall method[56]" + cmdb.getConstantData().getCustFirstRetrieve(), null);
        fetchAtriumClassesWebService.fetchCmdbWSData(cmdb, extensions, instanceInfo, status, curTime, lastRunTime);
        Map<String, String> attributeMap = new HashMap<String, String>();
        InstanceInfoOutList instanceInfoOutList = instanceInfo.value;
        List<InstanceInfoOut> instanceInfoOuts = instanceInfoOutList.getList();
        for (InstanceInfoOut instanceInfoOut : instanceInfoOuts) {
            Logger.error("CmdbWSFetch", "inside ipEndPointSubnetWSCall method[55]" + instanceInfoOut.getInstanceId(), null);
            AttributeValueList attributeValueList = instanceInfoOut.getInstanceAttributes();
            List<AttributeValue> attributeValues = attributeValueList.getList();
            for (AttributeValue attributeValue : attributeValues) {
                Logger.error("CmdbWSFetch", "inside ipEndPointSubnetWSCall method[54]" + attributeValue.getValue().getStringValue(), null);
                attributeMap.put(attributeValue.getName(), attributeValue.getValue().getStringValue());

            }
            persistWebServiceClasses.persistIPEndpointClass(instanceInfoOut, attributeMap);

        }

    }

    private void hostedAccessPointWSCall(long curTime, long lastRunTime) throws AppException {

        final Holder<ExtensionList> extensions = new Holder<ExtensionList>();
        final Holder<InstanceInfoOutList> instanceInfo = new Holder<InstanceInfoOutList>();
        final Holder<StatusList> status = new Holder<StatusList>();
        CMDB cmdb = webServiceData.getBMCHostedAccessAttribues();
        Logger.error("CmdbWSFetch", "inside hostedAccessPointWSCall method[56]" + cmdb.getConstantData().getCustFirstRetrieve(), null);
        fetchAtriumClassesWebService.fetchCmdbWSData(cmdb, extensions, instanceInfo, status, curTime, lastRunTime);
        Logger.error("CmdbWSFetch", "inside hostedAccessPointWSCall method[56]" + cmdb.getConstantData().getCustFirstRetrieve(), null);
        Map<String, String> attributeMap = new HashMap<String, String>();
        InstanceInfoOutList instanceInfoOutList = instanceInfo.value;
        Logger.error("CmdbWSFetch", "inside hostedAccessPointWSCall method[56]" + cmdb.getConstantData().getCustFirstRetrieve(), null);
        List<InstanceInfoOut> instanceInfoOuts = instanceInfoOutList.getList();
        Logger.error("CmdbWSFetch", "inside hostedAccessPointWSCall method[56]Size:" + instanceInfoOuts.size(), null);
        for (InstanceInfoOut instanceInfoOut : instanceInfoOuts) {
            Logger.error("CmdbWSFetch", "inside hostedAccessPointWSCall method[55]" + instanceInfoOut.getInstanceId(), null);
            AttributeValueList attributeValueList = instanceInfoOut.getInstanceAttributes();
            List<AttributeValue> attributeValues = attributeValueList.getList();
            for (AttributeValue attributeValue : attributeValues) {
                Logger.error("CmdbWSFetch", "inside hostedAccessPointWSCall method[54]" + attributeValue.getValue().getStringValue(), null);
                attributeMap.put(attributeValue.getName(), attributeValue.getValue().getStringValue());

            }

            persistWebServiceClasses.persistHostedAccessPointClass(instanceInfoOut, attributeMap);
        }

    }

    public void lanEndpointWSCall(long curTime, long lastRunTime) throws AppException, CifException {

        final Holder<ExtensionList> extensions = new Holder<ExtensionList>();
        final Holder<InstanceInfoOutList> instanceInfo = new Holder<InstanceInfoOutList>();
        final Holder<StatusList> status = new Holder<StatusList>();
        CMDB cmdb = webServiceData.getBMCLANEndpointAttribues();
        Logger.error("CmdbWSFetch", "inside lanEndpointWSCall method[47]" + cmdb.getConstantData().getCustFirstRetrieve(), null);
        fetchAtriumClassesWebService.fetchCmdbWSData(cmdb, extensions, instanceInfo, status, curTime, lastRunTime);
        Map<String, String> attributeMap = new HashMap<String, String>();
        InstanceInfoOutList instanceInfoOutList = instanceInfo.value;
        List<InstanceInfoOut> instanceInfoOuts = instanceInfoOutList.getList();
        for (InstanceInfoOut instanceInfoOut : instanceInfoOuts) {
            Logger.error("CmdbWSFetch", "inside lanEndpointWSCall method[46]" + instanceInfoOut.getInstanceId(), null);
            AttributeValueList attributeValueList = instanceInfoOut.getInstanceAttributes();
            List<AttributeValue> attributeValues = attributeValueList.getList();
            for (AttributeValue attributeValue : attributeValues) {
                Logger.error("CmdbWSFetch", "inside lanEndpointWSCall method[45]" + attributeValue.getValue().getStringValue(), null);
                attributeMap.put(attributeValue.getName(), attributeValue.getValue().getStringValue());
            }

            persistWebServiceClasses.persistLanEndPointClass(instanceInfoOut, attributeMap);
        }

    }

}
