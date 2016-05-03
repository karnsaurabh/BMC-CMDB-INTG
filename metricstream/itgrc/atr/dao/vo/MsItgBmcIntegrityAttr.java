package com.metricstream.itgrc.atr.dao.vo;

// Generated Apr 30, 2016 2:36:27 AM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MsItgBmcIntegrityAttr generated by hbm2java
 */
@Entity
@Table(name = "MS_ITG_BMC_INTEGRITY_ATTR")
public class MsItgBmcIntegrityAttr implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal createdBy;
	private Date creationDate;
	private BigDecimal lastUpdatedBy;
	private Date lastUpdateDate;
	private Integer integrityStoredV;
	private String integrityDisplayedV;

	public MsItgBmcIntegrityAttr() {
	}

	@Column(name = "CREATED_BY", precision = 22, scale = 0)
	public BigDecimal getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "CREATION_DATE", length = 7)
	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Column(name = "LAST_UPDATED_BY", precision = 22, scale = 0)
	public BigDecimal getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}

	public void setLastUpdatedBy(BigDecimal lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	@Column(name = "LAST_UPDATE_DATE", length = 7)
	public Date getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	@Column(name = "INTEGRITY_STORED_V", precision = 22, scale = 0)
	public Integer getIntegrityStoredV() {
		return this.integrityStoredV;
	}

	public void setIntegrityStoredV(Integer integrityStoredV) {
		this.integrityStoredV = integrityStoredV;
	}

	@Id
	@Column(name = "INTEGRITY_DISPLAYED_V", length = 1600)
	public String getIntegrityDisplayedV() {
		return this.integrityDisplayedV;
	}

	public void setIntegrityDisplayedV(String integrityDisplayedV) {
		this.integrityDisplayedV = integrityDisplayedV;
	}

}