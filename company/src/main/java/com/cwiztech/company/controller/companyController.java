package com.cwiztech.company.controller;

import java.text.ParseException;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cwiztech.company.model.Company;
import com.cwiztech.company.repository.companyRepository;
import com.cwiztech.company.repository.companySubtypeRepository;
import com.cwiztech.datalogs.model.APIRequestDataLog;
import com.cwiztech.datalogs.model.DatabaseTables;
import com.cwiztech.datalogs.model.tableDataLogs;
import com.cwiztech.datalogs.repository.apiRequestDataLogRepository;
import com.cwiztech.datalogs.repository.databaseTablesRepository;
import com.cwiztech.datalogs.repository.tableDataLogRepository;
import com.cwiztech.systemsetting.repository.lookupRepository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin
@RequestMapping("/company")
public class companyController {
	
	private static final Logger log = LoggerFactory.getLogger(companyController.class);

	@Autowired
	private companyRepository companyrepository;
	
	@Autowired
	private lookupRepository lookuprepository;

	@Autowired
	private companySubtypeRepository companysubtyperepository;

	@Autowired
	private apiRequestDataLogRepository apirequestdatalogRepository;
	
	@Autowired
	private tableDataLogRepository tbldatalogrepository;

	@Autowired
	private databaseTablesRepository databasetablesrepository;
		
	@RequestMapping(method = RequestMethod.GET)
	public String get(@RequestHeader(value = "Authorization") String headToken) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		log.info("GET: /company");

		List<Company> company = companyrepository.findActive();
		String rtn, workstation = null;
		
		Long requestUser;
		requestUser = (long) 0;

		DatabaseTables databaseTableID = databasetablesrepository.findOne(Company.getDatabaseTableID());
		APIRequestDataLog apiRequest = tableDataLogs.apiRequestDataLog("GET", databaseTableID, requestUser, "/company", null,
				workstation);

		rtn = mapper.writeValueAsString(company);

		apiRequest.setREQUEST_OUTPUT(rtn);
		apiRequest.setREQUEST_STATUS("Success");
		apirequestdatalogRepository.saveAndFlush(apiRequest);

		log.info("Output: " + rtn);
		log.info("--------------------------------------------------------");

		return rtn;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getOne(@PathVariable Long id,@RequestHeader(value = "Authorization") String headToken) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		log.info("GET: /company/" + id);

		Company company = companyrepository.findOne(id);
		String rtn, workstation = null;

		Long requestUser;
		requestUser = (long) 0;
		
		DatabaseTables databaseTableID = databasetablesrepository.findOne(Company.getDatabaseTableID());
		APIRequestDataLog apiRequest = tableDataLogs.apiRequestDataLog("GET", databaseTableID, requestUser, "/company/" + id,
				null, workstation);

		rtn = mapper.writeValueAsString(company);

		apiRequest.setREQUEST_OUTPUT(rtn);
		apiRequest.setREQUEST_STATUS("Success");
		apirequestdatalogRepository.saveAndFlush(apiRequest);

		log.info("Output: " + rtn);
		log.info("--------------------------------------------------------");

		return rtn;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String getAll(@RequestHeader(value = "Authorization") String headToken) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		log.info("GET: /company/all");

		List<Company> company = companyrepository.findAll();
		String rtn, workstation = null;
		
		Long requestUser;
		requestUser = (long) 0;

		DatabaseTables databaseTableID = databasetablesrepository.findOne(Company.getDatabaseTableID());
		APIRequestDataLog apiRequest = tableDataLogs.apiRequestDataLog("GET", databaseTableID, requestUser,
				"/company/all", null, workstation);

		rtn = mapper.writeValueAsString(company);

		apiRequest.setREQUEST_OUTPUT(rtn);
		apiRequest.setREQUEST_STATUS("Success");
		apirequestdatalogRepository.saveAndFlush(apiRequest);

		log.info("Output: " + rtn);
		log.info("--------------------------------------------------------");

