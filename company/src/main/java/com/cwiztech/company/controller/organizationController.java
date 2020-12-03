package com.cwiztech.company.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

import com.cwiztech.company.model.Organization;
import com.cwiztech.company.repository.organizationRepository;
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
@RequestMapping("/organization")
public class organizationController {
	
	private static final Logger log = LoggerFactory.getLogger(organizationController.class);

	@Autowired
	private organizationRepository organizationrepository;
	
	@Autowired
	private lookupRepository lookuprepository;

	//@Autowired
	//private loginUserRepository loginuserrepository;
	
	@Autowired
	private apiRequestDataLogRepository apirequestdatalogRepository;
	
	@Autowired
	private tableDataLogRepository tbldatalogrepository;

	@Autowired
	private databaseTablesRepository databasetablesrepository;
		
	@RequestMapping(method = RequestMethod.GET)
	public String get(@RequestHeader(value = "Authorization") String headToken) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		log.info("GET: /organization");

		List<Organization> organization =organizationrepository.findActive();
		String rtn, workstation = null;
		
		Long requestUser;
		requestUser = (long) 0;
		

		DatabaseTables databaseTableID = databasetablesrepository.findOne(Organization.getDatabaseTableID());
		APIRequestDataLog apiRequest = tableDataLogs.apiRequestDataLog("GET", databaseTableID, requestUser, "/organization", null,
				workstation);

		rtn = mapper.writeValueAsString( organization);

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
		log.info("GET: /organization/" + id);

		Organization organization =organizationrepository.findOne(id);
		String rtn, workstation = null;

		Long requestUser;
		requestUser = (long) 0;
		
		DatabaseTables databaseTableID = databasetablesrepository.findOne(Organization.getDatabaseTableID());
		APIRequestDataLog apiRequest = tableDataLogs.apiRequestDataLog("GET", databaseTableID, requestUser, "/organization/" + id,
				null, workstation);

		rtn = mapper.writeValueAsString( organization);

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
		log.info("GET: /organization/all");

		List<Organization> organization =organizationrepository.findAll();
		String rtn, workstation = null;
		
		Long requestUser;
		requestUser = (long) 0;
		

		DatabaseTables databaseTableID = databasetablesrepository.findOne(Organization.getDatabaseTableID());
		APIRequestDataLog apiRequest = tableDataLogs.apiRequestDataLog("GET", databaseTableID, requestUser,
				"/organization/all", null, workstation);

		rtn = mapper.writeValueAsString( organization);

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
		

		log.info("POST: /organization");
		log.info("Input: " + data);

		JSONObject jsonObj = new JSONObject(data);
		Organization  organization = new Organization();
		String rtn, workstation = null;
		
		Long requestUser;
		requestUser = (long) 0;
		

		DatabaseTables databaseTableID = databasetablesrepository.findOne(Organization.getDatabaseTableID());
		
		if (jsonObj.has("workstation"))
			workstation = jsonObj.getString("workstation");
		APIRequestDataLog apiRequest = tableDataLogs.apiRequestDataLog("POST", databaseTableID, requestUser, "/organization", data,
				workstation);

		if (!jsonObj.has("organization_NAME")) {
			apiRequest = tableDataLogs.errorDataLog(apiRequest, " organization", "Organization Name is missing");
			apirequestdatalogRepository.saveAndFlush(apiRequest);
			return apiRequest.getREQUEST_OUTPUT();
		}

		if (!jsonObj.has("organizationtype_ID")) {
			apiRequest = tableDataLogs.errorDataLog(apiRequest, " organization", "OrganizationType ID is missing");
			apirequestdatalogRepository.saveAndFlush(apiRequest);
			return apiRequest.getREQUEST_OUTPUT();
		}

		if (jsonObj.has("organization_DESC"))
			 organization.setORGANIZATION_DESC(jsonObj.getString("organization_DESC"));
		
		 organization.setORGANIZATION_NAME(jsonObj.getString("organization_NAME"));
		 organization.setORGANIZATIONTYPE_ID(lookuprepository.findOne(jsonObj.getLong("organizationtype_ID")));
		 organization.setISACTIVE("Y");
		 organization.setMODIFIED_BY(requestUser);
		 organization.setMODIFIED_WORKSTATION(workstation);
		 organization.setMODIFIED_WHEN(dateFormat1.format(date));
		 organization =organizationrepository.saveAndFlush( organization);
		rtn = mapper.writeValueAsString( organization);

		tbldatalogrepository
				.saveAndFlush(tableDataLogs.TableSaveDataLog( organization.getORGANIZATION_ID(), databaseTableID, requestUser, rtn));

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
		
		log.info("PUT: /organization/" + id);
		log.info("Input: " + data);

		JSONObject jsonObj = new JSONObject(data);
		Organization  organization =organizationrepository.findOne(id);
		String rtn, workstation = null;
		
		Long requestUser;
		requestUser = (long) 0;
		
		if (jsonObj.has("workstation"))
			workstation = jsonObj.getString("workstation");

		DatabaseTables databaseTableID = databasetablesrepository.findOne(Organization.getDatabaseTableID());
		APIRequestDataLog apiRequest = tableDataLogs.apiRequestDataLog("PUT", databaseTableID, requestUser, "/organization", data,
				workstation);

