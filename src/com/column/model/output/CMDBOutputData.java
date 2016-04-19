package com.column.model.output;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "CMDBOutput")
public class CMDBOutputData {

	private List<CustOutputClassData> custOutputClassDatas;

	public List<CustOutputClassData> getCustOutputClassDatas() {
		return custOutputClassDatas;
	}

	public void setCustOutputClassDatas(
			List<CustOutputClassData> custOutputClassDatas) {
		this.custOutputClassDatas = custOutputClassDatas;
	}


	
}
