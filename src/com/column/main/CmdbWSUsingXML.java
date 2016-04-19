package com.column.main;

import java.util.List;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;

import org.apache.log4j.Logger;

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
import com.column.model.CustClassData;
import com.column.model.CustClassNameId;
import com.column.model.CustConstantData;
import com.column.model.CustSortOrder;
import com.column.model.CustSortOrderAttributes;
import com.column.model.output.CMDBOutputData;
import com.column.soap.util.ResponseData;
import com.column.util.CustomEndPointURL;
import com.column.util.XmlReaderWriter;

public class CmdbWSUsingXML {
	private static Logger logger = Logger.getLogger(CmdbWSUsingXML.class);
	
	private static final String XMLFILEPATH_INPUT="xml_resources\\input.xml";
	private static final String XMLFILEPATH_OUTPUT="xml_resources\\outputfiles\\";
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try{
		 	CMDB cmdb = XmlReaderWriter.getIndataObject(XMLFILEPATH_INPUT);
		 	
		 	CustConstantData custConstantData = cmdb.getConstantData(); 
			List<CustClassData> custClassDataList = cmdb.getClassDataList();
			
			CustClassNameId classNameid = null;
			for(int i = 0; i < custClassDataList.size() ; i++ )
			{
				CustClassData ccd = custClassDataList.get(i);
				classNameid = ccd.getCustClassNameId();
				ClassNameId id = new ClassNameId();
				id.setClassName(classNameid.getCustClassName());
				id.setNamespaceName(classNameid.getCustNamespaceName());
	
		        CustAttributes atb = ccd.getCustAttributes();
				List<String> atbList = atb.getCustList();
		        StringArray sa = new StringArray();
		        List<String> list1 = sa.getList();
		        for(int l1 = 0; l1 < atbList.size() ; l1++)
		        {
		        	list1.add(atbList.get(l1));
		        }
		        String datasetId = custConstantData.getCustDatasetId();
		        String query = ccd.getCustQuery();
		        
		        SortOrderList soList = new SortOrderList();
		        List<SortOrder> soL =  soList.getList();
		        
		        CustSortOrder cso = ccd.getCustSortOrder();
		        List<CustSortOrderAttributes> csoList = cso.getSortOrderlist();
		        for(int csoCnt=0;csoCnt<csoList.size();csoCnt++){
		        	
		        	CustSortOrderAttributes csoa = csoList.get(csoCnt);
		        	
			        SortOrder so = new SortOrder();
			        so.setAttributeName(csoa.getAttributeName());
			        SortOrderType sot = null;
			        if(csoa.getSortOrder().equalsIgnoreCase("ASCENDING")){
			        	sot = SortOrderType.ASCENDING;
			        }else{
			        	sot = SortOrderType.DESCENDING;
			        }
			        so.setSortOrder(sot);
			        soL.add(so);
		        	
		        }
		        
				AtriumInstances ai = new AtriumInstances();
	            
	            HeaderHandlerResolver hhr = new HeaderHandlerResolver();
	            ai.setHandlerResolver(hhr);
	            AtriumInstancesPortType aipt =  ai.getAtriumInstancesWebService();
	            BindingProvider bp = (BindingProvider)aipt;
	
	            String endPointURL = CustomEndPointURL.getEndPoint();
	            System.out.println("End Point URL is :: " + endPointURL);
	            bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endPointURL);
	            GetMask gm = GetMask.DATASET_MODE_CURRENT;
	            int firstRetrieve = custConstantData.getCustFirstRetrieve();
	            int maxRetrieve = custConstantData.getCustMaxRetrieve();
	            
	            final Holder<ExtensionList> extensions = new Holder<ExtensionList>();
	            final Holder<InstanceInfoOutList> instanceInfo = new Holder<InstanceInfoOutList>();
	            final Holder<StatusList> status = new Holder<StatusList>();
	            try {
	            	
					aipt.getInstances(null, id , query, sa, firstRetrieve, maxRetrieve, soList, datasetId, gm , extensions, instanceInfo, status);
					
					CMDBOutputData outData = ResponseData.writeOutputData(instanceInfo);
					
					XmlReaderWriter.writeOutputData(XMLFILEPATH_OUTPUT, outData, custClassDataList.get(i).getCustClassNameId().getCustClassName() );
					
					
				} catch (AtriumFault e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("AtriumFault Exception ::::: ", e);
				}
			}	
		}
		catch(Exception e){
			e.printStackTrace();
			logger.error("Exception ::::: ", e);
		}

	}

}