		if (jsonObj.has("organization_NAME") && !jsonObj.isNull("organization_NAME"))
			 organization.setORGANIZATION_NAME(jsonObj.getString("organization_NAME"));
		
		if (jsonObj.has("organization_DESC") && !jsonObj.isNull("organization_DESC"))
			 organization.setORGANIZATION_DESC(jsonObj.getString("organization_DESC"));
		
		if (jsonObj.has("organizationtype_ID") && !jsonObj.isNull("organizationtype_ID"))
			 organization.setORGANIZATIONTYPE_ID(lookuprepository.findOne(jsonObj.getLong("organizationtype_ID")));
		
		if (jsonObj.has("isactive"))
			 organization.setISACTIVE(jsonObj.getString("isactive"));

		 organization.setMODIFIED_BY(requestUser);
		 organization.setMODIFIED_WORKSTATION(workstation);
		 organization.setMODIFIED_WHEN(dateFormat1.format(date));
		 organization =organizationrepository.saveAndFlush( organization);
		rtn = mapper.writeValueAsString( organization);

		tbldatalogrepository.saveAndFlush(
				tableDataLogs.TableSaveDataLog( organization.getORGANIZATION_ID(), databaseTableID, requestUser, rtn));

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
		log.info("DELETE: /organization/" + id);

		Organization  organization =organizationrepository.findOne(id);
		String rtn, workstation = null;

		Long requestUser;
		requestUser = (long) 0;
		
		
		DatabaseTables databaseTableID = databasetablesrepository.findOne(Organization.getDatabaseTableID());
		APIRequestDataLog apiRequest = tableDataLogs.apiRequestDataLog("DELETE", databaseTableID, requestUser, "/organization", null,
				workstation);

		organizationrepository.delete(organization);
		rtn = mapper.writeValueAsString(organization);

		tbldatalogrepository.saveAndFlush(
				tableDataLogs.TableSaveDataLog( organization.getORGANIZATION_ID(), databaseTableID, requestUser, rtn));

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
		
		log.info("GET: /organization/" + id + "/remove");

		Organization  organization =organizationrepository.findOne(id);
		String rtn, workstation = null;

		Long requestUser;
		requestUser = (long) 0;
		
		
		DatabaseTables databaseTableID = databasetablesrepository.findOne(Organization.getDatabaseTableID());
		APIRequestDataLog apiRequest = tableDataLogs.apiRequestDataLog("GET", databaseTableID, requestUser,
				"/organization" + id + "/remove", "", workstation);
		 organization.setISACTIVE("N");
		 organization.setMODIFIED_BY(requestUser);
		 organization.setMODIFIED_WORKSTATION(workstation);
		 organization.setMODIFIED_WHEN(dateFormat1.format(date));
		 organization =organizationrepository.saveAndFlush( organization);
		rtn = mapper.writeValueAsString( organization);
		tbldatalogrepository
				.saveAndFlush(tableDataLogs.TableSaveDataLog( organization.getORGANIZATION_ID(), databaseTableID, requestUser, rtn));

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
		
		log.info("POST: organization/search" + ((active == true) ? "" : "/all"));
		log.info("Input: " + data);

		JSONObject jsonObj = new JSONObject(data);
		String rtn = null, workstation = null;

		List<Organization> organization = ((active == true)
				?organizationrepository.findBySearch("%" + jsonObj.getString("search") + "%")
				:organizationrepository.findAllBySearch("%" + jsonObj.getString("search") + "%"));
		
		Long requestUser;
		requestUser = (long) 0;
		

		DatabaseTables databaseTableID = databasetablesrepository.findOne(Organization.getDatabaseTableID());
		APIRequestDataLog apiRequest = tableDataLogs.apiRequestDataLog("POST", databaseTableID, requestUser,
				"/organization/search" + ((active == true) ? "" : "/all"), null, workstation);

		rtn = mapper.writeValueAsString( organization);

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
		
		log.info("POST: organization/search" + ((active == true) ? "" : "/all"));
		log.info("Input: " + data);

		JSONObject jsonObj = new JSONObject(data);
		long organizationtype_ID = 0;

		if (jsonObj.has("organizationtype_ID"))
			organizationtype_ID = jsonObj.getLong("organizationtype_ID");

		List<Organization> organization = ((active == true)
				?organizationrepository.findByAdvancedSearch(organizationtype_ID)
				:organizationrepository.findAllByAdvancedSearch(organizationtype_ID));
		String rtn, workstation = null;

		Long requestUser;
		requestUser = (long) 0;
		
		
		DatabaseTables databaseTableID = databasetablesrepository.findOne(Organization.getDatabaseTableID());
		APIRequestDataLog apiRequest = tableDataLogs.apiRequestDataLog("POST", databaseTableID, requestUser,
				"/organization/advancedsearch" + ((active == true) ? "" : "/all"), data, workstation);

		rtn = mapper.writeValueAsString( organization);

		apiRequest.setREQUEST_OUTPUT(rtn);
		apiRequest.setREQUEST_STATUS("Success");
		apirequestdatalogRepository.saveAndFlush(apiRequest);

		log.info("Output: " + rtn);
		log.info("--------------------------------------------------------");

		return rtn;
	}


}
