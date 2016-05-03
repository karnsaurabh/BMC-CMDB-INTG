package com.metricstream.itgrc.atr.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.column.model.CMDB;
import com.column.model.CustAttributes;
import com.column.model.CustClassData;
import com.column.model.CustClassNameId;
import com.column.model.CustConstantData;
import com.column.model.CustSortOrder;
import com.column.model.CustSortOrderAttributes;
import com.metricstream.itgrc.atr.constants.WebServiceAttributes;
import com.metricstream.log.Logger;

@Named
public class WebServiceData {

    public CMDB getBMCComputerSystemAttribues() {
        Logger.error("CmdbWSFetch", "inside getBMCComputerSystemAttribues method[96]", null);
        CMDB cmdb = new CMDB();
        CustConstantData custConstantData = new CustConstantData();
        custConstantData.setCustDatasetId(WebServiceAttributes.CUST_DATASET_ID);
        custConstantData.setCustFirstRetrieve(0);
        custConstantData.setCustGetMask(WebServiceAttributes.CUST_GET_MASK_DATASET_MODE);
        custConstantData.setCustMaxRetrieve(0);
        cmdb.setConstantData(custConstantData);
        List<CustClassData> classDataList = new ArrayList<CustClassData>();
        CustClassData custClassDataComputerSystem = new CustClassData();

        CustAttributes custAttributes = new CustAttributes();
        List<String> custList = new ArrayList<String>();
        custList.add(WebServiceAttributes.NAME);
        custList.add(WebServiceAttributes.DESCRIPTION);
        custList.add(WebServiceAttributes.REGION);
        custList.add(WebServiceAttributes.SITE_GROUP);
        custList.add(WebServiceAttributes.SITE);
        custList.add(WebServiceAttributes.FLOOR);
        custList.add(WebServiceAttributes.ROOM);
        custList.add(WebServiceAttributes.CONFIDENTIALITY);
        custList.add(WebServiceAttributes.INTEGRITY);
        custList.add(WebServiceAttributes.AVAILABILITY);
        custList.add(WebServiceAttributes.DEPARTMENT);
        custList.add(WebServiceAttributes.OWNER_NAME);
        custList.add(WebServiceAttributes.SERIAL_NUMBER);
        custList.add(WebServiceAttributes.DOMAIN);
        custList.add(WebServiceAttributes.PRIMARY_CAPABILITY);
        custAttributes.setCustList(custList);
        custClassDataComputerSystem.setCustAttributes(custAttributes);
        CustClassNameId custClassNameId = new CustClassNameId();
        custClassNameId.setCustClassName("BMC_ComputerSystem");
        custClassNameId.setCustNamespaceName("BMC.CORE");
        custClassDataComputerSystem.setCustClassNameId(custClassNameId);
        CustSortOrder custSortOrder = new CustSortOrder();
        List<CustSortOrderAttributes> sortOrderlist = new ArrayList<CustSortOrderAttributes>();
        CustSortOrderAttributes custSortOrderAttributes = new CustSortOrderAttributes();
        custSortOrderAttributes.setAttributeName(WebServiceAttributes.NAME);
        custSortOrderAttributes.setSortOrder(WebServiceAttributes.ASCENDING_SORT_ORDER);
        sortOrderlist.add(custSortOrderAttributes);
        custSortOrder.setSortOrderlist(sortOrderlist);
        custClassDataComputerSystem.setCustSortOrder(custSortOrder);
        classDataList.add(custClassDataComputerSystem);
        cmdb.setClassDataList(classDataList);
        Logger.error("CmdbWSFetch", "inside getBMCComputerSystemAttribues method[95]", null);
        return cmdb;
    }

    public CMDB getBMCIPEndpointAttribues() {
        CMDB cmdb = new CMDB();
        CustConstantData custConstantData = new CustConstantData();
        custConstantData.setCustDatasetId(WebServiceAttributes.CUST_DATASET_ID);
        custConstantData.setCustFirstRetrieve(0);
        custConstantData.setCustGetMask(WebServiceAttributes.CUST_GET_MASK_DATASET_MODE);
        custConstantData.setCustMaxRetrieve(0);
        cmdb.setConstantData(custConstantData);
        List<CustClassData> classDataList = new ArrayList<CustClassData>();
        CustClassData custClassDataApplication = new CustClassData();

        CustAttributes custAttributes = new CustAttributes();
        List<String> custList = new ArrayList<String>();
        custList.add(WebServiceAttributes.ADDRESS_TYPE);
        custList.add(WebServiceAttributes.ADDRESS);
        custList.add(WebServiceAttributes.DNS_HOSTNAME);
        custAttributes.setCustList(custList);
        custClassDataApplication.setCustAttributes(custAttributes);
        CustClassNameId custClassNameId = new CustClassNameId();
        custClassNameId.setCustClassName("BMC_IPEndpoint");
        custClassNameId.setCustNamespaceName("BMC.CORE");
        custClassDataApplication.setCustClassNameId(custClassNameId);
        CustSortOrder custSortOrder = new CustSortOrder();
        List<CustSortOrderAttributes> sortOrderlist = new ArrayList<CustSortOrderAttributes>();
        CustSortOrderAttributes custSortOrderAttributes = new CustSortOrderAttributes();
        custSortOrderAttributes.setAttributeName(WebServiceAttributes.ADDRESS);
        custSortOrderAttributes.setSortOrder(WebServiceAttributes.ASCENDING_SORT_ORDER);
        sortOrderlist.add(custSortOrderAttributes);
        custSortOrder.setSortOrderlist(sortOrderlist);
        custClassDataApplication.setCustSortOrder(custSortOrder);
        classDataList.add(custClassDataApplication);
        cmdb.setClassDataList(classDataList);
        return cmdb;
    }