		return rtn;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String insert(@RequestBody String data,@RequestHeader(value = "Authorization") String headToken)
			throws JsonProcessingException, JSONException, ParseException {
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MMM/YYYY HH:mm:ss");
		Date date = new Date();
		ObjectMapper mapper = new ObjectMapper();
		

		log.info("POST: /company");
		log.info("Input: " + data);

		JSONObject jsonObj = new JSONObject(data);
		Company company = new Company();
		String rtn, workstation = null;
		
		Long requestUser;
		requestUser = (long) 0;

		DatabaseTables databaseTableID = databasetablesrepository.findOne(Company.getDatabaseTableID());
		
		if (jsonObj.has("workstation"))
			workstation = jsonObj.getString("workstation");
		APIRequestDataLog apiRequest = tableDataLogs.apiRequestDataLog("POST", databaseTableID, requestUser, "/company", data,
				workstation);

		if (!jsonObj.has("company_NAME") && !jsonObj.isNull("company_NAME")) {
			apiRequest = tableDataLogs.errorDataLog(apiRequest, "company", "Company Name is missing");
			apirequestdatalogRepository.saveAndFlush(apiRequest);
			return apiRequest.getREQUEST_OUTPUT();
		}
		
		if (!jsonObj.has("companysubtype_ID") && !jsonObj.isNull("companysubtype_ID")) {
			apiRequest = tableDataLogs.errorDataLog(apiRequest, "company", "Companysubtype ID is missing");
			apirequestdatalogRepository.saveAndFlush(apiRequest);
			return apiRequest.getREQUEST_OUTPUT();
		}
		
		if (!jsonObj.has("businessnature_ID") && !jsonObj.isNull("businessnature_ID")) {
			apiRequest = tableDataLogs.errorDataLog(apiRequest, "company", "Companybusinessnature ID is missing");
			apirequestdatalogRepository.saveAndFlush(apiRequest);
			return apiRequest.getREQUEST_OUTPUT();
		}
		
		if (!jsonObj.has("companystatus_ID") && !jsonObj.isNull("companystatus_ID")) {
			apiRequest = tableDataLogs.errorDataLog(apiRequest, "company", "Companystatus ID is missing");
			apirequestdatalogRepository.saveAndFlush(apiRequest);
			return apiRequest.getREQUEST_OUTPUT();
		}

		if (!jsonObj.has("start_DATE") && !jsonObj.isNull("start_DATE")) {
			apiRequest = tableDataLogs.errorDataLog(apiRequest, "company", "Company start DATE is missing");
			apirequestdatalogRepository.saveAndFlush(apiRequest);
			return apiRequest.getREQUEST_OUTPUT();
		}
		
		if (jsonObj.has("company_NUMBER") && !jsonObj.isNull("company_NUMBER")) 
			company.setCOMPANY_NUMBER(jsonObj.getString("company_NUMBER"));
		
		if (jsonObj.has("company_DESC") && !jsonObj.isNull("company_DESC"))
			company.setCOMPANY_DESC(jsonObj.getString("company_DESC"));	
		
		if (jsonObj.has("end_DATE") && !jsonObj.isNull("end_DATE"))
			company.setEND_DATE(jsonObj.getString("end_DATE"));
		
		if (jsonObj.has("companyparent_ID") && !jsonObj.isNull("companyparent_ID"))
			company.setCOMPANYPARENT_ID(jsonObj.getLong("companyparent_ID"));
		
		if (jsonObj.has("address_LINE1") && !jsonObj.isNull("address_LINE1"))
			company.setADDRESS_LINE1(jsonObj.getString("address_LINE1"));
		
		if (jsonObj.has("address_LINE2") && !jsonObj.isNull("address_LINE2"))
			company.setADDRESS_LINE2(jsonObj.getString("address_LINE2"));
		
		if (jsonObj.has("address_LINE3") && !jsonObj.isNull("address_LINE3"))
			company.setADDRESS_LINE3(jsonObj.getString("address_LINE3"));
		
		if (jsonObj.has("address_LINE4") && !jsonObj.isNull("address_LINE4"))
			company.setADDRESS_LINE4(jsonObj.getString("address_LINE4"));
		
		if (jsonObj.has("address_LINE5") && !jsonObj.isNull("address_LINE5"))
			company.setADDRESS_LINE5(jsonObj.getString("address_LINE5"));
		
		if (jsonObj.has("address_POSTCODE") && !jsonObj.isNull("address_POSTCODE"))
			company.setADDRESS_POSTCODE(jsonObj.getString("address_POSTCODE"));
		
		if (jsonObj.has("location_ID") && !jsonObj.isNull("location_ID"))
			company.setLOCATION_ID(jsonObj.getLong("location_ID"));
		
		if (jsonObj.has("companylogo_PATH") && !jsonObj.isNull("companylogo_PATH"))
			company.setCOMPANYLOGO_PATH(jsonObj.getString("companylogo_PATH"));
		
		company.setCOMPANY_NAME(jsonObj.getString("company_NAME"));
		company.setCOMPANYSUBTYPE_ID(companysubtyperepository.findOne(jsonObj.getLong("companysubtype_ID")));
		company.setBUSINESSNATURE_ID(lookuprepository.findOne(jsonObj.getLong("businessnature_ID")));
		company.setCOMPANYSTATUS_ID(lookuprepository.findOne(jsonObj.getLong("companystatus_ID")));
		company.setSTART_DATE(jsonObj.getString("start_DATE"));	
		company.setISACTIVE("Y");
		company.setMODIFIED_BY(requestUser);
		company.setMODIFIED_WORKSTATION(workstation);
		company.setMODIFIED_WHEN(dateFormat1.format(date));
		company = companyrepository.saveAndFlush(company);
		rtn = mapper.writeValueAsString(company);

		tbldatalogrepository
				.saveAndFlush(tableDataLogs.TableSaveDataLog(company.getCOMPANY_ID(), databaseTableID, requestUser, rtn));

		apiRequest.setREQUEST_OUTPUT(rtn);
		apiRequest.setREQUEST_STATUS("Success");
		apirequestdatalogRepository.saveAndFlush(apiRequest);

		log.info("Output: " + rtn);
		log.info("--------------------------------------------------------");

		return rtn;

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String update(@PathVariable Long id, @RequestBody String data,@RequestHeader(value = "Authorization") String headToken)
			throws JsonProcessingException, JSONException, ParseException {
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MMM/YYYY HH:mm:ss");
		Date date = new Date();
		ObjectMapper mapper = new ObjectMapper();
		
		log.info("PUT: /company/" + id);
		log.info("Input: " + data);

		JSONObject jsonObj = new JSONObject(data);
		Company company = companyrepository.findOne(id);
		String rtn, workstation = null;
		
		Long requestUser;
		requestUser = (long) 0;

		if (jsonObj.has("workstation"))
			workstation = jsonObj.getString("workstation");

		DatabaseTables databaseTableID = databasetablesrepository.findOne(Company.getDatabaseTableID());
		APIRequestDataLog apiRequest = tableDataLogs.apiRequestDataLog("PUT", databaseTableID, requestUser, "/company", data,
				workstation);

		if (jsonObj.has("company_NAME") && !jsonObj.isNull("company_NAME"))
			company.setCOMPANY_NAME(jsonObj.getString("company_NAME"));
		
		if (jsonObj.has("companysubtype_ID") && !jsonObj.isNull("companysubtype_ID"))
		company.setCOMPANYSUBTYPE_ID(companysubtyperepository.findOne(jsonObj.getLong("companysubtype_ID")));
		
		if (jsonObj.has("businessnature_ID") && !jsonObj.isNull("businessnature_ID"))
		company.setBUSINESSNATURE_ID(lookuprepository.findOne(jsonObj.getLong("businessnature_ID")));
		
		if (jsonObj.has("companystatus_ID") && !jsonObj.isNull("companystatus_ID"))
		company.setCOMPANYSTATUS_ID(lookuprepository.findOne(jsonObj.getLong("companystatus_ID")));
		
		if (jsonObj.has("start_DATE") && !jsonObj.isNull("start_DATE"))
			company.setSTART_DATE(jsonObj.getString("start_DATE"));
		
		if (jsonObj.has("company_NUMBER") && !jsonObj.isNull("company_NUMBER")) 
			company.setCOMPANY_NUMBER(jsonObj.getString("company_NUMBER"));
		
		if (jsonObj.has("company_DESC") && !jsonObj.isNull("company_DESC"))
			company.setCOMPANY_DESC(jsonObj.getString("company_DESC"));	
		
		if (jsonObj.has("end_DATE") && !jsonObj.isNull("end_DATE"))
			company.setEND_DATE(jsonObj.getString("end_DATE"));
		
		if (jsonObj.has("companyparent_ID") && !jsonObj.isNull("companyparent_ID"))
			company.setCOMPANYPARENT_ID(jsonObj.getLong("companyparent_ID"));
		
		if (jsonObj.has("address_LINE1") && !jsonObj.isNull("address_LINE1"))
			company.setADDRESS_LINE1(jsonObj.getString("address_LINE1"));
		
		if (jsonObj.has("address_LINE2") && !jsonObj.isNull("address_LINE2"))
			company.setADDRESS_LINE2(jsonObj.getString("address_LINE2"));
		
		if (jsonObj.has("address_LINE3") && !jsonObj.isNull("address_LINE3"))
			company.setADDRESS_LINE3(jsonObj.getString("address_LINE3"));
		
		if (jsonObj.has("address_LINE4") && !jsonObj.isNull("address_LINE4"))
			company.setADDRESS_LINE4(jsonObj.getString("address_LINE4"));
		
		if (jsonObj.has("address_LINE5") && !jsonObj.isNull("address_LINE5"))
			company.setADDRESS_LINE5(jsonObj.getString("address_LINE5"));
		
		if (jsonObj.has("address_POSTCODE") && !jsonObj.isNull("address_POSTCODE"))
			company.setADDRESS_POSTCODE(jsonObj.getString("address_POSTCODE"));
		
		if (jsonObj.has("location_ID") && !jsonObj.isNull("location_ID"))
			company.setLOCATION_ID(jsonObj.getLong("location_ID"));
		
		if (jsonObj.has("companylogo_PATH") && !jsonObj.isNull("companylogo_PATH"))
			company.setCOMPANYLOGO_PATH(jsonObj.getString("companylogo_PATH"));
		
		if (jsonObj.has("isactive") && !jsonObj.isNull("isactive"))
			company.setISACTIVE(jsonObj.getString("isactive"));

		company.setMODIFIED_BY(requestUser);
		company.setMODIFIED_WORKSTATION(workstation);
		company.setMODIFIED_WHEN(dateFormat1.format(date));
		company = companyrepository.saveAndFlush(company);
		rtn = mapper.writeValueAsString(company);

		tbldatalogrepository.saveAndFlush(
				tableDataLogs.TableSaveDataLog(company.getCOMPANY_ID(), databaseTableID, requestUser, rtn));

		apiRequest.setREQUEST_OUTPUT(rtn);
		apiRequest.setREQUEST_STATUS("Success");
		apirequestdatalogRepository.saveAndFlush(apiRequest);

		log.info("Output: " + rtn);
		log.info("--------------------------------------------------------");

		return rtn;
	}

	@RequestMapping(method = RequestMethod.PUT)
	public String updateAll(@RequestBody String data,@RequestHeader(value = "Authorization") String headToken)
			throws JsonProcessingException, JSONException, ParseException {
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MMM/YYYY HH:mm:ss");
		Date date = new Date();
		ObjectMapper mapper = new ObjectMapper();
		Long requestUser;

		log.info("PUT: /salescompany");
		log.info("Input: " + data);

		JSONArray jsonPAV = new JSONArray(data);
		List<Company> companys = new ArrayList<Company>();
		String rtn, workstation = null;

        requestUser = (long) 0;
		
		DatabaseTables databaseTableID = databasetablesrepository.findOne(Company.getDatabaseTableID());
		APIRequestDataLog apiRequest = tableDataLogs.apiRequestDataLog("PUT", databaseTableID, requestUser, "/salescompany",
				data, workstation);

		for (int i=0; i<jsonPAV.length(); i++) {
			JSONObject jsonObj = jsonPAV.getJSONObject(i);
			Company company = new  Company();
			long id=0; 
			
			if (jsonObj.has("company_ID")) {
				id = jsonObj.getLong("company_ID");
				if (id!=0)
					company = companyrepository.findOne(id);
			}
			
			if (id==0) {
				if (!jsonObj.has("company_NAME") && !jsonObj.isNull("company_NAME")) {
					apiRequest = tableDataLogs.errorDataLog(apiRequest, "company", "Company Name is missing");
					apirequestdatalogRepository.saveAndFlush(apiRequest);
					id = -1;
				}
				
				if (!jsonObj.has("companysubtype_ID") && !jsonObj.isNull("companysubtype_ID")) {
					apiRequest = tableDataLogs.errorDataLog(apiRequest, "company", "Companysubtype ID is missing");
					apirequestdatalogRepository.saveAndFlush(apiRequest);
					id = -1;
				}
				
				if (!jsonObj.has("businessnature_ID") && !jsonObj.isNull("businessnature_ID")) {
					apiRequest = tableDataLogs.errorDataLog(apiRequest, "company", "Companybusinessnature ID is missing");
					apirequestdatalogRepository.saveAndFlush(apiRequest);
					id = -1;
				}
				
				if (!jsonObj.has("companystatus_ID") && !jsonObj.isNull("companystatus_ID")) {
					apiRequest = tableDataLogs.errorDataLog(apiRequest, "company", "Companystatus ID is missing");
					apirequestdatalogRepository.saveAndFlush(apiRequest);
					id = -1;
				}

				if (!jsonObj.has("start_DATE") && !jsonObj.isNull("start_DATE")) {
					apiRequest = tableDataLogs.errorDataLog(apiRequest, "company", "Company start DATE is missing");
					apirequestdatalogRepository.saveAndFlush(apiRequest);
					id = -1;
				}
			}

			if (id!=-1) {
				if (jsonObj.has("company_NAME") && !jsonObj.isNull("company_NAME"))
					company.setCOMPANY_NAME(jsonObj.getString("company_NAME"));
				
				if (jsonObj.has("companysubtype_ID") && !jsonObj.isNull("companysubtype_ID"))
				company.setCOMPANYSUBTYPE_ID(companysubtyperepository.findOne(jsonObj.getLong("companysubtype_ID")));
				
				if (jsonObj.has("businessnature_ID") && !jsonObj.isNull("businessnature_ID"))
				company.setBUSINESSNATURE_ID(lookuprepository.findOne(jsonObj.getLong("businessnature_ID")));
				
				if (jsonObj.has("companystatus_ID") && !jsonObj.isNull("companystatus_ID"))
				company.setCOMPANYSTATUS_ID(lookuprepository.findOne(jsonObj.getLong("companystatus_ID")));
				
				if (jsonObj.has("start_DATE") && !jsonObj.isNull("start_DATE"))
					company.setSTART_DATE(jsonObj.getString("start_DATE"));
				
				if (jsonObj.has("company_NUMBER") && !jsonObj.isNull("company_NUMBER")) 
					company.setCOMPANY_NUMBER(jsonObj.getString("company_NUMBER"));
				
				if (jsonObj.has("company_DESC") && !jsonObj.isNull("company_DESC"))
					company.setCOMPANY_DESC(jsonObj.getString("company_DESC"));	
				
				if (jsonObj.has("end_DATE") && !jsonObj.isNull("end_DATE"))
					company.setEND_DATE(jsonObj.getString("end_DATE"));
				
				if (jsonObj.has("companyparent_ID") && !jsonObj.isNull("companyparent_ID"))
					company.setCOMPANYPARENT_ID(jsonObj.getLong("companyparent_ID"));
				
				if (jsonObj.has("address_LINE1") && !jsonObj.isNull("address_LINE1"))
					company.setADDRESS_LINE1(jsonObj.getString("address_LINE1"));
				
				if (jsonObj.has("address_LINE2") && !jsonObj.isNull("address_LINE2"))
					company.setADDRESS_LINE2(jsonObj.getString("address_LINE2"));
				
				if (jsonObj.has("address_LINE3") && !jsonObj.isNull("address_LINE3"))
					company.setADDRESS_LINE3(jsonObj.getString("address_LINE3"));
				
				if (jsonObj.has("address_LINE4") && !jsonObj.isNull("address_LINE4"))
					company.setADDRESS_LINE4(jsonObj.getString("address_LINE4"));
				
				if (jsonObj.has("address_LINE5") && !jsonObj.isNull("address_LINE5"))
					company.setADDRESS_LINE5(jsonObj.getString("address_LINE5"));
				
				if (jsonObj.has("address_POSTCODE") && !jsonObj.isNull("address_POSTCODE"))
					company.setADDRESS_POSTCODE(jsonObj.getString("address_POSTCODE"));
				
				if (jsonObj.has("location_ID") && !jsonObj.isNull("location_ID"))
					company.setLOCATION_ID(jsonObj.getLong("location_ID"));
				
				if (jsonObj.has("companylogo_PATH") && !jsonObj.isNull("companylogo_PATH"))
					company.setCOMPANYLOGO_PATH(jsonObj.getString("companylogo_PATH"));
				
				if (jsonObj.has("isactive"))
					company.setISACTIVE(jsonObj.getString("isactive"));

				company.setMODIFIED_BY(requestUser);
				company.setMODIFIED_WORKSTATION(workstation);
				company.setMODIFIED_WHEN(dateFormat1.format(date));
				company = companyrepository.saveAndFlush(company);
				if (jsonObj.has("isactive"))
					company.setISACTIVE(jsonObj.getString("isactive"));
				else
					company.setISACTIVE("Y");

				company.setMODIFIED_BY(requestUser);
				company.setMODIFIED_WORKSTATION(workstation);
				company.setMODIFIED_WHEN(dateFormat1.format(date));
				company = companyrepository.saveAndFlush(company);
				
				rtn = mapper.writeValueAsString(companys);
				tbldatalogrepository.saveAndFlush(
						tableDataLogs.TableSaveDataLog(company.getCOMPANY_ID(), databaseTableID, requestUser, rtn));

				companys.add(company);
			}
			
		}
		
		rtn = mapper.writeValueAsString(companys);

		apiRequest.setREQUEST_OUTPUT(rtn);
		apiRequest.setREQUEST_STATUS("Success");
		apirequestdatalogRepository.saveAndFlush(apiRequest);

		log.info("Output: " + rtn);
		log.info("--------------------------------------------------------");

		return rtn;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Long id,@RequestHeader(value = "Authorization") String headToken) throws JsonProcessingException, JSONException, ParseException {
		ObjectMapper mapper = new ObjectMapper();
		log.info("DELETE: /company/" + id);

		Company company = companyrepository.findOne(id);
		String rtn, workstation = null;

		Long requestUser;
		requestUser = (long) 0;
		
		DatabaseTables databaseTableID = databasetablesrepository.findOne(Company.getDatabaseTableID());
		APIRequestDataLog apiRequest = tableDataLogs.apiRequestDataLog("DELETE", databaseTableID, requestUser, "/company", null,
				workstation);

		companyrepository.delete(company);
		rtn = mapper.writeValueAsString(company);

		tbldatalogrepository.saveAndFlush(
				tableDataLogs.TableSaveDataLog(company.getCOMPANY_ID(), databaseTableID, requestUser, rtn));

		apiRequest.setREQUEST_OUTPUT(rtn);
		apiRequest.setREQUEST_STATUS("Success");
		apirequestdatalogRepository.saveAndFlush(apiRequest);

		log.info("Output: " + rtn);
		log.info("--------------------------------------------------------");

		return rtn;
	}

	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
	public String remove(@PathVariable Long id,@RequestHeader(value = "Authorization") String headToken) throws JsonProcessingException, JSONException, ParseException {
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MMM/YYYY HH:mm:ss");
		Date date = new Date();

		ObjectMapper mapper = new ObjectMapper();
		
		log.info("GET: /company/" + id + "/remove");

		Company company = companyrepository.findOne(id);
		String rtn, workstation = null;

		
		
		Long requestUser;
		requestUser = (long)0;
		
		DatabaseTables databaseTableID = databasetablesrepository.findOne(Company.getDatabaseTableID());
		APIRequestDataLog apiRequest = tableDataLogs.apiRequestDataLog("GET", databaseTableID, requestUser,
				"/company" + id + "/remove", "", workstation);
		company.setISACTIVE("N");
		company.setMODIFIED_BY(requestUser);
		company.setMODIFIED_WORKSTATION(workstation);
		company.setMODIFIED_WHEN(dateFormat1.format(date));
		company = companyrepository.saveAndFlush(company);
		rtn = mapper.writeValueAsString(company);
		tbldatalogrepository
				.saveAndFlush(tableDataLogs.TableSaveDataLog(company.getCOMPANY_ID(), databaseTableID, requestUser, rtn));

		apiRequest.setREQUEST_OUTPUT(rtn);
		apiRequest.setREQUEST_STATUS("Success");
		apirequestdatalogRepository.saveAndFlush(apiRequest);

		log.info("Output: " + rtn);
		log.info("--------------------------------------------------------");

		return rtn;
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String getBySearch(@RequestBody String data,@RequestHeader(value = "Authorization") String headToken) throws JsonProcessingException {
		return BySearch(data, true, headToken);

	}

	@RequestMapping(value = "/search/all", method = RequestMethod.POST)
	public String getAllBySearch(@RequestBody String data,@RequestHeader(value = "Authorization") String headToken) throws JsonProcessingException {
		return BySearch(data, false, headToken);

	}

	public String BySearch(String data, boolean active, String headToken) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		
		log.info("POST: company/search" + ((active == true) ? "" : "/all"));
		log.info("Input: " + data);

		JSONObject jsonObj = new JSONObject(data);
		String rtn = null, workstation = null;

		List<Company> company = ((active == true)
				? companyrepository.findBySearch("%" + jsonObj.getString("search") + "%")
				: companyrepository.findAllBySearch("%" + jsonObj.getString("search") + "%"));
		
		Long requestUser;
		requestUser = (long)0;

		DatabaseTables databaseTableID = databasetablesrepository.findOne(Company.getDatabaseTableID());
		APIRequestDataLog apiRequest = tableDataLogs.apiRequestDataLog("POST", databaseTableID, requestUser,
				"/company/search" + ((active == true) ? "" : "/all"), null, workstation);

		rtn = mapper.writeValueAsString(company);

		apiRequest.setREQUEST_OUTPUT(rtn);
		apiRequest.setREQUEST_STATUS("Success");
		apirequestdatalogRepository.saveAndFlush(apiRequest);

		log.info("Output: " + rtn);
		log.info("--------------------------------------------------------");

		return rtn;

	}

	@RequestMapping(value = "/advancedsearch", method = RequestMethod.POST)
	public String getByAdvancedSearch(@RequestBody String data,@RequestHeader(value = "Authorization") String headToken) throws JsonProcessingException {
		return ByAdvancedSearch(data, true, headToken);
	}

	@RequestMapping(value = "/advancedsearch/all", method = RequestMethod.POST)
	public String getAllByAdvancedSearch(@RequestBody String data,@RequestHeader(value = "Authorization") String headToken) throws JsonProcessingException {
		return ByAdvancedSearch(data, false, headToken);
	}

	public String ByAdvancedSearch(String data, boolean active, String headToken) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		
		log.info("POST: company/search" + ((active == true) ? "" : "/all"));
		log.info("Input: " + data);

		JSONObject jsonObj = new JSONObject(data);
		long companysubtype_ID = 0, companyparent_ID = 0,companystatus_ID = 0,businessnature_ID = 0;

		if (jsonObj.has("companysubtype_ID"))
			companysubtype_ID = jsonObj.getLong("companysubtype_ID");
		
		if (jsonObj.has("companyparent_ID"))
			companyparent_ID = jsonObj.getLong("companyparent_ID");

		if (jsonObj.has("companystatus_ID"))
			companystatus_ID = jsonObj.getLong("companystatus_ID");

		if (jsonObj.has("businessnature_ID"))
			businessnature_ID = jsonObj.getLong("businessnature_ID");

		List<Company> company = ((active == true)
				? companyrepository.findByAdvancedSearch(companysubtype_ID,companyparent_ID,companystatus_ID,businessnature_ID)
				: companyrepository.findAllByAdvancedSearch(companysubtype_ID,companyparent_ID,companystatus_ID,businessnature_ID));
		String rtn, workstation = null;

		Long requestUser;
		requestUser = (long)0;
		
		DatabaseTables databaseTableID = databasetablesrepository.findOne(Company.getDatabaseTableID());
		APIRequestDataLog apiRequest = tableDataLogs.apiRequestDataLog("POST", databaseTableID, requestUser,
				"/company/advancedsearch" + ((active == true) ? "" : "/all"), data, workstation);

		rtn = mapper.writeValueAsString(company);

		apiRequest.setREQUEST_OUTPUT(rtn);
		apiRequest.setREQUEST_STATUS("Success");
		apirequestdatalogRepository.saveAndFlush(apiRequest);

		log.info("Output: " + rtn);
		log.info("--------------------------------------------------------");

		return rtn;
	}


}
