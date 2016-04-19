package com.column.soap.util;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Holder;

import org.apache.log4j.Logger;

import com.bmc.atrium._2009._01.common.AttributeValue;
import com.bmc.atrium._2009._01.common.AttributeValueList;
import com.bmc.atrium._2009._01.common.ClassNameId;
import com.bmc.atrium._2009._01.common.InstanceInfoOutList;
import com.column.model.output.CMDBOutputData;
import com.column.model.output.CustOutputAttributes;
import com.column.model.output.CustOutputClassData;

public class ResponseData {
	private static Logger logger = Logger.getLogger(ResponseData.class);

	public static CMDBOutputData writeOutputData(Holder<InstanceInfoOutList> instanceInfo) {
		CMDBOutputData outData = new CMDBOutputData();
		List<CustOutputClassData> custOutputClassDataList = new ArrayList<CustOutputClassData>();
		
		for(int cnt = 0;cnt < instanceInfo.value.getList().size(); cnt++)
		{
			ClassNameId classNameId = instanceInfo.value.getList().get(cnt).getClassNameId();
			AttributeValueList avList = instanceInfo.value.getList().get(cnt).getInstanceAttributes();
			String instanceId = instanceInfo.value.getList().get(cnt).getInstanceId();
			
			CustOutputClassData custOutputClassData = new CustOutputClassData();
			custOutputClassData.setCustOutputClassName(classNameId.getClassName());
			custOutputClassData.setCustOutputNamespaceName(classNameId.getNamespaceName());
			
			custOutputClassData.setCustInstanceId(instanceId);
			List<AttributeValue> avs =  avList.getList();
			
			CustOutputAttributes[] attributes = new CustOutputAttributes[avs.size()];
			CustOutputAttributes attribute = null;
			AttributeValue av = null; 
					
			for(int i = 0 ; i < avs.size() ; i++)
			{
				av = avs.get(i); 
				attribute = new CustOutputAttributes();
				attribute.setOutputAttributeName(av.getName());
				String strValue = av.getValue().getStringValue();
				if(strValue != null && strValue.length() > 0)
				{
					attribute.setOutputAttributeValue(strValue);
				}
				else
				{
					attribute.setOutputAttributeValue("null");
				}
					
				attributes[i] = attribute;
			}
			custOutputClassData.setCustOutputAttributes(attributes);				
			custOutputClassDataList.add(custOutputClassData);
		}
		outData.setCustOutputClassDatas(custOutputClassDataList);
		
		return outData;
	}
}
