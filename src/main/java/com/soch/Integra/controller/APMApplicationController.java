package com.soch.Integra.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soch.Integra.dashboard.dto.DashboardAuditResponse;
import com.soch.Integra.dto.ALLReportDTO;
import com.soch.Integra.dto.AppAuditDTO;
import com.soch.Integra.dto.AppAuditFileDTO;
import com.soch.Integra.dto.AppDisp;
import com.soch.Integra.dto.ApplDocDTO;
import com.soch.Integra.dto.ApplicationDTO;
import com.soch.Integra.dto.ApplicationResp;
import com.soch.Integra.dto.ApplicationUserDTO;
import com.soch.Integra.dto.ApplicationUserResp;
import com.soch.Integra.dto.ApplicationViewDTO;
import com.soch.Integra.dto.AssessmentAuditDTO;
import com.soch.Integra.dto.AssessmentDTO;
import com.soch.Integra.dto.AssessmentPolicyDTO;
import com.soch.Integra.dto.AssessmentResponse;
import com.soch.Integra.dto.AuditDashBoardDTO;
import com.soch.Integra.dto.AuditPolicyDTO;
import com.soch.Integra.dto.AuditTypeDTO;
import com.soch.Integra.dto.AuditTypeDashBoardDTO;
import com.soch.Integra.dto.DashboardChartDTO;
import com.soch.Integra.dto.DatabaseDTO;
import com.soch.Integra.dto.DivisionDTO;
import com.soch.Integra.dto.FiscalYearInfoDTO;
import com.soch.Integra.dto.MOUDTO;
import com.soch.Integra.dto.OfficeDTO;
import com.soch.Integra.dto.PolicyDTO;
import com.soch.Integra.dto.PolicyDocumentsDTO;
import com.soch.Integra.dto.PolicyGrpDTO;
import com.soch.Integra.dto.PolicyResponse;
import com.soch.Integra.dto.PolicyReviewDTO;
import com.soch.Integra.dto.PolicyReviewTermDTO;
import com.soch.Integra.dto.PolicyTypeDTO;
import com.soch.Integra.dto.PrecinctTypeDTO;
import com.soch.Integra.dto.ReportDTO;
import com.soch.Integra.dto.ReportDTO2;

import com.soch.Integra.dto.ServerDTO;
import com.soch.Integra.dto.StatusDTO;
import com.soch.Integra.dto.SystemSensitivityDTO;
import com.soch.Integra.dto.TechnologiesDTO;
import com.soch.Integra.dto.UserAppRoleDTO;
import com.soch.Integra.dto.UserReportRequest;
import com.soch.Integra.dto.UserReportResponse;
import com.soch.Integra.dto.VendorsDTO;
import com.soch.Integra.history.dto.AppAuditHistoryDTO;
import com.soch.Integra.history.dto.ApplicationHistoryDTO;
import com.soch.Integra.service.AAMHistoryServices;
//import com.soch.Integra.dto.UserDTO;
import com.soch.Integra.service.APMApplicationService;
import com.soch.Integra.service.ElectionServices;
import com.soch.Integra.service.PolicyServices;
import com.soch.Integra.service.UserServices;
import com.soch.Integra.vendors.dto.AppSolutionDevicesDTO;
import com.soch.Integra.vendors.dto.ApplicationSolutionDTO;
import com.soch.Integra.vendors.dto.HostingTypeDTO;
import com.soch.Integra.vendors.dto.LabVendorsDTO;
import com.soch.Integra.vendors.dto.SolutionOnLoadResp;
import com.soch.Integra.vendors.dto.SolutionTypeDTO;
import com.soch.Integra.vendors.dto.SolutionTypeResp;
import com.soch.Integra.vendors.dto.SolutionsDTO;
import com.soch.Integra.vendors.dto.SolutionsResponse;
import com.soch.Integra.vendors.dto.SystemTypeDTO;
import com.soch.Integra.vendors.dto.VendorResponse;
import com.soch.Integra.vendors.dto.ReportVendorsDTO;
import com.soch.uam.dto.UserDTO;
import com.soch.uam.response.UAMUIResponse;
import com.soch.uam.response.UserSVCResp;

@Controller
public class APMApplicationController {

	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	org.springframework.core.env.Environment environment;
	
	@Autowired
	APMApplicationService apmApplicationService;
	
	@Autowired
	PolicyServices policyServices;
	
	@Autowired
	AAMHistoryServices aamHistoryServices;
	
	@Autowired
	UserServices userServices;
	
	@Autowired
	ElectionServices electionServices;
	
	
	 @RequestMapping(value="/signIn", method = RequestMethod.POST )
     @ResponseBody
  public UAMUIResponse signIn(@RequestBody  UserDTO user, HttpServletResponse ServRequest,
          HttpServletResponse  response)
     {
		       
		 
		 
		 MultiValueMap<String, Object> headers = new LinkedMultiValueMap<String, Object>();
             headers.add("Accept", "application/json");
             headers.add("Content-Type", "application/json");
             UAMUIResponse UAMUIResponse = new UAMUIResponse();
             
             user.setAppName("AAMApplication");
             String jsonObj = null;
             ObjectMapper mapper = new ObjectMapper();
             
             try {
                 jsonObj = mapper.writeValueAsString(user);
                 
            	 
           } catch (JsonProcessingException e) {
                 e.printStackTrace();
           }
             
             org.springframework.http.HttpEntity request = new org.springframework.http.HttpEntity(jsonObj, headers);
               RestTemplate restTemplate = new RestTemplate();
               UserSVCResp userSVCResp = restTemplate.postForObject(environment.getRequiredProperty("hostName")+"/UAMWebservices/signIn", request, UserSVCResp.class);
               UAMUIResponse.setResultCode(userSVCResp.getResultCode());
               UAMUIResponse.setresultString(userSVCResp.getresultString());
               if(userSVCResp.getUser() != null)
               {
                  //createCookie(response, userSVCResp.getUser().getToken(),userSVCResp.getUser().getUserId());
                  UAMUIResponse.setUser(userSVCResp.getUser());
               }
    
           return UAMUIResponse;
  }
	 
///////////////Reports///////////////////////
		
@RequestMapping(value="/getLocalityForView", method = RequestMethod.GET)
@ResponseBody
public List<ApplicationViewDTO> getLocalityForView(){
	List<ApplicationViewDTO> applicationViewDTOs = apmApplicationService.getLocationForView();
	
	return applicationViewDTOs;
}




////////////////////////////////////////////
	
	

	
	
	@RequestMapping(value="/getApplicationData", method = RequestMethod.GET)
	@ResponseBody
	public ApplicationResp getApplicationData(@RequestParam String acronym){
		ApplicationResp applicationResp = new ApplicationResp();
		ApplicationDTO applicationDTO = apmApplicationService.getApplicationInfo(acronym);
		if(applicationDTO != null)
		{
			applicationResp.setApplicationDTO(applicationDTO);
			applicationResp.setResponseCode(Integer.parseInt(messageSource.getMessage("APPLICATION.FOUND.CODE",null, Locale.getDefault())));
			applicationResp.setResponseString(messageSource.getMessage("APPLICATION.FOUND.STRING",null, Locale.getDefault()));
		}
		else
		{
			applicationResp.setResponseCode(Integer.parseInt(messageSource.getMessage("APPLICATION.NOTFOUND.CODE",null, Locale.getDefault())));
			applicationResp.setResponseString(messageSource.getMessage("APPLICATION.NOTFOUND.STRING",null, Locale.getDefault()));
		}
		return applicationResp;
    }
	
	@RequestMapping(value="/checkApplication", method = RequestMethod.GET)
	@ResponseBody
	public ApplicationResp checkApplication(@RequestParam String acronym){
		ApplicationResp applicationResp = new ApplicationResp();
		ApplicationDTO applicationDTO = apmApplicationService.getApplicationInfo(acronym);
		if(applicationDTO != null)
		{
			applicationResp.setResponseCode(Integer.parseInt(messageSource.getMessage("APPLICATION.FOUND.CODE",null, Locale.getDefault())));
			applicationResp.setResponseString(messageSource.getMessage("APPLICATION.FOUND.STRING",null, Locale.getDefault()));
		}
		else
		{
			applicationResp.setResponseCode(Integer.parseInt(messageSource.getMessage("APPLICATION.NOTFOUND.CODE",null, Locale.getDefault())));
			applicationResp.setResponseString(messageSource.getMessage("APPLICATION.NOTFOUND.STRING",null, Locale.getDefault()));
		}
		return applicationResp;
    }
	
	
	@RequestMapping(value="/getDivisions", method = RequestMethod.GET)
	@ResponseBody
	public Set<DivisionDTO> getDivsions(){
	//	ApplicationResp divsionResp = new ApplicationResp();
		Set<DivisionDTO> divisionDTOs = apmApplicationService.getDivisions();
		
		return divisionDTOs;
    }
	
	
	@RequestMapping(value="/getOffices", method = RequestMethod.GET)
	@ResponseBody
	public Set<OfficeDTO> getOffices(){
		Set<OfficeDTO> officeDTOs = apmApplicationService.getOffices();
		
		return officeDTOs;
    }
	
	
	@RequestMapping(value="/getOfficesOnDept", method = RequestMethod.GET)
	@ResponseBody
	public Set<OfficeDTO> getOfficesOnDept(@RequestParam Integer deptId){
		Set<OfficeDTO> officeDTOs = apmApplicationService.getOfficesOnDept(deptId);
		
		return officeDTOs;
    }
	
	
	@RequestMapping(value="/getOfficeAcronyms", method = RequestMethod.GET)
	@ResponseBody
	public  List<String> getOfficeAcronyms(){
		 List<String> officeAcronyms = apmApplicationService.getOfficeAcronyms();
		
		return officeAcronyms;
    }
	
	//getOfficeAcronyms

	@RequestMapping(value="/getDatabases", method = RequestMethod.GET)
	@ResponseBody
	public Set<DatabaseDTO> getDatabases(){
		Set<DatabaseDTO> databaseDTOs = apmApplicationService.getDatabase();
		
		return databaseDTOs;
    }
	
	@RequestMapping(value="/getServer", method = RequestMethod.GET)
	@ResponseBody
	public Set<ServerDTO> getServers(){
		Set<ServerDTO> serverDTOs = apmApplicationService.getServer();
		
		return serverDTOs;
    }
	
	@RequestMapping(value="/getUsers", method = RequestMethod.GET)
	@ResponseBody
	public Set<ApplicationUserDTO> getUsers(){
		Set<ApplicationUserDTO> userDTOs = apmApplicationService.getUsers();
		
		return userDTOs;
    }
	
