package com.cwiztech.company.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.cwiztech.systemsetting.model.Lookup;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TBLCOMPANYSUBTYPE")

public class CompanySubtype {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long COMPANYSUBTYPE_ID;
	
	@ManyToOne
	@JoinColumn(name = "COMPANYTYPE_ID")
	private Lookup COMPANYTYPE_ID ;
	
	@Column(name = "COMPANYSUBTYPE_NAME")
	private String  COMPANYSUBTYPE_NAME;
	
	@Column(name = "COMPANYSUBTYPE_DESC")
	private String  COMPANYSUBTYPE_DESC;
		
	@Column(name = "ISACTIVE")
	private String ISACTIVE;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "MODIFIED_BY")
	private Long MODIFIED_BY;
	
	@JsonIgnore
	@Column(name = "MODIFIED_WHEN")
	private String MODIFIED_WHEN;

	@JsonIgnore
	@Column(name = "MODIFIED_WORKSTATION")
	private String MODIFIED_WORKSTATION;

	public long getCOMPANYSUBTYPE_ID() {
		return COMPANYSUBTYPE_ID;
	}

	public void setCOMPANYSUBTYPE_ID(long cOMPANYSUBTYPE_ID) {
		COMPANYSUBTYPE_ID = cOMPANYSUBTYPE_ID;
	}

	public Lookup getCOMPANYTYPE_ID() {
		return COMPANYTYPE_ID;
	}

	public void setCOMPANYTYPE_ID(Lookup cOMPANYTYPE_ID) {
		COMPANYTYPE_ID = cOMPANYTYPE_ID;
	}

	public String getCOMPANYSUBTYPE_NAME() {
		return COMPANYSUBTYPE_NAME;
	}

	public void setCOMPANYSUBTYPE_NAME(String cOMPANYSUBTYPE_NAME) {
		COMPANYSUBTYPE_NAME = cOMPANYSUBTYPE_NAME;
	}

	public String getCOMPANYSUBTYPE_DESC() {
		return COMPANYSUBTYPE_DESC;
	}

	public void setCOMPANYSUBTYPE_DESC(String cOMPANYSUBTYPE_DESC) {
		COMPANYSUBTYPE_DESC = cOMPANYSUBTYPE_DESC;
	}

	public String getISACTIVE() {
		return ISACTIVE;
	}

	public void setISACTIVE(String iSACTIVE) {
		ISACTIVE = iSACTIVE;
	}

	@JsonIgnore
	public Long getMODIFIED_BY() {
		return MODIFIED_BY;
	}

	public void setMODIFIED_BY(Long mODIFIED_BY) {
		MODIFIED_BY = mODIFIED_BY;
	}

	@JsonIgnore
	public String getMODIFIED_WHEN() {
		return MODIFIED_WHEN;
	}

	public void setMODIFIED_WHEN(String mODIFIED_WHEN) {
		MODIFIED_WHEN = mODIFIED_WHEN;
	}

	@JsonIgnore
	public String getMODIFIED_WORKSTATION() {
		return MODIFIED_WORKSTATION;
	}

	public void setMODIFIED_WORKSTATION(String mODIFIED_WORKSTATION) {
		MODIFIED_WORKSTATION = mODIFIED_WORKSTATION;
	}
	public static long getDatabaseTableID() {
		return (long) 4;
	}

	
}
