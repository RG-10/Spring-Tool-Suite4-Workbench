package com.cwiztech.company.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cwiztech.systemsetting.model.Lookup;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TBLCOMPANY")

public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long COMPANY_ID;
	
	@Column(name = "COMPANY_NUMBER")
	private String COMPANY_NUMBER ;
	
	@Column(name = "COMPANY_NAME")
	private String COMPANY_NAME ;
	
	@Column(name = "COMPANY_DESC")
	private String COMPANY_DESC ;
	
	@ManyToOne
	@JoinColumn(name = "COMPANYSUBTYPE_ID")
	private CompanySubtype COMPANYSUBTYPE_ID ;
	
	@ManyToOne
	@JoinColumn(name = "BUSINESSNATURE_ID")
	private Lookup BUSINESSNATURE_ID ;
	
	@ManyToOne
	@JoinColumn(name = "COMPANYSTATUS_ID")
	private Lookup COMPANYSTATUS_ID ;
	
	@Column(name = "START_DATE")
	private String START_DATE ;
	
	@Column(name = "END_DATE")
	private String END_DATE ;
	
	@Column(name = "COMPANYPARENT_ID")
	private Long COMPANYPARENT_ID;
	
	@Column(name = "ADDRESS_LINE1")
	private String  ADDRESS_LINE1;
	
	@Column(name = "ADDRESS_LINE2")
	private String  ADDRESS_LINE2;
	
	@Column(name = "ADDRESS_LINE3")
	private String ADDRESS_LINE3 ;
	
	@Column(name = "ADDRESS_LINE4")
	private String  ADDRESS_LINE4;
	
	@Column(name = "ADDRESS_LINE5")
	private String  ADDRESS_LINE5;
	
	@Column(name = "ADDRESS_POSTCODE")
	private String  ADDRESS_POSTCODE;
	
	@Column(name = "LOCATION_ID")
	private Long LOCATION_ID ;
	
	@Column(name = "COMPANYLOGO_PATH")
	private String COMPANYLOGO_PATH ;
	
	@Column(name = "ISACTIVE")
	private String ISACTIVE;

	@JsonIgnore
	@Column(name = "MODIFIED_BY")
	private Long MODIFIED_BY;
	
	@JsonIgnore
	@Column(name = "MODIFIED_WHEN")
	private String MODIFIED_WHEN;

	@JsonIgnore
	@Column(name = "MODIFIED_WORKSTATION")
	private String MODIFIED_WORKSTATION;

	public long getCOMPANY_ID() {
		return COMPANY_ID;
	}

	public void setCOMPANY_ID(long cOMPANY_ID) {
		COMPANY_ID = cOMPANY_ID;
	}

	public String getCOMPANY_NUMBER() {
		return COMPANY_NUMBER;
	}

	public void setCOMPANY_NUMBER(String cOMPANY_NUMBER) {
		COMPANY_NUMBER = cOMPANY_NUMBER;
	}

	public String getCOMPANY_NAME() {
		return COMPANY_NAME;
	}

	public void setCOMPANY_NAME(String cOMPANY_NAME) {
		COMPANY_NAME = cOMPANY_NAME;
	}

	public String getCOMPANY_DESC() {
		return COMPANY_DESC;
	}

	public void setCOMPANY_DESC(String cOMPANY_DESC) {
		COMPANY_DESC = cOMPANY_DESC;
	}

	public CompanySubtype getCOMPANYSUBTYPE_ID() {
		return COMPANYSUBTYPE_ID;
	}

	public void setCOMPANYSUBTYPE_ID(CompanySubtype cOMPANYSUBTYPE_ID) {
		COMPANYSUBTYPE_ID = cOMPANYSUBTYPE_ID;
	}

	
	public Lookup getBUSINESSNATURE_ID() {
		return BUSINESSNATURE_ID;
	}

	public void setBUSINESSNATURE_ID(Lookup bUSINESSNATURE_ID) {
		BUSINESSNATURE_ID = bUSINESSNATURE_ID;
	}

	public Lookup getCOMPANYSTATUS_ID() {
		return COMPANYSTATUS_ID;
	}

	public void setCOMPANYSTATUS_ID(Lookup cOMPANYSTATUS_ID) {
		COMPANYSTATUS_ID = cOMPANYSTATUS_ID;
	}

	public String getSTART_DATE() {
		return START_DATE;
	}

	public void setSTART_DATE(String sTART_DATE) {
		START_DATE = sTART_DATE;
	}

	public String getEND_DATE() {
		return END_DATE;
	}

	public void setEND_DATE(String eND_DATE) {
		END_DATE = eND_DATE;
	}

	public Long getCOMPANYPARENT_ID() {
		return COMPANYPARENT_ID;
	}

	public void setCOMPANYPARENT_ID(Long cOMPANYPARENT_ID) {
		COMPANYPARENT_ID = cOMPANYPARENT_ID;
	}

	public String getADDRESS_LINE1() {
		return ADDRESS_LINE1;
	}

	public void setADDRESS_LINE1(String aDDRESS_LINE1) {
		ADDRESS_LINE1 = aDDRESS_LINE1;
	}

	public String getADDRESS_LINE2() {
		return ADDRESS_LINE2;
	}

	public void setADDRESS_LINE2(String aDDRESS_LINE2) {
		ADDRESS_LINE2 = aDDRESS_LINE2;
	}

	public String getADDRESS_LINE3() {
		return ADDRESS_LINE3;
	}

	public void setADDRESS_LINE3(String aDDRESS_LINE3) {
		ADDRESS_LINE3 = aDDRESS_LINE3;
	}

	public String getADDRESS_LINE4() {
		return ADDRESS_LINE4;
	}

	public void setADDRESS_LINE4(String aDDRESS_LINE4) {
		ADDRESS_LINE4 = aDDRESS_LINE4;
	}

	public String getADDRESS_LINE5() {
		return ADDRESS_LINE5;
	}

	public void setADDRESS_LINE5(String aDDRESS_LINE5) {
		ADDRESS_LINE5 = aDDRESS_LINE5;
	}

	public String getADDRESS_POSTCODE() {
		return ADDRESS_POSTCODE;
	}

	public void setADDRESS_POSTCODE(String aDDRESS_POSTCODE) {
		ADDRESS_POSTCODE = aDDRESS_POSTCODE;
	}
	
	public Long getLOCATION_ID() {
		return LOCATION_ID;
	}

	public void setLOCATION_ID(Long lOCATION_ID) {
		LOCATION_ID = lOCATION_ID;
	}

	public String getCOMPANYLOGO_PATH() {
		return COMPANYLOGO_PATH;
	}

	public void setCOMPANYLOGO_PATH(String cOMPANYLOGO_PATH) {
		COMPANYLOGO_PATH = cOMPANYLOGO_PATH;
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
		return (long) 3;
	}
}