	@RequestMapping(value="/getUseronName", method = RequestMethod.GET)
	@ResponseBody
	public Set<ApplicationUserDTO> getUseronName(@RequestParam String userName){
		Set<ApplicationUserDTO> userDTOs = apmApplicationService.getUseronName(userName);
		
		return userDTOs;
    }
	
	@RequestMapping(value="/getUser", method = RequestMethod.GET)
	@ResponseBody
	public ApplicationUserDTO getUser(@RequestParam Integer userId){
		ApplicationUserDTO userDTO = apmApplicationService.getUser(userId);
		
		return userDTO;
    }
	
	@RequestMapping(value="/getDataOwner", method = RequestMethod.GET)
	@ResponseBody
	public Set<ApplicationUserDTO> getDataOwner(){
		Set<ApplicationUserDTO> userDTOs = apmApplicationService.getDataOwner();
		
		return userDTOs;
    }
	
	@RequestMapping(value="/getBusinessOwner", method = RequestMethod.GET)
	@ResponseBody
	public Set<ApplicationUserDTO> getBusiness_Owner(){
		Set<ApplicationUserDTO> userDTOs = apmApplicationService.getBusiness_Owner();
		
		return userDTOs;
    }
	
	@RequestMapping(value="/getSystem_Site_Data_Owner", method = RequestMethod.GET)
	@ResponseBody
	public Set<ApplicationUserDTO> getSystem_Site_Data_Owner(){
		Set<ApplicationUserDTO> userDTOs = apmApplicationService.getSystem_Site_Data_Owner();
		
		return userDTOs;
    }
	
	@RequestMapping(value="/getSystemAdministrator", method = RequestMethod.GET)
	@ResponseBody
	public Set<ApplicationUserDTO> getSystemAdministrator(){
		Set<ApplicationUserDTO> userDTOs = apmApplicationService.getSystemAdministrator();
		
		return userDTOs;
    }
	
	
	@RequestMapping(value="/getDbAdmin", method = RequestMethod.GET)
	@ResponseBody
	public Set<ApplicationUserDTO> getDbAdmin(){
		Set<ApplicationUserDTO> userDTOs = apmApplicationService.getDbAdmin();
		
		return userDTOs;
    }
	
	@RequestMapping(value="/getTechProjectManager", method = RequestMethod.GET)
	@ResponseBody
	public Set<ApplicationUserDTO> getTechProjectManager(){
		Set<ApplicationUserDTO> userDTOs = apmApplicationService.getTechProjectManager();
		
		return userDTOs;
    }
	
	@RequestMapping(value="/getProjectManager", method = RequestMethod.GET)
	@ResponseBody
	public Set<ApplicationUserDTO> getProjectManager(){
		Set<ApplicationUserDTO> userDTOs = apmApplicationService.getProjectManager();
		
		return userDTOs;
    }
	
	
	@RequestMapping(value="/getISO", method = RequestMethod.GET)
	@ResponseBody
	public Set<ApplicationUserDTO> getISO(){
		Set<ApplicationUserDTO> userDTOs = apmApplicationService.getISO();
		
		return userDTOs;
    }
	
	@RequestMapping(value="/getDevelopers", method = RequestMethod.GET)
	@ResponseBody
	public Set<ApplicationUserDTO> getDevelopers(){
		Set<ApplicationUserDTO> userDTOs = apmApplicationService.getDevelopers();
		
		return userDTOs;
    }
	
	@RequestMapping(value="/getTesters", method = RequestMethod.GET)
	@ResponseBody
	public Set<ApplicationUserDTO> getTesters(){
		Set<ApplicationUserDTO> userDTOs = apmApplicationService.getTesters();
		
		return userDTOs;
    }
	
	
	@RequestMapping(value="/getBusinessAnalyst", method = RequestMethod.GET)
	@ResponseBody
	public Set<ApplicationUserDTO> getBusinessAnalyst(){
		Set<ApplicationUserDTO> userDTOs = apmApplicationService.getBusinessAnalyst();
		
		return userDTOs;
    }
	
	
	@RequestMapping(value="/getDataCustodian", method = RequestMethod.GET)
	@ResponseBody
	public Set<ApplicationUserDTO> getDataCustodian(){
		Set<ApplicationUserDTO> userDTOs = apmApplicationService.getDataCustodian();
		
		return userDTOs;
    }
	
	@RequestMapping(value="/getStatus", method = RequestMethod.GET)
	@ResponseBody
	public Set<StatusDTO> getStatus(){
		Set<StatusDTO> officeDTOs = apmApplicationService.getStatus();
		
		return officeDTOs;
    }
	

