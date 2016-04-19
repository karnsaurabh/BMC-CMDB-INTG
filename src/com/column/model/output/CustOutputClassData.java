package com.column.model.output;

public class CustOutputClassData {
	private String custInstanceId;
	private String custOutputNamespaceName;
	private String custOutputClassName;
	
	private CustOutputAttributes[] custOutputAttributes;

	public String getCustInstanceId() {
		return custInstanceId;
	}

	public void setCustInstanceId(String custInstanceId) {
		this.custInstanceId = custInstanceId;
	}

	public String getCustOutputNamespaceName() {
		return custOutputNamespaceName;
	}

	public void setCustOutputNamespaceName(String custOutputNamespaceName) {
		this.custOutputNamespaceName = custOutputNamespaceName;
	}

	public String getCustOutputClassName() {
		return custOutputClassName;
	}

	public void setCustOutputClassName(String custOutputClassName) {
		this.custOutputClassName = custOutputClassName;
	}

	public CustOutputAttributes[] getCustOutputAttributes() {
		return custOutputAttributes;
	}

	public void setCustOutputAttributes(CustOutputAttributes[] custOutputAttributes) {
		this.custOutputAttributes = custOutputAttributes;
	}

}