    public CMDB getBMCHostedAccessAttribues() {
        CMDB cmdb = new CMDB();
        CustConstantData custConstantData = new CustConstantData();
        custConstantData.setCustDatasetId(WebServiceAttributes.CUST_DATASET_ID);
        custConstantData.setCustFirstRetrieve(0);
        custConstantData.setCustGetMask(WebServiceAttributes.CUST_GET_MASK_DATASET_MODE);
        custConstantData.setCustMaxRetrieve(0);
        cmdb.setConstantData(custConstantData);
        List<CustClassData> classDataList = new ArrayList<CustClassData>();
        CustClassData custClassDataApplication = new CustClassData();

        CustAttributes custAttributes = new CustAttributes();
        List<String> custList = new ArrayList<String>();
        custList.add("Source.ClassId");
        custList.add("Source.InstanceId");
        custList.add("Destination.ClassId");
        custList.add("Destination.InstanceId");
        custAttributes.setCustList(custList);
        custClassDataApplication.setCustAttributes(custAttributes);
        CustClassNameId custClassNameId = new CustClassNameId();
        custClassNameId.setCustClassName("BMC_HostedAccessPoint");
        custClassNameId.setCustNamespaceName("BMC.CORE");
        custClassDataApplication.setCustClassNameId(custClassNameId);
        CustSortOrder custSortOrder = new CustSortOrder();
        List<CustSortOrderAttributes> sortOrderlist = new ArrayList<CustSortOrderAttributes>();
        CustSortOrderAttributes custSortOrderAttributes = new CustSortOrderAttributes();
        custSortOrderAttributes.setAttributeName("Source.ClassId");
        custSortOrderAttributes.setSortOrder(WebServiceAttributes.ASCENDING_SORT_ORDER);
        sortOrderlist.add(custSortOrderAttributes);
        custSortOrder.setSortOrderlist(sortOrderlist);
        custClassDataApplication.setCustSortOrder(custSortOrder);
        classDataList.add(custClassDataApplication);
        cmdb.setClassDataList(classDataList);
        return cmdb;
    }
    
    public CMDB getBMCLANEndpointAttribues() {
        CMDB cmdb = new CMDB();
        CustConstantData custConstantData = new CustConstantData();
        custConstantData.setCustDatasetId(WebServiceAttributes.CUST_DATASET_ID);
        custConstantData.setCustFirstRetrieve(0);
        custConstantData.setCustGetMask(WebServiceAttributes.CUST_GET_MASK_DATASET_MODE);
        custConstantData.setCustMaxRetrieve(0);
        cmdb.setConstantData(custConstantData);
        List<CustClassData> classDataList = new ArrayList<CustClassData>();
        CustClassData custClassDataApplication = new CustClassData();

        CustAttributes custAttributes = new CustAttributes();
        List<String> custList = new ArrayList<String>();
        custList.add(WebServiceAttributes.MAC_ADDRESS);
        custAttributes.setCustList(custList);
        custClassDataApplication.setCustAttributes(custAttributes);
        CustClassNameId custClassNameId = new CustClassNameId();
        custClassNameId.setCustClassName("BMC_LANEndpoint");
        custClassNameId.setCustNamespaceName("BMC.CORE");
        custClassDataApplication.setCustClassNameId(custClassNameId);
        CustSortOrder custSortOrder = new CustSortOrder();
        List<CustSortOrderAttributes> sortOrderlist = new ArrayList<CustSortOrderAttributes>();
        CustSortOrderAttributes custSortOrderAttributes = new CustSortOrderAttributes();
        custSortOrderAttributes.setAttributeName(WebServiceAttributes.MAC_ADDRESS);
        custSortOrderAttributes.setSortOrder(WebServiceAttributes.ASCENDING_SORT_ORDER);
        sortOrderlist.add(custSortOrderAttributes);
        custSortOrder.setSortOrderlist(sortOrderlist);
        custClassDataApplication.setCustSortOrder(custSortOrder);
        classDataList.add(custClassDataApplication);
        cmdb.setClassDataList(classDataList);
        return cmdb;
    }

}
