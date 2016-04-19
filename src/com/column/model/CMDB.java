package com.column.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "CMDB")
public class CMDB {

//	private CustClassData classData;
	private CustConstantData constantData;
	private List<CustClassData> classDataList;

//	public CustClassData getClassData() {
//		return classData;
//	}
//
//	public void setClassData(CustClassData classData) {
//		this.classData = classData;
//	}

	public CustConstantData getConstantData() {
		return constantData;
	}

	public void setConstantData(CustConstantData constantData) {
		this.constantData = constantData;
	}

	public List<CustClassData> getClassDataList() {
		return classDataList;
	}

	public void setClassDataList(List<CustClassData> classDataList) {
		this.classDataList = classDataList;
	}
	
	

}
