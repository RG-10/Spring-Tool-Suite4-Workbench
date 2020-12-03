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

import com.cwiztech.company.model.CompanySubtype;
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
@RequestMapping("/companysubtype")
public class companySubtypeController {
	
	private static final Logger log = LoggerFactory.getLogger(companySubtypeController.class);

	@Autowired
	private companySubtypeRepository companysubtyperepository;
	
	@Autowired
	private lookupRepository lookuprepository;


	
	@Autowired
	private apiRequestDataLogRepository apirequestdatalogRepository;
	
	@Autowired
	private tableDataLogRepository tbldatalogrepository;

	@Autowired
	private databaseTablesRepository databasetablesrepository;
		
	@RequestMapping(method = RequestMethod.GET)
	public String get(@RequestHeader(value = "Authorization") String headToken) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		log.info("GET: /companysubtype");

		List<CompanySubtype>companysubtype =companysubtyperepository.findActive();
		String rtn, workstation = null;
		
		Long requestUser;
		requestUser = (long) 0;

		DatabaseTables databaseTableID = databasetablesrepository.findOne(CompanySubtype.getDatabaseTableID());
		APIRequestDataLog apiRequest = tableDataLogs.apiRequestDataLog("GET", databaseTableID, requestUser, "/companysubtype", null,
				workstation);

		rtn = mapper.writeValueAsString(companysubtype);

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
		log.info("GET: /companysubtype/" + id);

		CompanySubtype companysubtype =companysubtyperepository.findOne(id);
		String rtn, workstation = null;

		Long requestUser;
		requestUser = (long) 0;
		
		DatabaseTables databaseTableID = databasetablesrepository.findOne(CompanySubtype.getDatabaseTableID());
		APIRequestDataLog apiRequest = tableDataLogs.apiRequestDataLog("GET", databaseTableID, requestUser, "/companysubtype/" + id,
				null, workstation);

		rtn = mapper.writeValueAsString(companysubtype);

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
		log.info("GET: /companysubtype/all");

		List<CompanySubtype>companysubtype =companysubtyperepository.findAll();
		String rtn, workstation = null;
		
		Long requestUser;
		requestUser = (long) 0;

		DatabaseTables databaseTableID = databasetablesrepository.findOne(CompanySubtype.getDatabaseTableID());
		APIRequestDataLog apiRequest = tableDataLogs.apiRequestDataLog("GET", databaseTableID, requestUser,
				"/companysubtype/all", null, workstation);

		rtn = mapper.writeValueAsString(companysubtype);

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
		

		log.info("POST: /companysubtype");
		log.info("Input: " + data);

		JSONObject jsonObj = new JSONObject(data);
		CompanySubtype companysubtype = new CompanySubtype();
		String rtn, workstation = null;
		
		Long requestUser;
		requestUser = (long) 0;

		DatabaseTables databaseTableID = databasetablesrepository.findOne(CompanySubtype.getDatabaseTableID());
		
		if (jsonObj.has("workstation"))
			workstation = jsonObj.getString("workstation");
		APIRequestDataLog apiRequest = tableDataLogs.apiRequestDataLog("POST", databaseTableID, requestUser, "/companysubtype", data,
				workstation);

		if (!jsonObj.has("companytype_ID")) {
			apiRequest = tableDataLogs.errorDataLog(apiRequest, "companysubtype", "Companytype ID is missing");
			apirequestdatalogRepository.saveAndFlush(apiRequest);
			return apiRequest.getREQUEST_OUTPUT();
		}
		
		if (!jsonObj.has("companysubtype_NAME")) {
			apiRequest = tableDataLogs.errorDataLog(apiRequest, "companysubtype", "CompanySubtype Name is missing");
			apirequestdatalogRepository.saveAndFlush(apiRequest);
			return apiRequest.getREQUEST_OUTPUT();
		}

		companysubtype.setCOMPANYTYPE_ID(lookuprepository.findOne(jsonObj.getLong("companytype_ID")));
		companysubtype.setCOMPANYSUBTYPE_NAME(jsonObj.getString("companysubtype_NAME"));
		if (jsonObj.has("companysubtype_DESC"))
			companysubtype.setCOMPANYSUBTYPE_DESC(jsonObj.getString("companysubtype_DESC"));
		companysubtype.setISACTIVE("Y");
		companysubtype.setMODIFIED_BY(requestUser);
		companysubtype.setMODIFIED_WORKSTATION(workstation);
		companysubtype.setMODIFIED_WHEN(dateFormat1.format(date));
		companysubtype =companysubtyperepository.saveAndFlush(companysubtype);
		rtn = mapper.writeValueAsString(companysubtype);

		tbldatalogrepository
				.saveAndFlush(tableDataLogs.TableSaveDataLog(companysubtype.getCOMPANYSUBTYPE_ID(), databaseTableID, requestUser, rtn));

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
		
		log.info("PUT: /companysubtype/" + id);
		log.info("Input: " + data);

		JSONObject jsonObj = new JSONObject(data);
		CompanySubtype companysubtype =companysubtyperepository.findOne(id);
		String rtn, workstation = null;
		
		Long requestUser;
		requestUser = (long) 0;

		if (jsonObj.has("workstation"))
			workstation = jsonObj.getString("workstation");

		DatabaseTables databaseTableID = databasetablesrepository.findOne(CompanySubtype.getDatabaseTableID());
		APIRequestDataLog apiRequest = tableDataLogs.apiRequestDataLog("PUT", databaseTableID, requestUser, "/companysubtype", data,
				workstation);

