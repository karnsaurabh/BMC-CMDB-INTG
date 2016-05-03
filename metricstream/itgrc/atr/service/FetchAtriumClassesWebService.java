package com.metricstream.itgrc.atr.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;

import com.bmc.atrium._2009._01.common.ClassNameId;
import com.bmc.atrium._2009._01.common.ExtensionList;
import com.bmc.atrium._2009._01.common.GetMask;
import com.bmc.atrium._2009._01.common.InstanceInfoOutList;
import com.bmc.atrium._2009._01.common.StatusList;
import com.bmc.atrium._2009._01.common.StringArray;
import com.bmc.atrium._2009._01.instances.AtriumFault;
import com.bmc.atrium._2009._01.instances.AtriumInstances;
import com.bmc.atrium._2009._01.instances.AtriumInstancesPortType;
import com.bmc.atrium._2009._01.instances.types.SortOrder;
import com.bmc.atrium._2009._01.instances.types.SortOrderList;
import com.bmc.atrium._2009._01.instances.types.SortOrderType;
import com.column.handler.HeaderHandlerResolver;
import com.column.model.CMDB;
import com.column.model.CustAttributes;
import com.column.model.CustClassNameId;
import com.column.model.CustSortOrder;
import com.column.model.CustSortOrderAttributes;
import com.metricstream.itgrc.atr.constants.ConfigKey;
import com.metricstream.itgrc.bmc.utils.DynamicQueryString;
import com.metricstream.itgrc.core.service.ConfigRepository;
import com.metricstream.log.Logger;

@Named
public class FetchAtriumClassesWebService {

   /* @Inject
    private BmcCredentials bmcCredentials;*/

    @Inject
    private ConfigRepository configRepository;

    public void fetchCmdbWSData(CMDB cmdb, Holder<ExtensionList> extensions, Holder<InstanceInfoOutList> instanceInfo, Holder<StatusList> status, long curTime, long lastRunTime) {
        try {
            Logger.error("FetchAtriumClassesWebService", "inside fetchCmdbWSData method before webservice call[93]", null);

            AtriumInstances ai = new AtriumInstances();

            HeaderHandlerResolver hhr = new HeaderHandlerResolver();
            
            ai.setHandlerResolver(hhr);
            AtriumInstancesPortType aipt = ai.getAtriumInstancesWebService();
            BindingProvider bp = (BindingProvider) aipt;
            Logger.error("FetchAtriumClassesWebService", "inside fetchCmdbWSData method[88]", null);

            String endPointURL = configRepository.getConfigValue(ConfigKey.ATRIUM_SERVER_URL);
            Logger.error("FetchAtriumClassesWebService", "inside fetchCmdbWSData method[87]" + endPointURL, null);
            bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endPointURL);
            GetMask gm = GetMask.DATASET_MODE_CURRENT;
            int firstRetrieve = cmdb.getConstantData().getCustFirstRetrieve();

            int maxRetrieve = cmdb.getConstantData().getCustMaxRetrieve();

            Logger.error("FetchAtriumClassesWebService", "inside fetchCmdbWSData method[86]" + maxRetrieve, null);
            CustClassNameId ccd = cmdb.getClassDataList().get(0).getCustClassNameId();
            ClassNameId id = new ClassNameId();
            id.setClassName(ccd.getCustClassName());
            id.setNamespaceName(ccd.getCustNamespaceName());
            Logger.error("FetchAtriumClassesWebService", "inside fetchCmdbWSData method[85]" + ccd.getCustClassName(), null);
            Logger.error("FetchAtriumClassesWebService", "inside fetchCmdbWSData method[84]" + ccd.getCustNamespaceName(), null);

            String query = cmdb.getClassDataList().get(0).getCustQuery();

            String finalQuery = DynamicQueryString.getQueryString(query, lastRunTime, curTime);
            CustAttributes atb = cmdb.getClassDataList().get(0).getCustAttributes();
            List<String> atbList = atb.getCustList();
            StringArray sa = new StringArray();
            List<String> list1 = sa.getList();
            for (int l1 = 0; l1 < atbList.size(); l1++) {
                Logger.error("FetchAtriumClassesWebService", "inside fetchCmdbWSData method[83]" + atbList.get(l1), null);
                list1.add(atbList.get(l1));
            }

            SortOrderList soList = new SortOrderList();
            Logger.error("FetchAtriumClassesWebService", "inside fetchCmdbWSData method[82]", null);
            List<SortOrder> soL = soList.getList();
            Logger.error("FetchAtriumClassesWebService", "inside fetchCmdbWSData method[81]", null);
            CustSortOrder cso = cmdb.getClassDataList().get(0).getCustSortOrder();
            Logger.error("FetchAtriumClassesWebService", "inside fetchCmdbWSData method[80]", null);
            List<CustSortOrderAttributes> csoList = cso.getSortOrderlist();
            Logger.error("FetchAtriumClassesWebService", "inside fetchCmdbWSData method[79]" + csoList.size(), null, -1, -1, -1, -1);
            for (int csoCnt = 0; csoCnt < csoList.size(); csoCnt++) {
                Logger.error("FetchAtriumClassesWebService", "inside fetchCmdbWSData method[78]" + csoList.get(csoCnt), null);
                CustSortOrderAttributes csoa = csoList.get(csoCnt);
                Logger.error("FetchAtriumClassesWebService", "inside fetchCmdbWSData method[77]" + csoa.getAttributeName(), null);

                SortOrder so = new SortOrder();
                so.setAttributeName(csoa.getAttributeName());
                SortOrderType sot = null;
                if (csoa.getSortOrder().equalsIgnoreCase("ASCENDING")) {
                    sot = SortOrderType.ASCENDING;
                } else {
                    sot = SortOrderType.DESCENDING;
                }
                so.setSortOrder(sot);
                soL.add(so);

                Logger.error("FetchAtriumClassesWebService", "inside computerSystemWSCall method[76]" + cmdb.getConstantData().getCustFirstRetrieve(), null);
                try {

                    aipt.getInstances(null, id, finalQuery, sa, firstRetrieve, maxRetrieve, soList, cmdb.getConstantData().getCustDatasetId(), gm, extensions, instanceInfo, status);

                } catch (AtriumFault e) {
                    throw new AtriumFault("", e.getFaultInfo());
                }

                Logger.error("FetchAtriumClassesWebService", "inside computerSystemWSCall method[75]", null);
            }
        } catch (Exception e) {
            e.printStackTrace();;
            Logger.error("Exception ::::: ", "", null);
        }

    }
}
