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
@Table(name = "TBLORGANIZATION")

public class Organization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ORGANIZATION_ID;
	
	@Column(name = "ORGANIZATION_NAME")
	private String  ORGANIZATION_NAME;
	
	@Column(name = "ORGANIZATION_DESC")
	private String ORGANIZATION_DESC;
	
	@ManyToOne
	@JoinColumn(name = "ORGANIZATIONTYPE_ID")
	private Lookup ORGANIZATIONTYPE_ID ;
		
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

	public long getORGANIZATION_ID() {
		return ORGANIZATION_ID;
	}

	public void setORGANIZATION_ID(long oRGANIZATION_ID) {
		ORGANIZATION_ID = oRGANIZATION_ID;
	}

	public String getORGANIZATION_NAME() {
		return ORGANIZATION_NAME;
	}

	public void setORGANIZATION_NAME(String oRGANIZATION_NAME) {
		ORGANIZATION_NAME = oRGANIZATION_NAME;
	}

	public String getORGANIZATION_DESC() {
		return ORGANIZATION_DESC;
	}

	public void setORGANIZATION_DESC(String oRGANIZATION_DESC) {
		ORGANIZATION_DESC = oRGANIZATION_DESC;
	}

	public Lookup getORGANIZATIONTYPE_ID() {
		return ORGANIZATIONTYPE_ID;
	}

	public void setORGANIZATIONTYPE_ID(Lookup oRGANIZATIONTYPE_ID) {
		ORGANIZATIONTYPE_ID = oRGANIZATIONTYPE_ID;
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
		return (long) 5;
	}

	
}