		if (jsonObj.has("companytype_ID") && !jsonObj.isNull("companytype_ID"))
			companysubtype.setCOMPANYTYPE_ID(lookuprepository.findOne(jsonObj.getLong("companytype_ID")));
		
		if (jsonObj.has("company_NAME") && !jsonObj.isNull("company_NAME"))
			companysubtype.setCOMPANYSUBTYPE_NAME(jsonObj.getString("company_NAME"));
		
		if (jsonObj.has("company_DESC") && !jsonObj.isNull("company_DESC"))
			companysubtype.setCOMPANYSUBTYPE_DESC(jsonObj.getString("company_DESC"));
		
		if (jsonObj.has("isactive"))
			companysubtype.setISACTIVE(jsonObj.getString("isactive"));

		companysubtype.setMODIFIED_BY(requestUser);
		companysubtype.setMODIFIED_WORKSTATION(workstation);
		companysubtype.setMODIFIED_WHEN(dateFormat1.format(date));
		companysubtype =companysubtyperepository.saveAndFlush(companysubtype);
		rtn = mapper.writeValueAsString(companysubtype);

		tbldatalogrepository.saveAndFlush(
				tableDataLogs.TableSaveDataLog(companysubtype.getCOMPANYSUBTYPE_ID(), databaseTableID, requestUser, rtn));

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
		log.info("DELETE: /companysubtype/" + id);

		CompanySubtype companysubtype =companysubtyperepository.findOne(id);
		String rtn, workstation = null;

		Long requestUser;
		requestUser = (long) 0;
		
		DatabaseTables databaseTableID = databasetablesrepository.findOne(CompanySubtype.getDatabaseTableID());
		APIRequestDataLog apiRequest = tableDataLogs.apiRequestDataLog("DELETE", databaseTableID, requestUser, "/companysubtype", null,
				workstation);

		companysubtyperepository.delete(companysubtype);
		rtn = mapper.writeValueAsString(companysubtype);

		tbldatalogrepository.saveAndFlush(
				tableDataLogs.TableSaveDataLog(companysubtype.getCOMPANYSUBTYPE_ID(), databaseTableID, requestUser, rtn));

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
		
		log.info("GET: /companysubtype/" + id + "/remove");

		CompanySubtype companysubtype =companysubtyperepository.findOne(id);
		String rtn, workstation = null;

		Long requestUser;
		requestUser = (long) 0;
		
		DatabaseTables databaseTableID = databasetablesrepository.findOne(CompanySubtype.getDatabaseTableID());
		APIRequestDataLog apiRequest = tableDataLogs.apiRequestDataLog("GET", databaseTableID, requestUser,
				"/companysubtype" + id + "/remove", "", workstation);
		companysubtype.setISACTIVE("N");
		companysubtype.setMODIFIED_BY(requestUser);
		companysubtype.setMODIFIED_WORKSTATION(workstation);
		companysubtype.setMODIFIED_WHEN(dateFormat1.format(date));
		companysubtype =companysubtyperepository.saveAndFlush(companysubtype);
		rtn = mapper.writeValueAsString(companysubtype);
		tbldatalogrepository
				.saveAndFlush(tableDataLogs.TableSaveDataLog(companysubtype.getCOMPANYSUBTYPE_ID(), databaseTableID, requestUser, rtn));

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
		
		log.info("POST:companysubtype/search" + ((active == true) ? "" : "/all"));
		log.info("Input: " + data);

		JSONObject jsonObj = new JSONObject(data);
		String rtn = null, workstation = null;

		List<CompanySubtype>companysubtype = ((active == true)
				?companysubtyperepository.findBySearch("%" + jsonObj.getString("search") + "%")
				:companysubtyperepository.findAllBySearch("%" + jsonObj.getString("search") + "%"));
		
		Long requestUser;
		requestUser = (long) 0;

		DatabaseTables databaseTableID = databasetablesrepository.findOne(CompanySubtype.getDatabaseTableID());
		APIRequestDataLog apiRequest = tableDataLogs.apiRequestDataLog("POST", databaseTableID, requestUser,
				"/companysubtype/search" + ((active == true) ? "" : "/all"), null, workstation);

		rtn = mapper.writeValueAsString(companysubtype);

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
		
		log.info("POST:companysubtype/search" + ((active == true) ? "" : "/all"));
		log.info("Input: " + data);

		JSONObject jsonObj = new JSONObject(data);
		long companytype_ID = 0;

		if (jsonObj.has("companytype_ID"))
			companytype_ID = jsonObj.getLong("companytype_ID");

		List<CompanySubtype>companysubtype = ((active == true)
				?companysubtyperepository.findByAdvancedSearch(companytype_ID)
				:companysubtyperepository.findAllByAdvancedSearch(companytype_ID));
		String rtn, workstation = null;

		Long requestUser;
		requestUser = (long) 0;
		
		DatabaseTables databaseTableID = databasetablesrepository.findOne(CompanySubtype.getDatabaseTableID());
		APIRequestDataLog apiRequest = tableDataLogs.apiRequestDataLog("POST", databaseTableID, requestUser,
				"/companysubtype/advancedsearch" + ((active == true) ? "" : "/all"), data, workstation);

		rtn = mapper.writeValueAsString(companysubtype);

		apiRequest.setREQUEST_OUTPUT(rtn);
		apiRequest.setREQUEST_STATUS("Success");
		apirequestdatalogRepository.saveAndFlush(apiRequest);

		log.info("Output: " + rtn);
		log.info("--------------------------------------------------------");

		return rtn;
	}


}
