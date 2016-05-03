package com.column.model;

import javax.xml.bind.annotation.XmlAttribute;

public class CustClassData {
	@XmlAttribute
	private int id;
	private CustClassNameId custClassNameId;
	private String custQuery;
	private CustAttributes custAttributes;
	private CustSortOrder custSortOrder;

	public CustClassNameId getCustClassNameId() {
		return custClassNameId;
	}
	public void setCustClassNameId(CustClassNameId custClassNameId) {
		this.custClassNameId = custClassNameId;
	}
	public String getCustQuery() {
		return custQuery;
	}
	public void setCustQuery(String custQuery) {
		this.custQuery = custQuery;
	}
	public CustAttributes getCustAttributes() {
		return custAttributes;
	}
	public void setCustAttributes(CustAttributes custAttributes) {
		this.custAttributes = custAttributes;
	}
	public CustSortOrder getCustSortOrder() {
		return custSortOrder;
	}
	public void setCustSortOrder(CustSortOrder custSortOrder) {
		this.custSortOrder = custSortOrder;
	}
	
	
	
}