	@RequestMapping(value = "/createApplication", method = RequestMethod.POST)
	@ResponseBody
	public ApplicationResp createApplication( @RequestParam(value = "createApp") String  appString,
			@RequestParam(value = "file", required=false) MultipartFile[] files) 
	{
		ApplicationDTO applicationDTO = null;
		try {
			applicationDTO = new ObjectMapper().readValue(appString, ApplicationDTO.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ApplicationResp applicationResp = new ApplicationResp();
		applicationDTO = apmApplicationService.saveApplicationInfo(applicationDTO,files);

		if (applicationDTO != null) {
			applicationResp.setApplicationViewDTO(apmApplicationService.getApplicationForView(applicationDTO.getAcronym()));
			applicationResp.setResponseCode(Integer.parseInt(messageSource.getMessage("APPLICATION.SAVED.CODE", null, Locale.getDefault())));
			applicationResp.setResponseString(messageSource.getMessage("APPLICATION.SAVED.STRING", null, Locale.getDefault()));
		} else {
			applicationResp.setResponseCode(
					Integer.parseInt(messageSource.getMessage("APPLICATION.SAVEFAIL.CODE", null, Locale.getDefault())));
			applicationResp.setResponseString(
					messageSource.getMessage("APPLICATION.SAVEFAIL.STRING", null, Locale.getDefault()));
		}
		return applicationResp;
	}
	
	@RequestMapping(value = "/updateApplication", method = RequestMethod.POST)
	@ResponseBody
	public ApplicationResp updateApplication( @RequestParam(value = "documents", required=true) MultipartFile[] files,
			@RequestParam(value = "application") String  appString)
	{
		ApplicationViewDTO applicationViewDTO = null;
		try {
			applicationViewDTO = new ObjectMapper().readValue(appString, ApplicationViewDTO.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ApplicationResp applicationResp = new ApplicationResp();
		ApplicationDTO applicationDTO = new ApplicationDTO();
		
		applicationViewDTO = apmApplicationService.updateApplicationInfo(applicationViewDTO,files);

		if (applicationViewDTO != null) {
			// applicationViewDTO = apmApplicationService.getApplicationForView(applicationDTO.getAcronym());
			applicationResp.setApplicationViewDTO(applicationViewDTO);

			applicationResp.setResponseCode(Integer.parseInt(messageSource.getMessage("APPLICATION.SAVED.CODE", null, Locale.getDefault())));
			applicationResp.setResponseString(messageSource.getMessage("APPLICATION.SAVED.STRING", null, Locale.getDefault()));
		} else {
			applicationResp.setResponseCode(
					Integer.parseInt(messageSource.getMessage("APPLICATION.SAVEFAIL.CODE", null, Locale.getDefault())));
			applicationResp.setResponseString(
					messageSource.getMessage("APPLICATION.SAVEFAIL.STRING", null, Locale.getDefault()));
		}
		return applicationResp;
	}
	
	
	/*public ApplicationResp updateApplication(@RequestBody ApplicationDTO applicationDTO) {
		ApplicationResp applicationResp = new ApplicationResp();
		apmApplicationService.updateApplicationInfo(applicationDTO);
		applicationResp.setApplicationViewDTO(apmApplicationService.getApplicationForView(applicationDTO.getAcronym()));
		
			applicationResp.setResponseCode(Integer.parseInt(messageSource.getMessage("APPLICATION.SAVED.CODE", null, Locale.getDefault())));
			applicationResp.setResponseString(messageSource.getMessage("APPLICATION.SAVED.STRING", null, Locale.getDefault()));
			
			return applicationResp;
	}*/
		
		////updateApplication
		
		@RequestMapping(value="/createOffices", method = RequestMethod.POST)
		public String createOffices(@RequestBody Set<OfficeDTO> officeDTO){
				apmApplicationService.saveOfficesInfo(officeDTO);
				
			return "Test";
	    }
		
	////check
		
		@RequestMapping(value="/createDivisions", method = RequestMethod.POST)
		public String createDivisions(@RequestBody Set<DivisionDTO> divisionDTO){
				apmApplicationService.saveDivisionsInfo(divisionDTO);
				
			return "Test";
	    }
	////check
		@RequestMapping(value="/createFiscalYear", method = RequestMethod.POST)
		public String createFiscalYear(@RequestBody Set<FiscalYearInfoDTO> fiscalYearInfoDTO){
				apmApplicationService.saveFiscalYearInfo(fiscalYearInfoDTO);
				
			return "Test";
	    }
		
		@RequestMapping(value="/getTechnologies", method = RequestMethod.GET)
		@ResponseBody
		public List<TechnologiesDTO> getTechnologies(){
			List<TechnologiesDTO>  technologiesDTOs = apmApplicationService.getTechnologies();
			
			return technologiesDTOs;
	    }
		
		@RequestMapping(value="/getDatabaseDetails", method = RequestMethod.GET)
		@ResponseBody
		public DatabaseDTO getDatabaseDetails(@RequestParam int id){
			DatabaseDTO  databaseDTO = apmApplicationService.getDatabaseDetails(id);
			
			return databaseDTO;
	    }
		
		/*@RequestMapping(value="/getApplDoc", method = RequestMethod.GET)
		@ResponseBody
		public Set<ApplDocDTO> getApplDoc(@RequestParam int id, final HttpServletRequest request, final HttpServletResponse response){
			Set<ApplDocDTO>  applDocDTO = apmApplicationService.getApplDoc(id);
			 File file = new File(applDocDTO.getCla);
			 String nameArray[] = fileName.split("/.");
			 String extension = nameArray[nameArray.length-1];
			return applDocDTO;
	    }*/
		
		@RequestMapping(value="/getApplDoc", method = RequestMethod.GET)
		@ResponseBody
		public void getApplDoc(@RequestParam int id, final HttpServletRequest request, final HttpServletResponse response){
			Set<ApplDocDTO>  applDocDTO = apmApplicationService.getApplDoc(id);
			String fileName = applDocDTO.iterator().next().getFileLocation();
			 File file = new File(fileName);
			 String nameArray[] = fileName.split("/.");
			 String extension = nameArray[nameArray.length-1];
			 
			 
		        try (InputStream fileInputStream = new FileInputStream(file);
		                OutputStream output = response.getOutputStream();) {
		        			
		        	if(extension.equalsIgnoreCase("XLS") || extension.equalsIgnoreCase("XLX") ||extension.equalsIgnoreCase("CVS"))
		            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		        	else if(extension.equalsIgnoreCase("DOC") || extension.equalsIgnoreCase("DOCX"))
		        		  response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
		        	else if(extension.equalsIgnoreCase("PDF"))
		        		 response.setContentType("application/pdf");
		        		
		            response.setContentLength((int) (file.length()));
		            response.setHeader("File-Name", file.getName());
		            response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
		            output.write(IOUtils.toByteArray(fileInputStream));
		            //IOUtils.copyLarge(fileInputStream, output);
		            /*if (file.exists())
		            	file.delete();*/
		            output.flush();
		            output.close();
		        } catch (IOException e) {
		        	e.printStackTrace();
		        }
		}
		
	 /**
	  * @RequestMapping(value="/getPolicyDocument", method = RequestMethod.GET)
		@ResponseBody
		public void getPolicyDocument(@RequestParam Integer id, final HttpServletRequest request, final HttpServletResponse response){
			
			String fileName = policyServices.getPolicyDocument(id);
			 File file = new File(fileName);
			 String nameArray[] = fileName.split("/.");
			 String extension = nameArray[nameArray.length-1];
			 
					 
		        try (InputStream fileInputStream = new FileInputStream(file);
		                OutputStream output = response.getOutputStream();) {
		        			
		        	if(extension.equalsIgnoreCase("XLS") || extension.equalsIgnoreCase("XLX") ||extension.equalsIgnoreCase("CVS"))
		            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		        	else if(extension.equalsIgnoreCase("DOC") || extension.equalsIgnoreCase("DOCX"))
		        		  response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
		        	else if(extension.equalsIgnoreCase("PDF"))
		        		 response.setContentType("application/pdf");
		        		
		            response.setContentLength((int) (file.length()));
		            response.setHeader("File-Name", file.getName());
		            response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
		            output.write(IOUtils.toByteArray(fileInputStream));
		            //IOUtils.copyLarge(fileInputStream, output);
		            if (file.exists())
		            	file.delete();
		            output.flush();
		            output.close();
		        } catch (IOException e) {
		        	e.printStackTrace();
		        }
		        
	    }**/
		
		@RequestMapping(value="/createReport", method = RequestMethod.POST)
		@ResponseBody
		public ReportDTO2 createReport(@RequestBody ReportDTO reportDTO){
			ReportDTO2  reportDTO2 = apmApplicationService.createReport(reportDTO);
			
		return reportDTO2;
	    }
		
		
		@RequestMapping(value="/getReportData", method = RequestMethod.GET)
		@ResponseBody
		public ALLReportDTO getReportData(){
			ALLReportDTO  allReportDTO = apmApplicationService.getReportData();
			
		return allReportDTO;
	    }
		
		@RequestMapping(value="/getAllApplications", method = RequestMethod.GET)
		@ResponseBody
		public Set<ApplicationDTO> getAllApplications(){
			Set<ApplicationDTO> applicationDTOs = apmApplicationService.getAllApplications();
			
			return applicationDTOs;
	    }
		
		@RequestMapping(value="/getPendingApplications", method = RequestMethod.GET)
		@ResponseBody
		public Set<ApplicationDTO> getPendingApplications(){
			Set<ApplicationDTO> applicationDTOs = apmApplicationService.getPendingApplications();
			
			return applicationDTOs;
	    }
		
		@RequestMapping(value="/getSystemSensitivity", method = RequestMethod.GET)
		@ResponseBody
		public Set<SystemSensitivityDTO> getSystemSensitivity(){
			Set<SystemSensitivityDTO> systemSensitivityDTOs = apmApplicationService.getSystemSensitivity();
			
			return systemSensitivityDTOs;
	    }
	
		
		@RequestMapping(value="/viewApplication", method = RequestMethod.GET)
		@ResponseBody
		public ApplicationResp viewApplication(@RequestParam String acronym){
			ApplicationResp applicationResp = new ApplicationResp();
			ApplicationViewDTO applicationDTO = apmApplicationService.getApplicationForView(acronym);
			if(applicationDTO != null)
			{
				applicationResp.setApplicationViewDTO(applicationDTO);
				applicationResp.setResponseCode(Integer.parseInt(messageSource.getMessage("APPLICATION.FOUND.CODE",null, Locale.getDefault())));
				applicationResp.setResponseString(messageSource.getMessage("APPLICATION.FOUND.STRING",null, Locale.getDefault()));
			}
			else
			{
				applicationResp.setResponseCode(Integer.parseInt(messageSource.getMessage("APPLICATION.NOTFOUND.CODE",null, Locale.getDefault())));
				applicationResp.setResponseString(messageSource.getMessage("APPLICATION.NOTFOUND.STRING",null, Locale.getDefault()));
			}
			return applicationResp;
	    }
		
		
		
		
		
		@RequestMapping(value="/getIAMUserId", method = RequestMethod.GET)
		@ResponseBody
		public int getIAMUserId(@RequestParam int iamId){
			int id= apmApplicationService.getIAMUserId(iamId);
			
			return id;
	    }
		

		@RequestMapping(value="/getApps", method = RequestMethod.GET)
		@ResponseBody
		public List<AppDisp> getApps(@RequestParam String rowName, @RequestParam String colName, @RequestParam String tech){
			
			List<AppDisp> AppDispList = apmApplicationService.getApps(rowName,colName,tech);
			return AppDispList;
	    }
		
		@RequestMapping(value="/getAuditTypes", method = RequestMethod.GET)
		@ResponseBody
		public List<AuditTypeDTO> getAuditTypes(){
			
			List<AuditTypeDTO> auditTypeDTOs = apmApplicationService.getAuditTypes();
			return auditTypeDTOs;
	    }
		
		@RequestMapping(value="/addAuditType", method = RequestMethod.POST)
		@ResponseBody
		public AuditTypeDTO addAuditType(@RequestBody AuditTypeDTO auditTypeDTO){
			auditTypeDTO = apmApplicationService.addAuditType(auditTypeDTO);
				
			return auditTypeDTO;
	    }
		
		@RequestMapping(value="/saveAppAuditInfo", method = RequestMethod.POST)
		@ResponseBody
		public ApplicationResp saveAppAuditInfo(@RequestBody AppAuditDTO appAuditDTO){
			ApplicationResp applicationResp = null;
			applicationResp = apmApplicationService.saveAppAuditInfo(appAuditDTO);
				
			return applicationResp;
	    }
		
		@RequestMapping(value="/updateAppAuditInfo", method = RequestMethod.POST)
		@ResponseBody
		public ApplicationResp updateAppAuditInfo(@RequestBody AppAuditDTO appAuditDTO){
			ApplicationResp applicationResp = null;
			applicationResp = apmApplicationService.updateAppAuditInfo(appAuditDTO);
				
			return applicationResp;
	    }
		
		@RequestMapping(value="/upComingAudits", method = RequestMethod.GET)
		@ResponseBody
		public List<AppAuditDTO> upComingAudits(){
			
			List<AppAuditDTO> auditTypeDTOs = apmApplicationService.upComingAudits();
			return auditTypeDTOs;
	    }
		
		@RequestMapping(value="/getAudits", method = RequestMethod.GET)
		@ResponseBody
		public DashboardAuditResponse getAudits(){
			DashboardAuditResponse dashboardAuditResponse = new DashboardAuditResponse();
			dashboardAuditResponse.setUpcomingAudits(apmApplicationService.upComingAudits());
			dashboardAuditResponse.setTotalAudits(apmApplicationService.getAudits());
			dashboardAuditResponse.setPolicyGrpDTOs(policyServices.getAllPolicyGrps());
			dashboardAuditResponse.setAssessmentDTOs(apmApplicationService.getAllAssessments());
			return dashboardAuditResponse;
	    }
		
		//getAudits
		
		@RequestMapping(value="/getAppAuditFile", method = RequestMethod.GET)
		@ResponseBody
		public AppAuditFileDTO getAppAuditFile(@RequestParam Integer fileId){
			
			AppAuditFileDTO appAuditFileDTO = apmApplicationService.getAppAuditFile(fileId);
			return appAuditFileDTO;
	    }
		
		@RequestMapping(value="/getPolicyTypes", method = RequestMethod.GET)
		@ResponseBody
		public List<PolicyTypeDTO> getPolicyTypes(){
			
			List<PolicyTypeDTO>  policyTypeDTOs =policyServices.getPolicyTypes();
			return policyTypeDTOs;
	    }
		
		
		@RequestMapping(value="/addPolicyGrp", method = RequestMethod.POST)
		@ResponseBody
		public PolicyResponse addPolicyGrp(@RequestBody PolicyGrpDTO policyGrpDTO){
			PolicyResponse policyResponse = new PolicyResponse();
			 policyServices.addPolicyGrp(policyGrpDTO);
			 policyResponse.setResponseCode(Integer.parseInt(messageSource.getMessage("APPLICATION.GENERAL.SUCCESS.CODE", null, Locale.getDefault())));
			 policyResponse.setResponseString(messageSource.getMessage("APPLICATION.GENERAL.SUCCESS.STRING", null, Locale.getDefault()));
				
			return policyResponse;
	    }
		
		
		@RequestMapping(value="/updatePolicyGrp", method = RequestMethod.POST)
		@ResponseBody
		public PolicyResponse updatePolicyGrp(@RequestBody PolicyGrpDTO policyGrpDTO){
			PolicyResponse policyResponse = new PolicyResponse();
			 policyServices.updatePolicyGrp(policyGrpDTO);
			 policyResponse.setPolicyGrpDTO(policyServices.getPolicyGroupDTO(policyGrpDTO.getPolicyGrpId()));
			 policyResponse.setResponseCode(Integer.parseInt(messageSource.getMessage("APPLICATION.GENERAL.SUCCESS.CODE", null, Locale.getDefault())));
			 policyResponse.setResponseString(messageSource.getMessage("APPLICATION.GENERAL.SUCCESS.STRING", null, Locale.getDefault()));
				
			return policyResponse;
	    }
		
		
		@RequestMapping(value="/fetchPolicyGroup", method = RequestMethod.GET)
		@ResponseBody
		public List<PolicyGrpDTO> fetchPolicyGroup(@RequestParam Integer auditTypeId){
			
			List<PolicyGrpDTO> policyGrpDTOs = policyServices.fetchPolicyGroup(auditTypeId);
			return policyGrpDTOs;
	    }
		
		@RequestMapping(value="/fetchFamilies", method = RequestMethod.GET)
		@ResponseBody
		public Set<String> fetchFamilies(@RequestParam Integer policyGrpId){
			Set<String> families = policyServices.getFamiliaOfPolicies(policyGrpId);
			return families;
	    }
		
		@RequestMapping(value="/getPoliciesByFam", method = RequestMethod.GET)
		@ResponseBody
		public List<PolicyDTO> getPoliciesByFam(@RequestParam String familyName){
			
			List<PolicyDTO> policyDTOs = policyServices.fetchPoliciesByFamily(familyName);
			return policyDTOs;
	    }
		
		@RequestMapping(value="/fetchPolicies", method = RequestMethod.GET)
		@ResponseBody
		public PolicyResponse fetchPolicies(@RequestParam Integer policyGrpId){
			PolicyResponse policyResponse = new PolicyResponse();
			policyResponse.setPolicyDTOs(policyServices.fetchPolicies(policyGrpId));
			policyResponse.setPolicyReviewDTOs(policyServices.getPolicyReviewDTOs(policyGrpId));
			policyResponse.setPolicyDocumentsDTOs(policyServices.getPolicyDocuments(policyGrpId));
			policyResponse.setPolicyGrpDTO(policyServices.getPolicyGroupDTO(policyGrpId));
			policyResponse.setApplicationDTOs(policyServices.getAppsOnPolicyGrp(policyGrpId));
			return policyResponse;
	    }
		
		
		//getPolicyDocument
		@RequestMapping(value="/uploadPolicyFile", method = RequestMethod.POST)
		@ResponseBody
		public PolicyResponse uploadPolicyFile(@RequestParam(value = "file", required=true) MultipartFile[] files,
				@RequestParam(value = "policy", required=true) String policyGrpDTOStr){
			PolicyGrpDTO policyGrpDTO = null;
			try {
				policyGrpDTO = new ObjectMapper().readValue(policyGrpDTOStr, PolicyGrpDTO.class);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			PolicyResponse policyResponse = policyServices.uploadPolicyFile(files,policyGrpDTO);
			return policyResponse;
	    }
		
	/*	@RequestMapping(value="/uploadPolicyDocuments", method = RequestMethod.POST)
		@ResponseBody
		public PolicyResponse uploadPolicyDocuments(@RequestParam(value = "files", required=true) MultipartFile[] files,
				@RequestParam(value = "policy", required=true) String policyGrpDTOStr){
			
			PolicyGrpDTO policyGrpDTO = null;
			PolicyResponse policyResponse = new PolicyResponse();
			try {
				policyGrpDTO = new ObjectMapper().readValue(policyGrpDTOStr, PolicyGrpDTO.class);
				policyResponse = policyServices.uploadPolicyDocuments(files,policyGrpDTO);
				return policyResponse;
			} catch (IOException e) {
				e.printStackTrace();
			}
			return policyResponse;
	    }*/
		
		//uploadPolicyDocuments
		@RequestMapping(value="/updatePolicy", method = RequestMethod.POST)
		@ResponseBody
		public PolicyResponse updatePolicy(@RequestParam(value = "files", required=true) MultipartFile[] files,
				@RequestParam(value = "policy", required=true) String policyStr){
			PolicyResponse policyResponse= null;
			PolicyDTO policyDTO = null;
			try {
				policyDTO = new ObjectMapper().readValue(policyStr, PolicyDTO.class);
				policyResponse = policyServices.updatePolicy(policyDTO,files);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return policyResponse;
		}
		
		@RequestMapping(value="/savePolicy", method = RequestMethod.POST)
		@ResponseBody
		public PolicyResponse savePolicy(@RequestParam(value = "files", required=true) MultipartFile[] files,
				@RequestParam(value = "policy", required=true) String policyStr){
			PolicyResponse policyResponse= null;
			PolicyDTO policyDTO = null;
			try {
				policyDTO = new ObjectMapper().readValue(policyStr, PolicyDTO.class);
				policyResponse = policyServices.savePolicy(policyDTO,files);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return policyResponse;
		}
		/*public PolicyResponse savePolicy(@RequestBody PolicyDTO policyDTO){
			PolicyResponse policyResponse= null;
			policyResponse = policyServices.savePolicy(policyDTO);
			return policyResponse;
		}*/
		
		//savePolicy
		
		@RequestMapping(value="/comparePolicyFile", method = RequestMethod.POST)
		@ResponseBody
		public PolicyResponse comparePolicyFile(@RequestParam(value = "file", required=true) MultipartFile[] files,
				@RequestParam(value = "policy", required=true) String policyGrpDTOStr, @RequestParam(value = "policies", required=true) String auditPolicyDTOStr){
			
			PolicyGrpDTO policyGrpDTO = null;
			List<AuditPolicyDTO> auditPolicyDTOs = null;
			try {
				policyGrpDTO = new ObjectMapper().readValue(policyGrpDTOStr, PolicyGrpDTO.class);
				auditPolicyDTOs = new ObjectMapper().readValue(auditPolicyDTOStr, List.class);;
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			PolicyResponse policyResponse = policyServices.comparePolicyFile(files,policyGrpDTO,auditPolicyDTOs);
			return policyResponse;
	    }
		
		@RequestMapping(value="/getAppAudits", method = RequestMethod.GET)
		@ResponseBody
		public DashboardChartDTO getAppAudits(@RequestParam Integer auditYear){
			DashboardChartDTO dashboardChartDTO = new DashboardChartDTO();
			List<AuditDashBoardDTO> auditDashBoardDTOs = apmApplicationService.getApplicationAudits(auditYear);
			dashboardChartDTO.setAuditDashBoardDTOs(auditDashBoardDTOs);
			List<AuditTypeDashBoardDTO> auditTypeDashBoardDTOs = apmApplicationService.getAuditTypeAudits(auditYear);
			dashboardChartDTO.setAuditTypeDashBoardDTOs(auditTypeDashBoardDTOs);
			
			return dashboardChartDTO;
	    }
		
		@RequestMapping(value="/addUser", method = RequestMethod.POST)
		@ResponseBody
		public ApplicationUserResp addUser(@RequestBody ApplicationUserDTO applicationUserDTO){
			ApplicationUserResp applicationUserResp = new ApplicationUserResp();
			applicationUserDTO = apmApplicationService.addUser(applicationUserDTO);
			if(applicationUserDTO == null)
			{
				applicationUserResp.setResponseCode(Integer.parseInt(messageSource.getMessage("APPLICATION.USER.EXISTS.CODE", null, Locale.getDefault())));
				applicationUserResp.setResponseString(messageSource.getMessage("APPLICATION.USER.EXISTS.STRING", null, Locale.getDefault()));
			}
			else
			{
				applicationUserResp.setResponseCode(Integer.parseInt(messageSource.getMessage("APPLICATION.USER.ADDED.CODE", null, Locale.getDefault())));
				applicationUserResp.setResponseString(messageSource.getMessage("APPLICATION.USER.ADDED.STRING", null, Locale.getDefault()));
				applicationUserResp.setApplicationUserDTO(applicationUserDTO);
			}
			return applicationUserResp;
	    }
		@RequestMapping(value="/getTechnology", method = RequestMethod.GET)
		@ResponseBody
		public TechnologiesDTO getTechnology(@RequestParam Integer technologyId){
			
			TechnologiesDTO technologiesDTO = apmApplicationService.getTechnology(technologyId);
			return technologiesDTO;
	    }
		
		@RequestMapping(value="/sendNotifications", method = RequestMethod.POST)
		@ResponseBody
		public PolicyResponse sendNotifications(@RequestBody List<AuditPolicyDTO> appAuditPolicyDTOs){
			
			PolicyResponse policyResponse = policyServices.sendNotifications(appAuditPolicyDTOs);
			return policyResponse;
	    }
		
		@RequestMapping(value="/getPolicy", method = RequestMethod.GET)
		@ResponseBody
		public PolicyDTO getPolicy(@RequestParam Integer policyId){
			
			PolicyDTO policyDTO = policyServices.getPolicy(policyId);
			return policyDTO;
	    }
		
		@RequestMapping(value="/generatePolicyFile", method = RequestMethod.GET)
		@ResponseBody
		public void generatePolicyFile(@RequestParam Integer policyGrpId, final HttpServletRequest request, final HttpServletResponse response){
			
			String fileName = policyServices.downloadPolicyFile(policyGrpId);
			 File file = new File(fileName);
		        try (InputStream fileInputStream = new FileInputStream(file);
		                OutputStream output = response.getOutputStream();) {


		            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		            response.setContentLength((int) (file.length()));
		            response.setHeader("File-Name", file.getName());
		            response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
		            output.write(IOUtils.toByteArray(fileInputStream));
		            //IOUtils.copyLarge(fileInputStream, output);
		            if (file.exists())
		            	file.delete();
		            output.flush();
		            output.close();
		        } catch (IOException e) {
		        	e.printStackTrace();
		        }
		        
	    }
		
		@RequestMapping(value="/getPolicyDocument", method = RequestMethod.GET)
		@ResponseBody
		public void getPolicyDocument(@RequestParam Integer id, final HttpServletRequest request, final HttpServletResponse response){
			
			String fileName = policyServices.getPolicyDocument(id);
			 File file = new File(fileName);
			 String nameArray[] = fileName.split("/.");
			 String extension = nameArray[nameArray.length-1];
			 
					 
		        try (InputStream fileInputStream = new FileInputStream(file);
		                OutputStream output = response.getOutputStream();) {
		        			
		        	if(extension.equalsIgnoreCase("XLS") || extension.equalsIgnoreCase("XLX") ||extension.equalsIgnoreCase("CVS"))
		            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		        	else if(extension.equalsIgnoreCase("DOC") || extension.equalsIgnoreCase("DOCX"))
		        		  response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
		        	else if(extension.equalsIgnoreCase("PDF"))
		        		 response.setContentType("application/pdf");
		        		
		            response.setContentLength((int) (file.length()));
		            response.setHeader("File-Name", file.getName());
		            response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
		            output.write(IOUtils.toByteArray(fileInputStream));
		            //IOUtils.copyLarge(fileInputStream, output);
		            if (file.exists())
		            	file.delete();
		            output.flush();
		            output.close();
		        } catch (IOException e) {
		        	e.printStackTrace();
		        }
		        
	    }
		
		//getPolicyDocument
		@RequestMapping(value="/generatePolicyComppareFile", method = RequestMethod.POST)
		@ResponseBody
		public void generatePolicyComppareFile(@RequestBody List<AuditPolicyDTO> appAuditPolicyDTOs,final HttpServletRequest request, final HttpServletResponse response){
			
			String fileName = policyServices.generatePolicyComppareFile(appAuditPolicyDTOs);
			File file = new File(fileName);
	        try (InputStream fileInputStream = new FileInputStream(file);
	                OutputStream output = response.getOutputStream();) {


	            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	            response.setContentLength((int) (file.length()));
	            response.setHeader("File-Name", file.getName());
	            response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
	            output.write(IOUtils.toByteArray(fileInputStream));
	            //IOUtils.copyLarge(fileInputStream, output);
	            if (file.exists())
	            	file.delete();
	            output.flush();
	            output.close();
	        } catch (IOException e) {
	        	e.printStackTrace();
	        }
	    }
		
		@RequestMapping(value="/getUserRoles", method = RequestMethod.GET)
		@ResponseBody
		public List<UserAppRoleDTO> getUserRoles(){
			
			List<UserAppRoleDTO> userAppRoleDTOs = userServices.getUserRoles();
			return userAppRoleDTOs;
	    }
		
		@RequestMapping(value="/getUsersonRole", method = RequestMethod.GET)
		@ResponseBody
		public List<ApplicationUserDTO> getUsersonRole(@RequestParam Integer role){
			
			List<ApplicationUserDTO> userDTOs = userServices.getUsers(role);
			return userDTOs;
	    }
		
		@RequestMapping(value="/getUserApps", method = RequestMethod.POST)
		@ResponseBody
		public UserReportResponse getUserApps(@RequestBody UserReportRequest  userReportRequest){
			UserReportResponse userReportResponse = userServices.getUserApps(userReportRequest);
			return userReportResponse;
	    }
		
		@RequestMapping(value="/getAppHistory", method = RequestMethod.GET)
		@ResponseBody
		public List<ApplicationHistoryDTO> getAppHistory(@RequestParam String acronym){
			
			List<ApplicationHistoryDTO> userDTOs = aamHistoryServices.getApplicationHistory(acronym);
			return userDTOs;
	    }
		
		
		@RequestMapping(value="/getAppAuditHistory", method = RequestMethod.GET)
		@ResponseBody
		public List<AppAuditHistoryDTO> getAppAuditHistory(@RequestParam String acronym){
			
			List<AppAuditHistoryDTO> appAuditHistoryDTOs = aamHistoryServices.getApplicationAuditHistory(acronym);
			return appAuditHistoryDTOs;
	    }
		
		@RequestMapping(value="/assignReviewers", method = RequestMethod.POST)
		@ResponseBody
		public List<PolicyReviewDTO>  assignReviewers(@RequestBody List<PolicyReviewDTO>  policyReviewDTOs){
			policyReviewDTOs = policyServices.assignReviewers(policyReviewDTOs);
			return policyReviewDTOs;
	    }
		
		@RequestMapping(value="/getReviewPolicies", method = RequestMethod.GET)
		@ResponseBody
		public PolicyResponse  getReviewPolicies(@RequestParam String token){
			PolicyResponse policyResponse = new PolicyResponse();
			PolicyReviewDTO policyReviewDTO = policyServices.getReviewPolicies(token);
			if(policyReviewDTO != null)
			{
				policyResponse.setPolicyReviewDTO(policyReviewDTO);
				policyResponse.setResponseCode(Integer.parseInt(messageSource.getMessage("POLICY.VALID.TOKEN.CODE",null, Locale.getDefault())));
				policyResponse.setResponseString(messageSource.getMessage("POLICY.VALID.TOKEN.STRING",null, Locale.getDefault()));
				
				//applicationResp.setResponseCode(Integer.parseInt(messageSource.getMessage("APPLICATION.FOUND.CODE",null, Locale.getDefault())));
//				./applicationResp.setResponseString(messageSource.getMessage("APPLICATION.FOUND.STRING",null, Locale.getDefault()));
			}
			else
			{
				policyResponse.setResponseCode(Integer.parseInt(messageSource.getMessage("POLICY.INVALID.TOKEN.CODE",null, Locale.getDefault())));
				policyResponse.setResponseString(messageSource.getMessage("POLICY.INVALID.TOKEN.STRING",null, Locale.getDefault()));
			}
			return policyResponse;
	    }
		
		@RequestMapping(value="/savePolicyReview", method = RequestMethod.POST)
		@ResponseBody
		public PolicyResponse  savePolicyReview(@RequestBody PolicyReviewDTO policyReviewDTO){
			PolicyResponse policyResponse = new PolicyResponse();
			policyReviewDTO = policyServices.savePolicyReview(policyReviewDTO);
			policyResponse.setPolicyReviewDTO(policyReviewDTO);
			policyResponse.setResponseCode(Integer.parseInt(messageSource.getMessage("POLICY.VALID.TOKEN.CODE",null, Locale.getDefault())));
			policyResponse.setResponseString(messageSource.getMessage("POLICY.VALID.TOKEN.STRING",null, Locale.getDefault()));
			return policyResponse;
	    }
		
		@RequestMapping(value="/getPolicyReviewDetails", method = RequestMethod.GET)
		@ResponseBody
		public PolicyResponse  getPolicyReviewDetails(@RequestParam Integer id){
			PolicyResponse policyResponse = new PolicyResponse();
			PolicyReviewDTO policyReviewDTO = policyServices.getPolicyReviewDetails(id);
			if(policyReviewDTO != null)
			{
				policyResponse.setPolicyReviewDTO(policyReviewDTO);
				policyResponse.setResponseCode(Integer.parseInt(messageSource.getMessage("POLICY.VALID.TOKEN.CODE",null, Locale.getDefault())));
				policyResponse.setResponseString(messageSource.getMessage("POLICY.VALID.TOKEN.STRING",null, Locale.getDefault()));
				
				//applicationResp.setResponseCode(Integer.parseInt(messageSource.getMessage("APPLICATION.FOUND.CODE",null, Locale.getDefault())));
//				./applicationResp.setResponseString(messageSource.getMessage("APPLICATION.FOUND.STRING",null, Locale.getDefault()));
			}
			else
			{
				policyResponse.setResponseCode(Integer.parseInt(messageSource.getMessage("POLICY.INVALID.TOKEN.CODE",null, Locale.getDefault())));
				policyResponse.setResponseString(messageSource.getMessage("POLICY.INVALID.TOKEN.STRING",null, Locale.getDefault()));
			}
			return policyResponse;
	    }
		
		@RequestMapping(value="/getDatabaseReport", method = RequestMethod.GET)
		@ResponseBody
		public ReportDTO  getDatabaseReport(@RequestParam Integer databaseId)
		{
			ReportDTO reportDTO = apmApplicationService.getDatabaseReport(databaseId);
			return reportDTO;
	    }
		
		@RequestMapping(value="/getServerReport", method = RequestMethod.GET)
		@ResponseBody
		public ReportDTO  getServerReport(@RequestParam Integer serverId)
		{
			ReportDTO reportDTO = apmApplicationService.getServerReport(serverId);
			return reportDTO;
	    }
		
		@RequestMapping(value="/getTechReport", method = RequestMethod.GET)
		@ResponseBody
		public ReportDTO  getTechReport(@RequestParam Integer techId)
		{
			ReportDTO reportDTO = apmApplicationService.getTechReport(techId);
			return reportDTO;
	    }
		
		@RequestMapping(value="/saveDBServerInfo", method = RequestMethod.POST)
		@ResponseBody
		public ApplicationResp  saveDBServerInfo(@RequestBody DatabaseDTO databaseDTO){
			ApplicationResp applicationResp = new ApplicationResp();
			databaseDTO = apmApplicationService.saveDBServerInfo(databaseDTO);
			applicationResp.setResponseCode(Integer.parseInt(messageSource.getMessage("APPLICATION.GENERAL.SUCCESS.CODE", null, Locale.getDefault())));
			applicationResp.setResponseString(messageSource.getMessage("APPLICATION.GENERAL.SUCCESS.STRING", null, Locale.getDefault()));
			return applicationResp;
	    }
		
		@RequestMapping(value="/updateDBServerInfo", method = RequestMethod.POST)
		@ResponseBody
		public ApplicationResp  updateDBServerInfo(@RequestBody DatabaseDTO databaseDTO){
			ApplicationResp applicationResp = new ApplicationResp();
			databaseDTO = apmApplicationService.updateDBServerInfo(databaseDTO);
			applicationResp.setResponseCode(Integer.parseInt(messageSource.getMessage("APPLICATION.GENERAL.SUCCESS.CODE", null, Locale.getDefault())));
			applicationResp.setResponseString(messageSource.getMessage("APPLICATION.GENERAL.SUCCESS.STRING", null, Locale.getDefault()));
			return applicationResp;
	    }
		
		
		@RequestMapping(value="/getDBServer", method = RequestMethod.GET)
		@ResponseBody
		public DatabaseDTO  getDBServer(@RequestParam Integer a)
		{
			DatabaseDTO databaseDTO = apmApplicationService.getDatabaseDetails(a);
			
			return databaseDTO;
	    }
		
		@RequestMapping(value="/getServerDetails", method = RequestMethod.GET)
		@ResponseBody
		public ServerDTO  getDBSegetServerDetailsrver(@RequestParam Integer a)
		{
			ServerDTO serverDTO = apmApplicationService.getServerDetails(a);
			
			return serverDTO;
	    }
		
		@RequestMapping(value="/getPolicyReviewTerms", method = RequestMethod.GET)
		@ResponseBody
		public List<PolicyReviewTermDTO>  getPolicyReviewTerms()
		{
			List<PolicyReviewTermDTO> policyReviewTermDTOs= policyServices.getPolicyReviewTerms();
			
			return policyReviewTermDTOs;
	    }
		
		
		
		@RequestMapping(value = "/getProperties", method = RequestMethod.GET)
		@ResponseBody
		public String getProperties() {
			return environment.getRequiredProperty("hostName");
		}
		
		@RequestMapping(value = "/getAuditTypeReport", method = RequestMethod.GET)
		@ResponseBody
		public Set<ApplicationDTO> getAuditTypeReport(@RequestParam int id, @RequestParam String status,@RequestParam int year) {
			Set<ApplicationDTO> applicationDTOs = apmApplicationService.getAuditTypeReport( id, status,year);
			return applicationDTOs;
		}
		//updatePolicyGrp
		
		@RequestMapping(value="/saveAppAssessment", method = RequestMethod.POST)
		@ResponseBody
		public ApplicationResp saveAppAssessment(@RequestBody AssessmentDTO assessmentDTO){
			ApplicationResp applicationResp = null;
			applicationResp = apmApplicationService.saveAppAssessment(assessmentDTO);
				
			return applicationResp;
	    }
		
		@RequestMapping(value = "/getAppAssessment", method = RequestMethod.GET)
		@ResponseBody
		public AssessmentDTO getAppAssessment(@RequestParam int assessmentID) {
			AssessmentDTO assessmentDTO = apmApplicationService.getAppAssessment(assessmentID);
			return assessmentDTO;
		}
		
		@RequestMapping(value = "/getAssessment", method = RequestMethod.GET)
		@ResponseBody
		public AssessmentPolicyDTO getAssessment(@RequestParam int assessmentID) {
			AssessmentPolicyDTO assessmentPolicyDTO = apmApplicationService.getAppAssessmentPolicy(assessmentID);
			return assessmentPolicyDTO;
		}
		
		@RequestMapping(value = "/saveAssessment", method = RequestMethod.POST)
		@ResponseBody
		public AssessmentResponse saveAssessment(@RequestBody AssessmentPolicyDTO assessmentPolicyDTO) {
			AssessmentResponse assessmentResponse = new AssessmentResponse();
			assessmentPolicyDTO = apmApplicationService.saveAssessment(assessmentPolicyDTO);
			assessmentResponse.setResponseCode(Integer
					.parseInt(messageSource.getMessage("APPLICATION.GENERAL.SUCCESS.CODE", null, Locale.getDefault())));
			assessmentResponse.setResponseString(
					messageSource.getMessage("APPLICATION.GENERAL.SUCCESS.STRING", null, Locale.getDefault()));
			assessmentResponse.setAssessmentPolicyDTO(assessmentPolicyDTO);
			return assessmentResponse;
		}
		
		@RequestMapping(value = "/updateAppAssessment", method = RequestMethod.POST)
		@ResponseBody
		public ApplicationResp updateAppAssessment(@RequestBody AssessmentDTO assessmentDTO) {
			ApplicationResp applicationResp = null;
			applicationResp = apmApplicationService.updateAppAssessment(assessmentDTO);
			return applicationResp;
		}
		
		
		@RequestMapping(value="/getAssessmentPolicyFile", method = RequestMethod.GET)
		@ResponseBody
		public void getAssessmentPolicyFile(@RequestParam int assessmentID,final HttpServletRequest request, final HttpServletResponse response){
			
			String fileName = apmApplicationService.getAssessmentPolicyFile(assessmentID);
			File file = new File(fileName);
	        try (InputStream fileInputStream = new FileInputStream(file);
	                OutputStream output = response.getOutputStream();) {

	            response.setContentLength((int) (file.length()));
	            response.setHeader("File-Name", file.getName());
	            response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
	            output.write(IOUtils.toByteArray(fileInputStream));
	            //IOUtils.copyLarge(fileInputStream, output);
	            if (file.exists())
	            	file.delete();
	            output.flush();
	            output.close();
	        } catch (IOException e) {
	        	e.printStackTrace();
	        }
	    }
		
		@RequestMapping(value="/getAssessmentFile", method = RequestMethod.GET)
		@ResponseBody
		public void getAssessmentFile(@RequestParam int id,final HttpServletRequest request, final HttpServletResponse response){
			
			String fileName = apmApplicationService.getAssessmentFile(id);
			if(fileName != null)
			{
				File file = new File(fileName);
		        try (InputStream fileInputStream = new FileInputStream(file);
		                OutputStream output = response.getOutputStream();) {
	
	
		            response.setContentLength((int) (file.length()));
		            response.setHeader("File-Name", file.getName());
		            response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
		            output.write(IOUtils.toByteArray(fileInputStream));
		            //IOUtils.copyLarge(fileInputStream, output);
		            output.flush();
		            output.close();
		        } catch (IOException e) {
		        	e.printStackTrace();
		        }
			}
	    }
		
		
		@RequestMapping(value="/getAssessmentAuditHistory", method = RequestMethod.GET)
		@ResponseBody
		public List<AssessmentAuditDTO> getAssessmentAuditHistory(@RequestParam int  assessmentId){
			
			List<AssessmentAuditDTO> assessmentAuditDTOs = aamHistoryServices.getApplicationAuditHistory(assessmentId);
			return assessmentAuditDTOs;
	    }
		
		@RequestMapping(value="/getAppAcronyms", method = RequestMethod.GET)
		@ResponseBody
		public List<String> getAppAcronyms(){
			
			List<String> acronyms = apmApplicationService.getAppAcronyms();
			return acronyms;
	    }
		
		@RequestMapping(value="/getLocalityAcronyms", method = RequestMethod.GET)
		@ResponseBody
		public List<String> getLocalityAcronyms(){
			
			List<String> acronyms = apmApplicationService.getLocalityAcronyms();
			return acronyms;
	    }
		
		@RequestMapping(value="/getLocalityTotal", method = RequestMethod.GET)
		@ResponseBody
		public int getLocalityTotal(){
			
			int localities = apmApplicationService.getLocalityTotal();
			return localities;
	    }
		
		@RequestMapping(value="/getBusinessOwnerNameDoe", method = RequestMethod.GET)
		@ResponseBody
		public List<String> BusinessOwnerNameDoe(){
			
			List<String> BusinessOwnerNameDoe = apmApplicationService.getBusinessOwnerNameDoe();
			return BusinessOwnerNameDoe;
	    }
		
		@RequestMapping(value="/getSystemOwnerNameDoe", method = RequestMethod.GET)
		@ResponseBody
		public List<String> systemOwnerNameDoe(){
			
			List<String> systemOwnerNameDoe = apmApplicationService.getSystemOwnerNameDoe();
			return systemOwnerNameDoe;
	    }
		
		
		@RequestMapping(value="/saveMOU", method = RequestMethod.POST)
		@ResponseBody
		public ApplicationResp saveMOU(@RequestParam(value = "attachments", required=true) MultipartFile[] files,
				@RequestParam(value = "mou") String  mouString){
			MOUDTO moudto = new MOUDTO();
			ApplicationResp applicationResp = null;
			try {
				moudto = new ObjectMapper().readValue(mouString, MOUDTO.class);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			applicationResp = apmApplicationService.saveMOU(moudto,files);
				
			return applicationResp;
	    }
		
		@RequestMapping(value="/updateMOU", method = RequestMethod.POST)
		@ResponseBody
		public ApplicationResp updateMOU(@RequestParam(value = "attachments", required=true) MultipartFile[] files,
				@RequestParam(value = "mou") String  mouString){
			MOUDTO moudto = new MOUDTO();
			ApplicationResp applicationResp = null;
			try {
				moudto = new ObjectMapper().readValue(mouString, MOUDTO.class);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			applicationResp = apmApplicationService.updateMOU(moudto, files);
				
			return applicationResp;
	    }
		/*
		 * public ApplicationResp updateApplication( @RequestParam(value = "documents", required=true) MultipartFile[] files,
			@RequestParam(value = "application") String  appString)
	{
		ApplicationViewDTO applicationViewDTO = null;
		try {
			applicationViewDTO = new ObjectMapper().readValue(appString, ApplicationViewDTO.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ApplicationResp applicationResp = new ApplicationResp();
		ApplicationDTO applicationDTO = new ApplicationDTO();
		
		applicationViewDTO = apmApplicationService.updateApplicationInfo(applicationViewDTO,files);

		if (applicationViewDTO != null) {
			// applicationViewDTO = apmApplicationService.getApplicationForView(applicationDTO.getAcronym());
			applicationResp.setApplicationViewDTO(applicationViewDTO);

			applicationResp.setResponseCode(Integer.parseInt(messageSource.getMessage("APPLICATION.SAVED.CODE", null, Locale.getDefault())));
			applicationResp.setResponseString(messageSource.getMessage("APPLICATION.SAVED.STRING", null, Locale.getDefault()));
		} else {
			applicationResp.setResponseCode(
					Integer.parseInt(messageSource.getMessage("APPLICATION.SAVEFAIL.CODE", null, Locale.getDefault())));
			applicationResp.setResponseString(
					messageSource.getMessage("APPLICATION.SAVEFAIL.STRING", null, Locale.getDefault()));
		}
		return applicationResp;
	}
		 */
		/*@RequestMapping(value="/updateMou", method = RequestMethod.POST)
		@ResponseBody
		public ApplicationResp updateMou(@RequestBody MOUDTO moudto){
			ApplicationResp applicationResp = null;
			applicationResp = apmApplicationService.updateMou(moudto);
				
			return applicationResp;
	    }*/
		
		
		@RequestMapping(value="/getMOUFile", method = RequestMethod.GET)
		@ResponseBody
		public void getMOUFile(@RequestParam int mouDocId,final HttpServletRequest request, final HttpServletResponse response){
			
			String fileName = apmApplicationService.getMOUFile(mouDocId);
			File file = new File(fileName);
			 String nameArray[] = fileName.split("/.");
			 String extension = nameArray[nameArray.length-1];
			 
	        try (InputStream fileInputStream = new FileInputStream(file);
	                OutputStream output = response.getOutputStream();) {
	        	System.out.println(file.length());
	        	if(extension.equalsIgnoreCase("XLS") || extension.equalsIgnoreCase("XLX") ||extension.equalsIgnoreCase("CVS"))
		            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		        	else if(extension.equalsIgnoreCase("DOC") || extension.equalsIgnoreCase("DOCX"))
		        		  response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
		        	else if(extension.equalsIgnoreCase("PDF"))
		        		 response.setContentType("application/pdf");

	            response.setHeader("File-Name", file.getName());
	            response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
	            output.write(IOUtils.toByteArray(fileInputStream));
	            //IOUtils.copyLarge(fileInputStream, output);
	            output.flush();
	            output.close();
	        } catch (IOException e) {
	        	e.printStackTrace();
	        }
	    }
		
		
		@RequestMapping(value="/getPolicyDocumentAttachment", method = RequestMethod.GET)
		@ResponseBody
		public void getPolicyDocumentAttachment(@RequestParam int policyDocId,final HttpServletRequest request, final HttpServletResponse response){
			
			String fileName = apmApplicationService.getPolicyDocumentAttachment(policyDocId);
			File file = new File(fileName);
			 String nameArray[] = fileName.split("/.");
			 String extension = nameArray[nameArray.length-1];
			 
	        try (InputStream fileInputStream = new FileInputStream(file);
	                OutputStream output = response.getOutputStream();) {
	        	System.out.println(file.length());
	        	if(extension.equalsIgnoreCase("XLS") || extension.equalsIgnoreCase("XLX") ||extension.equalsIgnoreCase("CVS"))
		            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		        	else if(extension.equalsIgnoreCase("DOC") || extension.equalsIgnoreCase("DOCX"))
		        		  response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
		        	else if(extension.equalsIgnoreCase("PDF"))
		        		 response.setContentType("application/pdf");

	            response.setHeader("File-Name", file.getName());
	            response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
	            output.write(IOUtils.toByteArray(fileInputStream));
	            //IOUtils.copyLarge(fileInputStream, output);
	            output.flush();
	            output.close();
	        } catch (IOException e) {
	        	e.printStackTrace();
	        }
	    }
		
		
		@RequestMapping(value="/getPolicyDocumentAttch", method = RequestMethod.GET)
		@ResponseBody
		public void getPolicyDocumentAttch(@RequestParam int policyDocId,final HttpServletRequest request, final HttpServletResponse response){
			
			String fileName = electionServices.getPolicyDocumentAttch(policyDocId);
			File file = new File(fileName);
			 String nameArray[] = fileName.split("/.");
			 String extension = nameArray[nameArray.length-1];
			 
	        try (InputStream fileInputStream = new FileInputStream(file);
	                OutputStream output = response.getOutputStream();) {
	        	System.out.println(file.length());
	        	if(extension.equalsIgnoreCase("XLS") || extension.equalsIgnoreCase("XLX") ||extension.equalsIgnoreCase("CVS"))
		            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		        	else if(extension.equalsIgnoreCase("DOC") || extension.equalsIgnoreCase("DOCX"))
		        		  response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
		        	else if(extension.equalsIgnoreCase("PDF"))
		        		 response.setContentType("application/pdf");

	            response.setHeader("File-Name", file.getName());
	            response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
	            output.write(IOUtils.toByteArray(fileInputStream));
	            //IOUtils.copyLarge(fileInputStream, output);
	            output.flush();
	            output.close();
	        } catch (IOException e) {
	        	e.printStackTrace();
	        }
	    }
		
		
		
		@RequestMapping(value="/addNewVendor", method = RequestMethod.POST)
		@ResponseBody
		public ApplicationResp  addNewVendor(@RequestBody VendorsDTO vendorsDTO){
			ApplicationResp applicationResp = new ApplicationResp();
			System.out.println(vendorsDTO.getVendorId() );
			if(vendorsDTO.getVendorId() == null || vendorsDTO.getVendorId().intValue() == 0)
				vendorsDTO = apmApplicationService.addNewVendor(vendorsDTO);
			else
				vendorsDTO = apmApplicationService.updateVendor(vendorsDTO);
			
			applicationResp.setResponseCode(Integer.parseInt(messageSource.getMessage("APPLICATION.GENERAL.SUCCESS.CODE", null, Locale.getDefault())));
			applicationResp.setResponseString(messageSource.getMessage("APPLICATION.GENERAL.SUCCESS.STRING", null, Locale.getDefault()));
			return applicationResp;
	    }
		
		
		@RequestMapping(value="/getVendors", method = RequestMethod.GET)
		@ResponseBody
		public VendorResponse  getVendors(){
			VendorResponse vendorResponse = new VendorResponse();
			List<VendorsDTO> vendorsDTOs = apmApplicationService.getVendors();
			vendorResponse.setVendorsDTOs(vendorsDTOs);
			vendorResponse.setResponseCode(Integer.parseInt(messageSource.getMessage("APPLICATION.GENERAL.SUCCESS.CODE", null, Locale.getDefault())));
			vendorResponse.setResponseString(messageSource.getMessage("APPLICATION.GENERAL.SUCCESS.STRING", null, Locale.getDefault()));
			return vendorResponse;
	    }
		
		@RequestMapping(value="/getSolutionTypes", method = RequestMethod.GET)
		@ResponseBody
		public SolutionTypeResp  getSolutionTypes(){
			SolutionTypeResp solutionTypeResp = new SolutionTypeResp();
			List<SolutionTypeDTO> solutionTypeDTOs = apmApplicationService.getSolutionTypes();
			solutionTypeResp.setSolutionTypeDTOs(solutionTypeDTOs);
			solutionTypeResp.setResponseCode(Integer.parseInt(messageSource.getMessage("APPLICATION.GENERAL.SUCCESS.CODE", null, Locale.getDefault())));
			solutionTypeResp.setResponseString(messageSource.getMessage("APPLICATION.GENERAL.SUCCESS.STRING", null, Locale.getDefault()));
			return solutionTypeResp;
	    }
		
		
		@RequestMapping(value="/registerSolution", method = RequestMethod.POST)
		@ResponseBody
		public ApplicationResp registerSolution(@RequestParam(value = "certDocs", required=true) MultipartFile[] files,
				@RequestParam(value = "solution") String  solutionString){
			SolutionsDTO solutionsDTO = new SolutionsDTO();
			ApplicationResp applicationResp = null;
			try {
				solutionsDTO = new ObjectMapper().readValue(solutionString, SolutionsDTO.class);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			applicationResp = electionServices.registerSolution(solutionsDTO,files);
				
			return applicationResp;
	    }
		
		@RequestMapping(value="/updateSolution", method = RequestMethod.POST)
		@ResponseBody
		public ApplicationResp updateSolution(@RequestParam(value = "certDocs", required=true) MultipartFile[] files,
				@RequestParam(value = "solution") String  solutionString){
			SolutionsDTO solutionsDTO = new SolutionsDTO();
			ApplicationResp applicationResp = null;
			try {
				solutionsDTO = new ObjectMapper().readValue(solutionString, SolutionsDTO.class);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			applicationResp = electionServices.updateSolution(solutionsDTO,files);
				
			return applicationResp;
	    }
		//updateSolution
		@RequestMapping(value="/getSolutions", method = RequestMethod.GET)
		@ResponseBody
		public SolutionsResponse  getSolutions(){
			SolutionsResponse solutionsResponse = new SolutionsResponse();
			List<SolutionsDTO> solutionsDTOs = electionServices.getSolutions();
			solutionsResponse.setSolutionsDTOs(solutionsDTOs);
			solutionsResponse.setResponseCode(Integer.parseInt(messageSource.getMessage("APPLICATION.GENERAL.SUCCESS.CODE", null, Locale.getDefault())));
			solutionsResponse.setResponseString(messageSource.getMessage("APPLICATION.GENERAL.SUCCESS.STRING", null, Locale.getDefault()));
			return solutionsResponse;
	    }
		
		@RequestMapping(value="/getSolutionsOnType", method = RequestMethod.GET)
		@ResponseBody
		public SolutionsResponse  getSolutionsOnType(@RequestParam int  systemTypeId, @RequestParam int precinctTypeId){
			SolutionsResponse solutionsResponse = new SolutionsResponse();
			List<SolutionsDTO> solutionsDTOs = electionServices.getSolutionsOnType(systemTypeId,precinctTypeId);
			solutionsResponse.setSolutionsDTOs(solutionsDTOs);
			solutionsResponse.setResponseCode(Integer.parseInt(messageSource.getMessage("APPLICATION.GENERAL.SUCCESS.CODE", null, Locale.getDefault())));
			solutionsResponse.setResponseString(messageSource.getMessage("APPLICATION.GENERAL.SUCCESS.STRING", null, Locale.getDefault()));
			return solutionsResponse;
	    }
		
		////////////////////Reports/////////////////////////////////
		///system type
		
		/*@RequestMapping(value="/getLocOnTypeForReports", method = RequestMethod.GET)
		@ResponseBody
		public Set<String>  getLocOnTypeForReports(@RequestParam int  solutionId){
			Set<String> acronyms = electionServices.getLocOnTypeForReports(solutionId);
			
			return acronyms;
	    }*/
		///////////////////////////////////////////////////////////////
		@RequestMapping(value="/getLocOnTypeForSystem", method = RequestMethod.GET)
		@ResponseBody
		public List<ApplicationSolutionDTO>  getLocOnTypeForSystem(@RequestParam int  solutionId){
			List<ApplicationSolutionDTO> appSolutionDTOs = electionServices.getLocOnTypeForSystem(solutionId);
			
			return appSolutionDTOs;
	    }
		////////////////////////////////////////////////////////////
		
		@RequestMapping(value="/getLocOnVendors", method = RequestMethod.GET)
		@ResponseBody
		public List<ReportVendorsDTO>  getLocOnVendors(@RequestParam Integer  vendorId){
			List<ReportVendorsDTO> reportVendorsDTOs = electionServices.getLocOnVendor(vendorId);
			
			return reportVendorsDTOs;
	    }
		
		
		/////////////////////////////////////////////////////////////
		
		//getSolutionsOnTypeFor Reports based on SYstem Type
		
		
		@RequestMapping(value="/getSolOnTypeForReports", method = RequestMethod.GET)
		@ResponseBody
		public SolutionsResponse  getSolOnTypeForReports(@RequestParam int  systemTypeId){
			SolutionsResponse solutionsResponse = new SolutionsResponse();
			List<SolutionsDTO> solutionsDTOs = electionServices.getSolOnTypeForReports(systemTypeId);
			solutionsResponse.setSolutionsDTOs(solutionsDTOs);
			solutionsResponse.setResponseCode(Integer.parseInt(messageSource.getMessage("APPLICATION.GENERAL.SUCCESS.CODE", null, Locale.getDefault())));
			solutionsResponse.setResponseString(messageSource.getMessage("APPLICATION.GENERAL.SUCCESS.STRING", null, Locale.getDefault()));
			return solutionsResponse;
	    }
		
///////////////////////////////////////////////////////////////////////////////////////		
		
		//getSolutionsOnTypeFor Reports based on precinct type
		
		
		@RequestMapping(value="/getSolOnTypeForPrecinct", method = RequestMethod.GET)
		@ResponseBody
		public SolutionsResponse  getSolOnTypeForPrecinct(@RequestParam int precinctTypeId){
			SolutionsResponse solutionsResponse = new SolutionsResponse();
			List<SolutionsDTO> solutionsDTOs = electionServices.getSolOnTypeForPrecinct(precinctTypeId);
			solutionsResponse.setSolutionsDTOs(solutionsDTOs);
			solutionsResponse.setResponseCode(Integer.parseInt(messageSource.getMessage("APPLICATION.GENERAL.SUCCESS.CODE", null, Locale.getDefault())));
			solutionsResponse.setResponseString(messageSource.getMessage("APPLICATION.GENERAL.SUCCESS.STRING", null, Locale.getDefault()));
			return solutionsResponse;
	    }
		
		
		@RequestMapping(value="/getLocOnTypeForPrecinct", method = RequestMethod.GET)
		@ResponseBody
		public Set<String>  getLocOnTypeForPrecinct(@RequestParam int precinctTypeId ){
			Set<String> acronyms = electionServices.getLocOnTypeForPrecinct(precinctTypeId);
			
			return acronyms;
	    }
		
		
		
		
		//////////////////////////////////////////////////
		
		@RequestMapping(value="/getSolution", method = RequestMethod.GET)
		@ResponseBody
		public SolutionsDTO getSolution(@RequestParam int  solutionID){
			
			SolutionsDTO solutionsDTO = electionServices.getSolution(solutionID);
			return solutionsDTO;
	    }
		
		@RequestMapping(value="/getVendor", method = RequestMethod.GET)
		@ResponseBody
		public VendorsDTO getVendor(@RequestParam int  vendorId){
			
			VendorsDTO vendorsDTO = electionServices.getVendor(vendorId);
			return vendorsDTO;
	    }
		
		@RequestMapping(value="/getSolutionsOnload", method = RequestMethod.GET)
		@ResponseBody
		public SolutionOnLoadResp  getSolutionsOnload(){
			SolutionOnLoadResp solutionOnLoadResp  = new SolutionOnLoadResp();
			List<VendorsDTO> vendorsDTOs = apmApplicationService.getVendors();
			List<SystemTypeDTO> systemTypeDTOs = electionServices.getSystemTypes();
			List<LabVendorsDTO> labVendorsDTOs = electionServices.getLabVendors();
			List<HostingTypeDTO> hostingTypeDTOs = electionServices.getHostingTypes();
			List<SolutionTypeDTO> solutionTypeDTOs = apmApplicationService.getSolutionTypes();
			List<PrecinctTypeDTO> precinctTypeDTOs = electionServices.getPrecinctTypes();
			solutionOnLoadResp.setSolutionTypeDTOs(solutionTypeDTOs);
			solutionOnLoadResp.setLabVendorsDTOs(labVendorsDTOs);
			solutionOnLoadResp.setSystemTypeDTOs(systemTypeDTOs);
			solutionOnLoadResp.setVendorsDTOs(vendorsDTOs);
			solutionOnLoadResp.setHostingTypeDTOs(hostingTypeDTOs);
			solutionOnLoadResp.setPrecinctTypeDTOs(precinctTypeDTOs);
			return solutionOnLoadResp;
	    }
		
		
		@RequestMapping(value="/saveAppSolution", method = RequestMethod.POST)
		@ResponseBody
		public ApplicationResp saveAppSolution(@RequestParam(value = "appSolutionDocs", required=false) MultipartFile[] files,
				@RequestParam(value = "appSolutionString") String  appSolutionString){
			ApplicationSolutionDTO applicationSolutionDTO = new ApplicationSolutionDTO();
			ApplicationResp applicationResp = null;
			try {
				applicationSolutionDTO = new ObjectMapper().readValue(appSolutionString, ApplicationSolutionDTO.class);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			applicationResp = electionServices.saveAppSolution(applicationSolutionDTO);
				
			return applicationResp;
	    }
		
		
		@RequestMapping(value="/saveAppSolutionDevices", method = RequestMethod.POST)
		@ResponseBody
		public ApplicationResp saveAppSolutionDevices(@RequestParam(value = "appSolutionDocs", required=true) MultipartFile[] files,
				@RequestParam(value = "appSolutionDeviceString") String  appSolutionDeviceString){
			AppSolutionDevicesDTO appSolutionDeviceDTO = new AppSolutionDevicesDTO();
			ApplicationResp applicationResp = null;
			try {
				//System.out.println("checking for appSOlution device"+appSolutionDeviceString);
				appSolutionDeviceDTO = new ObjectMapper().readValue(appSolutionDeviceString, AppSolutionDevicesDTO.class);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			applicationResp = electionServices.saveAppSolutionDevices(appSolutionDeviceDTO,files);
				
			return applicationResp;
	    }
		
		
		
		@RequestMapping(value="/updateAppSolution", method = RequestMethod.POST)
		@ResponseBody
		public ApplicationResp updateAppSolution(@RequestParam(value = "appSolutionDocs", required=false) MultipartFile[] files,
				@RequestParam(value = "appSolutionString") String  appSolutionString){
			ApplicationSolutionDTO applicationSolutionDTO = new ApplicationSolutionDTO();
			ApplicationResp applicationResp = null;
			try {
				applicationSolutionDTO = new ObjectMapper().readValue(appSolutionString, ApplicationSolutionDTO.class);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			applicationResp = electionServices.updateAppSolution(applicationSolutionDTO);
				
			return applicationResp;
	    }
		
		
		@RequestMapping(value="/updateAppSolutionDevice", method = RequestMethod.POST)
		@ResponseBody
		public ApplicationResp updateAppSolutionDevice(@RequestParam(value = "appSolutionDeviceDocs", required=false) MultipartFile[] files,
				@RequestParam(value = "appSolutionDeviceString") String  appSolutionDeviceString){
			AppSolutionDevicesDTO appSolutionDevicesDTO = new AppSolutionDevicesDTO();
			ApplicationResp applicationResp = null;
			try {
				appSolutionDevicesDTO = new ObjectMapper().readValue(appSolutionDeviceString, AppSolutionDevicesDTO.class);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			applicationResp = electionServices.updateAppSolutionDevice(appSolutionDevicesDTO,files);
				
			return applicationResp;
	    }
		
		
		@RequestMapping(value="/getAppSolution", method = RequestMethod.GET)
		@ResponseBody
		public ApplicationSolutionDTO  getAppSolution(@RequestParam int  solutionId){
			SolutionOnLoadResp solutionOnLoadResp  = new SolutionOnLoadResp();
			ApplicationSolutionDTO applicationSolutionDTO = electionServices.getAppSolution(solutionId);
			return applicationSolutionDTO;
	    }

		
		@RequestMapping(value="/getAppMOUs", method = RequestMethod.GET)
		@ResponseBody
		public List<MOUDTO>  getAppMOUs(@RequestParam int  applicationID){
			List<MOUDTO> moudtos = apmApplicationService.getMOUs(applicationID);
			return moudtos;
	    }
		
		@RequestMapping(value="/getAllMOUs", method = RequestMethod.GET)
		@ResponseBody
		public List<MOUDTO>  getAllMOUs(){
			List<MOUDTO> moudtos = apmApplicationService.getAllMOUs();
			return moudtos;
	    }
		
		@RequestMapping(value="/getLocForMous", method = RequestMethod.GET)
		@ResponseBody
		public List<MOUDTO> getLocForMous(){
			List<MOUDTO> moudtos = apmApplicationService.getLocForMous();
			return moudtos;
	    }
		
		@RequestMapping(value="/getSysForMous", method = RequestMethod.GET)
		@ResponseBody
		public List<MOUDTO> getSysForMous(){
			List<MOUDTO> moudtos = apmApplicationService.getSysForMous();
			return moudtos;
	    }
		
		@RequestMapping(value="/getLocForDevices", method = RequestMethod.GET)
		@ResponseBody
		public List<AppSolutionDevicesDTO> getLocForDevices(){
			List<AppSolutionDevicesDTO> appSolutionDeviceDTOs = electionServices.getLocForDevices();
			return appSolutionDeviceDTOs;
	    }
		
		@RequestMapping(value="/getAllTotals", method = RequestMethod.GET)
		@ResponseBody
		public List<Integer> getAllTotals(){
			List<Integer> AllTotals = electionServices.getAllTotals();
			return AllTotals;
		}
		
		
		@RequestMapping(value="/getSolutionFile", method = RequestMethod.GET)
		@ResponseBody
		public void getSolutionFile(@RequestParam int fileID,final HttpServletRequest request, final HttpServletResponse response){
			
			String fileName = electionServices.getSolutionFile(fileID);
			File file = new File(fileName);
			 String nameArray[] = fileName.split("/.");
			 String extension = nameArray[nameArray.length-1];
			 
	        try (InputStream fileInputStream = new FileInputStream(file);
	                OutputStream output = response.getOutputStream();) {
	        	if(extension.equalsIgnoreCase("XLS") || extension.equalsIgnoreCase("XLX") ||extension.equalsIgnoreCase("CVS"))
		            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		        	else if(extension.equalsIgnoreCase("DOC") || extension.equalsIgnoreCase("DOCX"))
		        		  response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
		        	else if(extension.equalsIgnoreCase("PDF"))
		        		 response.setContentType("application/pdf");

	            response.setHeader("File-Name", file.getName());
	            response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
	            output.write(IOUtils.toByteArray(fileInputStream));
	            //IOUtils.copyLarge(fileInputStream, output);
	            output.flush();
	            output.close();
	        } catch (IOException e) {
	        	e.printStackTrace();
	        }
	    }
		//saveAppSolution?vendorId, updateMou
		
		@RequestMapping(value="/getPrecinctTypes", method = RequestMethod.GET)
		@ResponseBody
		public List<PrecinctTypeDTO>  getPrecinctTypes(){
			List<PrecinctTypeDTO> precinctTypeDTOs = electionServices.getPrecinctTypes();
			return precinctTypeDTOs;
	    }
		
		
		@RequestMapping(value="/uploadAppSolutionDeviceDocuments", method = RequestMethod.POST)
		@ResponseBody
		public ApplicationResp uploadAppSolutionDeviceDocuments(@RequestParam(value = "files", required=true) MultipartFile[] files,
				@RequestParam(value = "device", required=true) String AppSolutionDevicesDTOStr){
			
			AppSolutionDevicesDTO appSolutionDevicesDTO = null;
			ApplicationResp appResponse = new ApplicationResp();
			try {
				appSolutionDevicesDTO = new ObjectMapper().readValue(AppSolutionDevicesDTOStr, AppSolutionDevicesDTO.class);
				appResponse = apmApplicationService.uploadPolicyDocuments(files,appSolutionDevicesDTO);
				return appResponse;
			} catch (IOException e) {
				e.printStackTrace();
			}
			return appResponse;
	    }
		
		
		
		
		
		
		
		@RequestMapping(value="/getDeviceFile", method = RequestMethod.GET)
		@ResponseBody
		public void getDeviceFile(@RequestParam int deviceId,final HttpServletRequest request, final HttpServletResponse response){
			
			String fileName = apmApplicationService.getDeviceFile(deviceId);
			File file = new File(fileName);
			 String nameArray[] = fileName.split("/.");
			 String extension = nameArray[nameArray.length-1];
			 
	        try (InputStream fileInputStream = new FileInputStream(file);
	                OutputStream output = response.getOutputStream();) {
	        	System.out.println(file.length());
	        	if(extension.equalsIgnoreCase("XLS") || extension.equalsIgnoreCase("XLX") ||extension.equalsIgnoreCase("CVS"))
		            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		        	else if(extension.equalsIgnoreCase("DOC") || extension.equalsIgnoreCase("DOCX"))
		        		  response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
		        	else if(extension.equalsIgnoreCase("PDF"))
		        		 response.setContentType("application/pdf");

	            response.setHeader("File-Name", file.getName());
	            response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
	            output.write(IOUtils.toByteArray(fileInputStream));
	            //IOUtils.copyLarge(fileInputStream, output);
	            output.flush();
	            output.close();
	        } catch (IOException e) {
	        	e.printStackTrace();
	        }
	    }
		
		
		@RequestMapping(value="/uploadPolicyDocuments", method = RequestMethod.POST)
		@ResponseBody
		public PolicyResponse uploadPolicyDocuments(@RequestBody List<PolicyDocumentsDTO> policyDocumentsDTO){
			
			//PolicyDocumentsDTO policyDocDTO = null;
			PolicyResponse policyResponse = new PolicyResponse();
			//try {
			//policyDocDTO = new ObjectMapper().readValue(policyDocumentsDTO, PolicyDocumentsDTO.class);
		    policyResponse = policyServices.uploadPolicyDocuments(policyDocumentsDTO);
//			}
//			catch(IOException e)
//			{
//				e.printStackTrace();
//			}
			return policyResponse;
	    }

}
